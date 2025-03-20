<template>
  <div class="admin-layout">
    <header>
      <h1 class="title">Eduprospect</h1>
    </header>

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

<style>
/* Import de la police depuis Google Fonts */
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

.admin-layout {
  /* Fond violet + image en background */
  min-height: 100vh;
  background-color: #2F2769;
  background-image: url("@/assets/images/logoIsis/logo-ISIS-horizontal-BLANC-rogne.png");
  background-repeat: no-repeat;
  background-position: center;
  background-size: 35%;

  /* Mise en page générale */
  color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.title {
  font-family: "Plus Jakarta Sans", sans-serif;
  font-size: 3rem;
  font-weight: bold;
  margin-top: 2rem;
  margin-bottom: 1rem;
  color: #ED6962;
}

main {
  flex: 1;
  width: 100%;
  display: flex;
  justify-content: center;
}
</style>
