<template>
  <div class="inscriptions-table">
    <h3>Inscriptions pour le salon "{{ salon.nom }}"</h3>
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
import { ref, onMounted, watch } from 'vue'

// Définir le prop "salon" attendu
const props = defineProps({
  salon: {
    type: Object,
    required: true,
  },
})

const inscriptions = ref([])

// Fonction asynchrone pour récupérer les inscriptions filtrées par salonId
async function fetchInscriptions() {
  if (!props.salon || !props.salon.id) {
    // Si le salon n'est pas défini ou n'a pas d'ID, on ne fait rien
    return
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

// Appeler fetchInscriptions quand le composant est monté
onMounted(fetchInscriptions)

// Refetch quand le prop "salon" change
watch(() => props.salon, () => {
  fetchInscriptions()
})
</script>

<style scoped>
.inscriptions-table {
  font-family: 'Plus Jakarta Sans', sans-serif;
  width: 100%;
  margin-top: 20px;
  color: #181818;
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
