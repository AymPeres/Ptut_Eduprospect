<template>
  <div class="admin-layout">
    <div class="background-container">
      <div class="rectangle-background-blanc"></div>
      <div class="rectangle-background-orange"></div>
      <div class="background-overlay"></div>
      <div class="background-top-right"></div>
      <div class="background-top-left"></div>
      <div class="background-top-rectangle"></div>


    </div>

    <main>
      <router-view />

    </main>
  </div>
</template>

<script>
export default {
  name: "AdminLayout",
};
</script>

<style scoped>
/* Import de la police depuis Google Fonts */
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

* {
  box-sizing: border-box;
}

body {
  font-size: 14px;
}

.admin-layout {
  position: relative;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.background-container {
  width: 100%;
  height: 1024px;
  position: absolute;
  top: 0;
  left: 0;
  overflow: hidden;
  background-color: rgba(144, 89, 160, 1);
  opacity: 1;
}

.rectangle-background-blanc {
  width: 547px;
  height: 547px;
  background: url("@/assets/images/designElement/RectangleVideBlanc.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 710px;
  left: 200px;
  border-radius: 135px;
  transform: scaleX(-1);
}

.rectangle-background-orange {
  width: 550px;
  height: 550px;
  background: url("@/assets/images/designElement/RectangleRayeOrange.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 1;
  position: absolute;
  top: 730px;
  left: 240px;
}

.background-overlay {
  width: 251px;
  height: 340px;
  background: url("@/assets/images/logoIsis/logo-ISIS-horizontal-BLANC-rogne.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: cover;
  opacity: 0.6;
  position: absolute;
  top: 342px;
  left: 755px;
}

/* Nouveau style pour l'élément en haut à droite */
.background-top-right {
  position: absolute;
  top: 120px;        /* Espacement du bord supérieur */
  right: 20px;      /* Espacement du bord droit */
  width: 200px;     /* Largeur de l'élément */
  height: 200px;    /* Hauteur de l'élément */
  background-image: url("@/assets/images/designElement/Trait2PointsBlancOrange.png"); /* Remplace "tonImage.png" par le chemin de ton image */
  background-size: cover; /* Ajuste l'image à la taille de l'élément */
  background-repeat: no-repeat;
}


.background-top-rectangle {
  position: absolute;
  top: -250px;
  right: -200px;
  width: 650px;
  height: 650px;
  background-image: url("@/assets/images/designElement/RectangleRayeBlanc.png");
  background-size: cover;
  background-repeat: no-repeat;
}

main {
  flex: 1;
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 2rem;
}
</style>
