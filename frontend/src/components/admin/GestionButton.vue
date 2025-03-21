<template>
  <button class="button" @click="goToAdmin">
    Admin
  </button>
</template>

<script>
export default {
  name: "GestionButton",
  methods: {
    goToAdmin() {
      this.$router.push({ name: "AdminPage" });
    },
  },
};
</script>

<style scoped>
.button {
  background-color: #ED6962; /* Orange/corail comme sur votre maquette */
  color: #ffffff;
  border: none;
  width: 120px; /* Un peu plus large pour contenir "Statistiques" */
  height: 40px;
  border-radius: 100px;
  text-decoration: none;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1rem;
  font-weight: bold;
  transition: background 0.3s ease, transform 0.2s;
  cursor: pointer;
}

.button:hover {
  background-color: #d85a53; /* Légèrement plus foncé au survol */
}


</style>
