<template>
  <button class="stat-button" @click="goToStats">
    Statistiques
  </button>
</template>

<script>
export default {
  name: "StatButton",
  methods: {
    goToStats() {
      // Redirige vers la page "statistiques"
      this.$router.push("/admin/statistiques");
      // Ou si tu as nommé ta route :
      // this.$router.push({ name: "Statistiques" });
    },
  },
};
</script>

<style scoped>
.stat-button {
  background-color: #f0746c; /* Couleur corail/saumon comme sur l'image */
  color: white;
  font-weight: 500; /* Un peu moins bold que votre version */
  border: none;
  border-radius: 20px; /* Coins plus arrondis */
  padding: 8px 16px; /* Ajustement du padding pour une forme plus ovale */
  cursor: pointer;
  font-size: 14px; /* Taille de police ajustée */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Légère ombre comme sur l'image */
  transition: background-color 0.2s, transform 0.1s;
}

.stat-button:hover {
  background-color: #e56962; /* Version légèrement plus foncée au survol */
  transform: translateY(-1px); /* Effet subtil de soulèvement */
}

.stat-button:active {
  transform: translateY(1px); /* Effet d'enfoncement au clic */
}
</style>
