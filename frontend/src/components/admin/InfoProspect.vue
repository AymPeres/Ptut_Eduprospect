<template>
  <div class="info-prospect">
    <h1>Inscriptions pour le salon : {{ salon }}</h1>
    <!-- InscriptionsTable affichera uniquement les inscriptions filtrées par salon -->
    <InscriptionsTable :salon="salon" />
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router'
import InscriptionsTable from '@/components/admin/InscriptionsTable.vue'

const route = useRoute()
// On suppose que le paramètre de route s'appelle "salon"
const salon = route.params.salon
</script>

<style scoped>
.info-prospect {
  padding: 20px;
}
</style>
