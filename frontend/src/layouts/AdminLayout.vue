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

<!--    &lt;!&ndash; Ajout du header qui contiendra le bouton statistiques &ndash;&gt;-->
<!--    <header class="admin-header">-->
<!--      <div class="admin-title">Espace Administrateur</div>-->
<!--      <div class="admin-actions">-->
<!--        <StatButton />-->
<!--      </div>-->
<!--    </header>-->

    <main>
      <router-view />
      <FooterStatistique />
    </main>
  </div>
</template>

<script>
import FooterStatistique from "@/components/admin/FooterStatistique.vue";
import StatButton from "@/components/admin/StatButton.vue";

export default {
  name: "AdminLayout",
  components: {
    FooterStatistique,
    StatButton,
  },
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

/* Nouveau style pour l'en-tête administrateur */
.admin-header {
  position: relative;
  z-index: 10; /* Pour s'assurer qu'il est au-dessus des éléments de fond */
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 24px;
}

.admin-title {
  color: white;
  font-size: 18px;
  font-weight: 500;
  font-family: 'Plus Jakarta Sans', sans-serif;
}

.admin-actions {
  /* Conteneur pour le bouton, ce qui permet de placer d'autres éléments à côté si nécessaire */
}

.background-container {
  width: 100%;
  min-height: 100vh;
  position: absolute;
  top: 0;
  left: 0;
  background-color: rgba(144, 89, 160, 1);
}

/* Les autres styles restent inchangés */
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
  left: 650px;
}

.background-top-right {
  position: absolute;
  top: 200px;
  right: 20px;
  width: 200px;
  height: 200px;
  background-image: url("@/assets/images/designElement/Trait2PointsBlancOrange.png");
  background-size: cover;
  background-repeat: no-repeat;
}

.background-top-left {
  position: absolute;
  top: -175px;
  right: 600px;
  width: 400px;
  height: 400px;
  background-image: url("@/assets/images/designElement/Trait2PointsOrangeBlancOrange.png");
  background-size: cover;
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
  margin-top: 40px; /* Ajout d'une marge en haut pour éviter que le contenu chevauche le header */
}
</style>
