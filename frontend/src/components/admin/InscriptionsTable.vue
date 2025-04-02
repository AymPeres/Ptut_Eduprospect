<template>
  <div class="inscriptions-table">
    <h2>Liste des Inscriptions</h2>

    <!-- Barre de recherche -->
    <div class="search-bar">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="Rechercher par nom ou prénom..."
      />
      <button @click="filterInscriptions">Search</button>
    </div>

    <!-- Tableau d'affichage -->
    <table>
      <thead>
      <tr>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Formation</th>
        <th>Ville</th>
        <th>Mail</th>
        <th>Téléphone</th>
        <th>Département</th>
      </tr>
      </thead>
      <tbody>
      <tr
        v-for="inscription in filteredInscriptions"
        :key="inscription.id"
      >
        <td>{{ inscription.nom }}</td>
        <td>{{ inscription.prenom }}</td>
        <td>{{ inscription.formation }}</td>
        <td>{{ inscription.ville }}</td>
        <td>{{ inscription.email }}</td>
        <td>{{ inscription.telephone }}</td>
        <!--
          Si tu gères un champ "codePostal" pour le département,
          tu peux l'afficher directement.
          Ou bien, s'il faut extraire le département du code postal,
          tu peux le faire via une petite logique en JS.
        -->
        <td>{{ inscription.codePostal }}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'

const inscriptions = ref([])
const searchQuery = ref('')

// Au montage du composant, on récupère toutes les inscriptions
onMounted(fetchInscriptions)

async function fetchInscriptions() {
  try {
    const response = await fetch('http://localhost:8989/api/inscriptions')
    if (!response.ok) {
      throw new Error(`Erreur HTTP : ${response.status}`)
    }
    const data = await response.json()
    inscriptions.value = data
  } catch (error) {
    console.error('Erreur lors de la récupération des inscriptions :', error)
  }
}

// Méthode de filtrage (simple) pour la barre de recherche
function filterInscriptions() {
  // On n'a pas forcément besoin de faire quoi que ce soit ici
  // si on utilise la propriété calculée "filteredInscriptions"
  // qui se mettra à jour toute seule quand searchQuery change.
}

// On calcule les inscriptions filtrées (par nom ou prénom)
const filteredInscriptions = computed(() => {
  // Si le champ de recherche est vide, on renvoie toutes les inscriptions
  if (!searchQuery.value) {
    return inscriptions.value
  }
  // Sinon, on filtre par nom ou prénom
  return inscriptions.value.filter(ins => {
    const nomMatch = ins.nom?.toLowerCase().includes(searchQuery.value.toLowerCase())
    const prenomMatch = ins.prenom?.toLowerCase().includes(searchQuery.value.toLowerCase())
    return nomMatch || prenomMatch
  })
})
</script>

<style scoped>
.inscriptions-table {
  width: 100%;
  max-width: 900px;
  margin: 0 auto;
  padding: 1rem;
}

.search-bar {
  display: flex;
  align-items: center;
  margin-bottom: 1rem;
}

.search-bar input {
  flex: 1;
  padding: 0.5rem;
  margin-right: 0.5rem;
}

.search-bar button {
  padding: 0.5rem 1rem;
  cursor: pointer;
}

/* Style du tableau */
table {
  width: 100%;
  border-collapse: collapse;
}

thead {
  background-color: #eee;
}

th, td {
  border: 1px solid #ccc;
  padding: 0.75rem;
  text-align: left;
}
</style>
