<template>
  <div class="footer-statistique">
    <div class="logo">
      <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.png" alt="Logo de l'école" />
    </div>
    <div class="content">
      <!-- Ajoutez ici tout autre contenu nécessaire -->
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
  position:absolute;
  top: 0;
  left: 0;
  width: 300px;
  height: 1024px;
  background-color: white;
}



.logo img {
  width: 200px;             /* Taille du logo */
  height: auto;
}

.content {
  color: white;
  font-size: 0.9rem;
  margin-top: 20px;
  text-align: center;
}
</style>
