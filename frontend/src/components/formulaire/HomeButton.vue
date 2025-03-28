<template>
  <button @click="goHome" class="home-button">
    <!-- SVG de la maison en blanc -->
    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24" height="24">
      <path d="M12 3l10 9h-3v7h-6v-5h-2v5H3v-7H0z" fill="white"/>
    </svg>
  </button>
</template>

<script>
export default {
  name: "HomeButton",
  methods: {
    goHome() {
      const motDePasse = prompt("Entrez le mot de passe pour revenir à l'accueil :");
      if (motDePasse === null) return;
      if (motDePasse === "1234") {
        this.$router.push("/");
      } else {
        alert("Mot de passe incorrect !");
      }
    },
  },
};
</script>

<style scoped>
.home-button {
  position: fixed;
  top: 20px;
  left: 20px;
  padding: 10px;
  background-color: #FA7268;
  color: white;
  border: none;
  border-radius: 50%;
  font-size: 1.5rem;
  cursor: pointer;
  transition: background 0.3s;
  display: flex;
  align-items: center;
  justify-content: center;
}

.home-button svg {
  width: 1.5rem;
  height: 1.5rem;
}

.home-button:hover {
  background-color: #d95a50;
}
</style>
