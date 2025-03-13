<template>
  <div class="admin-layout">
    <div class="background-container">
      <div class="rectangle-background-blanc"></div>
      <div class="rectangle-background-orange"></div>
      <div class="logo-background"></div>
      <div class="background-overlay"></div>
    </div>

    <main>
      <header>
        <h1 class="title">Eduprospect</h1>
      </header>
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
  left: 270px;
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
  left: 300px;
}

.logo-background {
  width: 148px;
  height: 101px;
  background: url("@/assets/images/designElement/Trait2PointsBlancOrange.png");
  background-repeat: no-repeat;
  background-position: center center;
  background-size: contain;
  opacity: 1;
  position: absolute;
  top: 206px;
  left: 1292px;
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


main {
  flex: 1;
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 2rem;
}

.title {
  font-family: "Plus Jakarta Sans", sans-serif;
  font-size: 3rem;
  font-weight: bold;
  margin-top: 2rem;
  margin-bottom: 1rem;
  color: #fa7268;
}
</style>
