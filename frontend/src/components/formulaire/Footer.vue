<template>
  <footer class="footer">
    <div class="footer-content">
      <!-- Partie gauche : Logo ISIS -->

      <div class="partners-left">
        <img src="@/assets/images/logoIsis/logo-ISIS-horizontal-RVB.svg" alt="logo isis" class="partner-logo-isis" />
        <div class="address">
          <p>École d'ingénieur ISIS</p>
          <p>Campus Universitaire</p>
          <p>95, rue Firmin Oulès</p>
          <p>81100 Castres</p>
        </div>
      </div>

      <p>© 2025 Tous droits réservés - Eduprospect</p>

      <!-- Partie droite : Logos Inuc et Insa dans des div séparées -->
      <div class="partners-right">
        <div class="partner-logo-inuc">
          <img src="@/assets/images/logoInuc/horizontal/LOGO-UC-horizontal-Bichro-fondclair.png" alt="logo inuc" class="partner-logo-other" />
        </div>
        <div class="partner-logo-insa">
          <img src="@/assets/images/logoInsaPartenaire/PartINSA-GrisRouge.gif" alt="logo insa" class="partner-logo-other" />
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: "Footer",
};
</script>

<style scoped>
footer {
  width: 100vw;
  background-color: white;
  padding: 20px;
  color: black;
  text-align: center;
  font-size: 1rem;
  box-sizing: border-box;
  position: relative;
}

.footer-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}

.footer-content p {
  flex: 1;
  text-align: center;
  margin: 0;
}

.partners-left {
  display: flex;
  align-items: center;
  height: 100px;
  width: auto;
}

.address {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  gap: 5px;
}

.address p {
  margin: 0;
  text-align: left;
}

.partner-logo-isis {
  height: 100px;
  width: auto;
}

.partners-right {
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  gap: 10px;
}

/* Styles séparés pour chaque logo */
.partner-logo-inuc img {
  height: 100px; /* Taille spécifique du logo Inuc */
  width: auto;
}

.partner-logo-insa img {
  height: 150px; /* Taille spécifique du logo INSA */
  width: auto;
}
</style>
