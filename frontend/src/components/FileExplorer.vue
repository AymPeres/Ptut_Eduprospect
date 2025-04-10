<template>
  <div>
    <h1>Explorateur de Fichiers</h1>

    <!-- 1) Affiche "Chargement..." tant que loading = true -->
    <div v-if="loading">
      Chargement...
    </div>

    <!-- 2) Quand loading = false, on regarde si on a des dossiers -->
    <div v-else>
      <!-- S'il y a des dossiers, on affiche la liste -->
      <div v-if="treeData.length > 0">
        <FolderItem
          v-for="item in treeData"
          :key="item.id"
          :item="item"
          @refresh="fetchTree"
        />
      </div>
      <!-- Sinon, on affiche un message indiquant qu'il n'y a rien à afficher -->
      <div v-else>
        Aucun dossier à afficher.
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import FolderItem from './FolderItem.vue'

export default {
  name: "FileExplorer",
  components: { FolderItem },
  data() {
    return {
      treeData: [],
      loading: true // booléen pour gérer l'état de chargement
    }
  },
  methods: {
    fetchTree() {
      // Appel à le endpoint back-end
      axios.get('/api/files')
        .then(response => {
          // Stocke la réponse dans treeData
          this.treeData = response.data
          // Fin du chargement
          this.loading = false
        })
        .catch(error => {
          console.error("Erreur lors de la récupération de l'arborescence :", error)

          this.loading = false
        })
    }
  },
  mounted() {

    this.fetchTree()
  }
}
</script>
