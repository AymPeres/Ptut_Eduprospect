<template>
  <div class="footer-statistique">
    <div class="logo">
      <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.png" alt="Logo de l'école" />
    </div>
    <div class="content">
      <p>Statistiques et informations</p>
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterStatistique",
};
</script>

<style scoped>
.footer-statistique {
  position: absolute;
  top: 0;
  left: 0;
  width: 300px;
  min-height: 100vh; /* S'assure que la sidebar s'étend sur toute la hauteur de la fenêtre */
  background-color: white;
}

.logo img {
  width: 200px; /* Taille du logo */
  height: auto;
}

.content {
  color: #333; /* Pour que le texte soit visible sur fond blanc */
  font-size: 0.9rem;
  margin-top: 20px;
  text-align: center;
}
</style>
