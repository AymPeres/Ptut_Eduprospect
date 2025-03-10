<template>
  <div class="admin-layout">
    <header>
      <img
        src="@/assets/images/logoIsis/logo-ISIS-horizontal-BLANC-rogne.png"
        alt="Logo Eduprospect"
        class="logo"
      />
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
  // Tu peux ajouter data(), computed, methods, etc. ici si nécessaire
};
</script>

<style scoped>
.admin-layout {
  background: #2F2769;
  min-height: 100vh;
  color: #fff;
  display: flex;
  flex-direction: column;
}

header {
  display: flex;
  align-items: center;       /* centre verticalement */
  justify-content: center;   /* centre horizontalement */
  padding: 1rem;
}

.logo {
  height: 300px;
  margin-right: 1rem;
}

.title {
  font-size: 1.8rem;
  font-weight: bold;
  margin: 0;
}

main {
  flex: 1;
  padding: 2rem;
}
</style>
