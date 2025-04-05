<template>
  <div class="formulaire">
    <HomeButton />
    <!-- Intégration du composant Navigation2 pour la sélection -->
    <Navigation2 />
  </div>
</template>

<script setup>
import Navigation2 from '@/components/formulaire/Navigation2.vue'
import HomeButton from "@/components/formulaire/HomeButton.vue"
</script>

<style scoped>
.formulaire {
  padding: 1rem;
}
</style>
