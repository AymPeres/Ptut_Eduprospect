<template>
  <button class="disconnect-button" @click="confirmDisconnect">
    Déconnexion
  </button>
</template>

<script>
export default {
  name: "DisconnectButton",
  methods: {
    confirmDisconnect() {
      const userConfirmed = window.confirm("Voulez-vous vraiment vous déconnecter ?");
      if (userConfirmed) {
        this.disconnect();
      }
    },
    disconnect() {
      // Logique de déconnexion, par exemple redirection vers la page de login
      this.$router.push('..');
    }
  }
};
</script>

<style scoped>
.disconnect-button {
  position: relative;
  top: -18px;       /* Positionne selon ton layout */
  left: 200px;      /* Positionne selon ton layout */
  background-color: #ED6962; /* Couleur orange */
  color: white;
  border: none;
  cursor: pointer;
  font-size: 20px;
  padding: 0.75rem 1.5rem;  /* Espace intérieur pour une apparence de barre */
  border-radius: 25px;       /* Angles arrondis pour une "pill" */
  transition: background 0.3s ease, transform 0.2s;

}

.disconnect-button:hover {
    background-color: #d85a53; /* Légèrement plus foncé au survol */
    transform: scale(1.05);
  }
</style>
