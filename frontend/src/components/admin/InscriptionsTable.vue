<template>
  <div class="inscriptions-table">
    <h3>Inscriptions pour le salon "{{ salon.nom }}"</h3>
    <!-- Bouton pour exporter en Excel -->
    <button @click="exportToExcel" class="export-button">Exporter en Excel</button>
    <table v-if="inscriptions.length > 0">
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
      <tr v-for="ins in inscriptions" :key="ins.id">
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
</template>

<script setup>
import { ref, onMounted, watch, defineProps } from 'vue'
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
  if (!props.salon || !props.salon.id) {
    return;
  }
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

// Fonction d'exportation en Excel (.xlsx)
function exportToExcel() {
  // Convertir les inscriptions en worksheet
  const worksheet = XLSX.utils.json_to_sheet(inscriptions.value)
  // Créer un nouveau classeur
  const workbook = XLSX.utils.book_new()
  XLSX.utils.book_append_sheet(workbook, worksheet, "Inscriptions")
  // Générer le buffer Excel
  const excelBuffer = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' })
  // Créer un Blob pour le fichier
  const dataBlob = new Blob([excelBuffer], {
    type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8'
  })
  // Déclencher le téléchargement
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

.export-button {
  padding: 0.5rem 1rem;
  margin-bottom: 1rem;
  background-color: #007BFF;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.export-button:hover {
  background-color: #0056b3;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 1rem;
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
