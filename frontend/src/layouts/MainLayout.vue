<template>
  <div class="admin-layout">
    <header>
      <h1 class="title">Eduprospect</h1>
      <img
        src="@/assets/images/logoIsis/logo-ISIS-horizontal-BLANC-rogne.png"
        alt="Logo Eduprospect"
        class="logo"
      />
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
  background: #2F2769;
  min-height: 100vh;
  color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
}

header {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 2rem;
}

.title {
  font-family: "Plus Jakarta Sans", sans-serif; /* Application de la police */
  font-size: 3rem;
  font-weight: bold;
  margin-bottom: 1rem;
  color: #FA7268;
}

.logo {
  height: 250px;
  margin-bottom: 1rem;
}

main {
  flex: 1;
  width: 100%;
  display: flex;
  justify-content: center;
  padding: 2rem;
}
</style>
