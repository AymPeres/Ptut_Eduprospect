<template>
  <div class="inscriptions-table">
    <div class="main-content">
    <h3>Inscriptions pour le salon "{{ salon.nom }}"</h3>
    <div class="controls">
      <button @click="exportToExcel" class="export-button">Exporter en Excel</button>
      <label for="sortField">Trier par :</label>
      <select id="sortField" v-model="sortField">
        <option value="">Aucun</option>
        <option value="nom">Nom</option>
        <option value="prenom">Prénom</option>
        <option value="formation">Formation</option>
        <option value="ville">Ville</option>
        <option value="codePostal">Code Postal</option>
      </select>
      <button @click="toggleSortDirection" class="sort-direction-button">
        {{ sortDirection === 'asc' ? 'Ascendant' : 'Descendant' }}
      </button>
    </div>
    <table v-if="sortedInscriptions.length > 0">
      <thead>
      <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Formation</th>
        <th>Ville</th>
        <th>Email</th>
        <th>Téléphone</th>
        <th>Code Postal</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="ins in sortedInscriptions" :key="ins.id">
        <td>{{ ins.nom }}</td>
        <td>{{ ins.prenom }}</td>
        <td>{{ ins.formation }}</td>
        <td>{{ ins.ville }}</td>
        <td>{{ ins.email }}</td>
        <td>{{ ins.telephone }}</td>
        <td>{{ ins.codePostal }}</td>
      </tr>
      </tbody>
    </table>
    <p v-else>Aucune inscription pour ce salon.</p>
  </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch, computed, defineProps } from 'vue'
import * as XLSX from 'xlsx'
import { saveAs } from 'file-saver'

const props = defineProps({
  salon: {
    type: Object,
    required: true,
  },
})

const inscriptions = ref([])

// Fonction pour récupérer les inscriptions filtrées par salonId
async function fetchInscriptions() {
  if (!props.salon || !props.salon.id) return
  try {
    const response = await fetch(`http://localhost:8989/api/inscriptions?salonId=${props.salon.id}`)
    if (!response.ok) {
      throw new Error(`Erreur HTTP: ${response.status}`)
    }
    inscriptions.value = await response.json()
  } catch (error) {
    console.error("Erreur fetch inscriptions:", error)
  }
}

onMounted(fetchInscriptions)
watch(() => props.salon, () => {
  fetchInscriptions()
})

// Variables pour le tri
const sortField = ref('')
const sortDirection = ref('asc')

// Propriété calculée pour retourner les inscriptions triées
const sortedInscriptions = computed(() => {
  if (!sortField.value) return inscriptions.value
  return [...inscriptions.value].sort((a, b) => {
    let aField = a[sortField.value] ?? ''
    let bField = b[sortField.value] ?? ''
    aField = aField.toString().toLowerCase()
    bField = bField.toString().toLowerCase()
    if (aField < bField) return sortDirection.value === 'asc' ? -1 : 1
    if (aField > bField) return sortDirection.value === 'asc' ? 1 : -1
    return 0
  })
})

function toggleSortDirection() {
  sortDirection.value = sortDirection.value === 'asc' ? 'desc' : 'asc'
}

// Fonction pour exporter en Excel (.xlsx)
function exportToExcel() {
  const worksheet = XLSX.utils.json_to_sheet(inscriptions.value)
  const workbook = XLSX.utils.book_new()
  XLSX.utils.book_append_sheet(workbook, worksheet, "Inscriptions")
  const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' })
  const dataBlob = new Blob([excelBuffer], {
    type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8'
  })
  saveAs(dataBlob, "Inscriptions.xlsx")
}
</script>

<style scoped>
.inscriptions-table {
  font-family: 'Plus Jakarta Sans', sans-serif;
  width: 100%;
  margin-top: 20px;
  color: #181818;
}

.controls {
  display: flex;
  align-items: center;
  gap: 1rem;
  margin-bottom: 1rem;
}

/* Bouton Export en orange (#ED6962) avec angles arrondis (100px) */
.export-button {
  padding: 0.5rem 1rem;
  background-color: #ED6962;
  color: white;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  font-weight: bold;
}
/* Style un peu plus gros du selecteur */

#sortField {
  padding: 0.3rem;
  border-radius: 5px;
  font-size: 1rem;
}
/* Zone principale (le reste de l'écran) */
.main-content {
  margin-left: 315px; /* Laisse la place pour la sidebar */
  margin-top: 200px;
  margin-right: -35px;
  padding: 20px;
  height: 100%;
  overflow-y: auto;
  background-color: #fff; /* Couleur de fond optionnelle */
}
.export-button:hover {
  background-color: #e05e57;
}

/* Bouton de tri mis à jour pour correspondre au style */
.sort-direction-button {
  padding: 0.5rem 1rem;
  background-color: #ED6962;
  color: white;
  border: none;
  border-radius: 100px;
  cursor: pointer;
  font-weight: bold;
}

.sort-direction-button:hover {
  background-color: #e05e57;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 1rem;
  background-color: #FFFFFF;
}

th, td {
  border: 1px solid #ccc;
  padding: 8px;
  text-align: left;
}

thead {
  background-color: #f0f0f0;
}
</style>
