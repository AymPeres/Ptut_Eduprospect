<template>
  <div class="footer-statistique">
    <div class="logo">
      <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.png" alt="Logo de l'école" />
    </div>
    <div class="content">
      <p>Statistiques</p>
    </div>
    <div class="buttons">
      <button class="stat-button">Proportion par formation</button>
      <button class="stat-button">Villes/Années/Salons</button>
      <button class="stat-button">Statut</button>
      <button class="stat-button">Cycle</button>
      <button class="stat-button">Connaître Isis</button>
      <button class="stat-button">Genre</button>
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
  display: flex;
  flex-direction: column;
  align-items: center;
}

.logo img {
  width: 150px; /* Taille du logo */
  height: auto;
}

.content {
  color: #333; /* Pour que le texte soit visible sur fond blanc */
  font-size: 1rem;
  margin: 20px 0;
  text-align: center;
  font-weight: bold;
}

.buttons {
  display: flex;
  flex-direction: column;
  gap: 15px;
  width: 100%;
  align-items: center;
  margin-top: 20px;
}

.stat-button {
  background-color: #f1645d;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 20px;
  font-size: 0.9rem;
  cursor: pointer;
  transition: 0.3s;
  width: 80%;
  text-align: center;
}

.stat-button:hover {
  background-color: #d14a44;
}
</style>
