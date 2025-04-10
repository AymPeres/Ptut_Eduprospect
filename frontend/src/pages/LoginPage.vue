<template>
  <div class="login-container">
    <HomeButton />
    <h2 class="login-title">Entrez votre mot de passe</h2>

    <form class="login-form" @submit.prevent="login">
      <input
        v-model="password"
        type="password"
        class="password-input"
        placeholder="Mot de passe"
        required
      />

      <div v-if="error" class="error-message">
        {{ error }}
      </div>

      <div class="login-actions">
        <button type="button" class="back-button" @click="goBack">Retour</button>
        <button type="submit" class="login-button">Se connecter</button>
      </div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import HomeButton from "@/components/formulaire/HomeButton.vue";

const password = ref('');
const error = ref(null);
const router = useRouter();

// Fonction de connexion
const login = async () => {
  try {
    error.value = null;

    const response = await fetch('/api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        password: password.value
      })
    });

    if (!response.ok) {
      throw new Error('Mot de passe incorrect');
    }

    const data = await response.json();

    localStorage.setItem('authToken', data.token);

    router.push('/admin');
  } catch (err) {
    error.value = err.message || 'Erreur lors de la connexion';
    console.error('Erreur de connexion:', err);
  }
};

const goBack = () => {
  router.back();
};
</script>

<style scoped>
/* 1) Import de la police Plus Jakarta Sans */
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

.login-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;      /* Centre verticalement dans l'espace dispo */
  min-height: 10vh;            /* Ajuste pour positionner par rapport au logo */
  max-width: 600px;            /* Largeur max de la « boîte » du formulaire */
  margin: 0 auto;              /* Centre horizontalement */
  font-family: 'Plus Jakarta Sans', sans-serif;
}

/* 3) Titre au-dessus du champ */
.login-title {
  color: #ED6962;              /* Sur fond violet géré par le layout */
  font-size: 1.4rem;
  margin-bottom: 1.5rem;
  text-align: center;
  font-weight: bold;           /* Met le texte en gras */
}


/* 4) Le formulaire en colonne, centré */
.login-form {
  display: flex;
  flex-direction: column;
  width: 100%;                 /* S'étire jusqu'à max-width du conteneur */
  max-width: 500px;
  align-items: center;
}

/* 5) Champ de saisie du mot de passe */
.password-input {
  width: 100%;
  padding: 0.8rem;
  border-radius: 4px;
  border: none;
  margin-bottom: 1rem;
  font-size: 1rem;
}

/* 6) Ligne contenant le lien + bouton */
.login-actions {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
}

/* Bouton "Retour" */
.back-button {
  background-color: #ED6962;   /* Orange */
  color: #ffffff;
  border: none;
  padding: 0.8rem 1.5rem;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s;
}

.back-button:hover {
  transform: scale(1.03);
}

/* Bouton "Se connecter" */
.login-button {
  background-color: #ED6962;   /* Orange */
  color: #ffffff;
  border: none;
  padding: 0.8rem 1.5rem;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s ease, transform 0.2s;
}

/* Effet hover */
.login-button:hover {
  background-color: #ED6962;
  transform: scale(1.03);
}

/* Message d'erreur */
.error-message {
  color: #ffffff;
  background-color: rgba(255, 0, 0, 0.2);
  padding: 0.5rem;
  border-radius: 4px;
  margin-bottom: 1rem;
  width: 100%;
  text-align: center;
}
</style>
