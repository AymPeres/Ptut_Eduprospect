<template>
  <div class="stat-nb-prospect">
    <h2>Nombre de Prospects par Critère</h2>
    <div class="filters">
      <button @click="setCriterion('ville')">Ville</button>
      <button @click="setCriterion('annee')">Année</button>
      <button @click="setCriterion('salon')">Salon</button>
    </div>
    <canvas id="nbProspectChart"></canvas>
  </div>
</template>

<script>
import { ref, onMounted, watch } from "vue";
import Chart from 'chart.js/auto';
import prospects from "@/assets/prospectsData.js"; // Assurez-vous que le chemin est correct

export default {
  name: "StatNbProspect",
  setup() {
    const selectedCriterion = ref(null);
    const chart = ref(null);

    const countProspectsByCriterion = (criterion) => {
      const counts = {};
      prospects.forEach(prospect => {
        const key = prospect[criterion];
        if (key !== undefined && key !== null) {
          counts[key] = (counts[key] || 0) + 1;
        }
      });
      return counts;
    };

    const updateChart = () => {
      if (chart.value) {
        chart.value.destroy();
        chart.value = null; // Assurez-vous que la référence est bien nettoyée
      }

      const ctx = document.getElementById("nbProspectChart").getContext("2d");
      if (!ctx) {
        console.error("Canvas context not found");
        return;
      }

      if (!selectedCriterion.value) {
        console.warn("No criterion selected");
        return;
      }

      const data = countProspectsByCriterion(selectedCriterion.value);
      console.log("Data for chart:", data); // Vérifiez les données

      const labels = Object.keys(data);
      const values = Object.values(data);

      if (labels.length === 0 || values.length === 0) {
        console.warn("No data available for the selected criterion");
        return;
      }

      chart.value = new Chart(ctx, {
        type: "bar",
        data: {
          labels: labels,
          datasets: [{
            label: `Nombre de prospects par ${selectedCriterion.value}`,
            data: values,
            backgroundColor: "#f1645d",
            borderColor: "#d14a44",
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true,
          animation: false, // Désactivez les animations pour tester
          scales: {
            y: {
              beginAtZero: true,
            }
          }
        }
      });
    };

    const setCriterion = (criterion) => {
      selectedCriterion.value = criterion;
      console.log("Selected criterion:", criterion); // Vérifiez le critère sélectionné
    };

    onMounted(() => {
      // Initialiser avec un critère par défaut si nécessaire
      setCriterion('ville');
    });

    watch(selectedCriterion, () => {
      updateChart();
    });

    return {
      selectedCriterion,
      setCriterion,
      updateChart
    };
  }
};
</script>

<style scoped>
.stat-nb-prospect {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

h2 {
  color: #333;
}

.filters {
  display: flex;
  gap: 10px;
  justify-content: center;
  margin-bottom: 20px;
}

.filters button {
  background-color: #f1645d;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.filters button:hover {
  background-color: #d14a44;
}
</style>
