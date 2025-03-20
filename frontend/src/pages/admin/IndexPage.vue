<template>
  <div class="index-page">
    <DisconnectButton />
    <div class="top-right-button">
      <StatButton />
    </div>
  </div>
</template>

<script>
import StatButton from "@/components/admin/statistiques/StatButton.vue";
import DisconnectButton from "@/components/admin/DisconnectButton.vue";

export default {
  name: "IndexPage",
  components: {
    StatButton,
    DisconnectButton,
  },
};
</script>

<style scoped>
/* Le conteneur global */
.index-page {
  position: relative;
  width: 100%;
  height: 100vh;
}

/* Le conteneur qui place le bouton en haut à droite */
.top-right-button {
  position: absolute;
  top: 20px;
  right: 20px;
  z-index: 999;
}


</style>
