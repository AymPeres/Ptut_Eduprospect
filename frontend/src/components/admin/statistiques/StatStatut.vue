<template>
  <div class="stat-statut">
    <h2>Nombre de Prospects par Statut</h2>
    <canvas id="statutChart"></canvas>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import Chart from 'chart.js/auto';
import prospects from "@/assets/prospectsData.js"; // Assurez-vous que le chemin est correct

export default {
  name: "StatStatut",
  setup() {
    const chart = ref(null);

    const countProspectsByStatut = () => {
      const counts = {};
      prospects.forEach(prospect => {
        const key = prospect.statut;
        if (key !== undefined && key !== null) {
          counts[key] = (counts[key] || 0) + 1;
        }
      });
      console.log("Counts for statut:", counts); // Vérifiez les comptages
      return counts;
    };

    const createChart = () => {
      const ctx = document.getElementById("statutChart").getContext("2d");
      if (!ctx) {
        console.error("Canvas context not found");
        return;
      }

      const data = countProspectsByStatut();

      // Vérifiez que les données ne contiennent pas de valeurs null ou undefined
      const labels = Object.keys(data).filter(label => label !== null && label !== undefined);
      const values = labels.map(label => data[label]);

      chart.value = new Chart(ctx, {
        type: "bar",
        data: {
          labels: labels,
          datasets: [{
            label: 'Nombre de prospects par statut',
            data: values,
            backgroundColor: "#9059a0",
            borderColor: "#9059a0",
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true,
          scales: {
            y: {
              beginAtZero: true,
            }
          }
        }
      });
    };

    onMounted(() => {
      createChart();
    });

    return {};
  }
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;700&display=swap");

.stat-statut {
  width: 100%;
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

h2 {
  font-family: "Plus Jakarta Sans", sans-serif;
  color: #333;
}
</style>
