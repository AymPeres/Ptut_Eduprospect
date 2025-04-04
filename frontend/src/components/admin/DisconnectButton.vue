<template>
  <button class="disconnect-button" @click="confirmDisconnect">Déconnexion</button>
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
      this.$router.push('/admin/login');
    }
  }
};
</script>

<style scoped>
.disconnect-button {
  position: absolute;
  top: -18px; /* Ajustez selon vos besoins */
  left: 500px; /* Ajustez selon vos besoins */
  background-color: transparent; /* Fond transparent */
  color: white; /* Couleur du texte */
  border: none; /* Pas de bordure */
  cursor: pointer;
  font-size: 20px; /* Taille du texte */
  padding: 0;
  width: auto; /* Largeur automatique */
  height: auto; /* Hauteur automatique */

}

.disconnect-button:hover {
  transform: scale(1.05);
}
</style>
