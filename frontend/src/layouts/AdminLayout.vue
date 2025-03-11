<template>
  <div class="admin-layout">
    <header>
      <!-- Tu peux afficher ici le logo et le titre si nécessaire -->
      <h1>Admin Zone</h1>
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
