<template>
  <div class="footer-statistique">
    <div class="logo">
      <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.png" alt="Logo de l'école" />
    </div>
    <div class="content">
      <p>Statistiques</p>
    </div>
    <div class="buttons">
      <button class="stat-button" @click="showFormationChart">Proportion par formation</button>
      <button class="stat-button" @click="showVillesAnneesSalonsChart">Villes/Années/Salons</button>
      <button class="stat-button" @click="showStatutChart">Statut</button>
      <button class="stat-button" @click="showCycleChart">Cycle</button>
      <button class="stat-button" @click="showConnaitreIsisChart">Connaître Isis</button>
      <button class="stat-button" @click="showGenreChart">Genre</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FooterStatistique",
  methods: {
    showFormationChart() {
      this.$emit('show-formation-chart');
    },
    showVillesAnneesSalonsChart() {
      this.$emit('show-villes-annees-salons');
    },
    showStatutChart() {
      this.$emit('show-statut-chart');
    },
    showCycleChart() {
      this.$emit('show-cycle-chart');
    },
    showConnaitreIsisChart() {
      this.$emit('show-connaitre-isis-chart');
    },
    showGenreChart() {
      this.$emit('show-genre-chart');
    }
  }
};
</script>

<style scoped>
.footer-statistique {
  position: fixed;
  top: 0;
  left: 0;
  width: 300px;
  height: 100vh;
  background-color: white;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px 0;
  box-shadow: 2px 0 5px rgba(0,0,0,0.1);
  z-index: 1000;
}

.logo img {
  width: 200px;
  height: auto;
  margin-bottom: 20px;
}

.content {
  color: #333;
  font-size: 1.2rem;
  margin: 10px 0 20px;
  text-align: center;
  font-weight: bold;
}

.buttons {
  display: flex;
  flex-direction: column;
  gap: 12px;
  width: 100%;
  padding: 0 20px;
}

.stat-button {
  background-color: #f1645d;
  color: white;
  border: none;
  padding: 12px;
  border-radius: 25px;
  font-size: 0.9rem;
  cursor: pointer;
  transition: all 0.3s ease;
  width: 100%;
  text-align: center;
}

.stat-button:hover {
  background-color: #d14a44;
  transform: translateY(-2px);
  box-shadow: 0 2px 5px rgba(0,0,0,0.2);
}
</style>
