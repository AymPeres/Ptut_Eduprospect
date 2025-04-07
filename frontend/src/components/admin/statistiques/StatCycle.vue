<template>
  <div class="stat-cycle">
    <h2>Statistiques par Cycle</h2>
    <canvas id="cycleChart"></canvas>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import { Chart } from "chart.js/auto";
import prospects from "/src/assets/prospectsData.js"; // Le fichier des prospects

export default {
  name: "StatCycle",
  setup() {
    const cycles = ["Ingénieur", "Préparatoire"];

    // Compter le nombre de prospects par cycle
    const countProspectsByCycle = () => {
      const cycleCounts = cycles.reduce((acc, cycle) => {
        acc[cycle] = 0;
        return acc;
      }, {});

      prospects.forEach(prospect => {
        cycleCounts[prospect.cycle]++;
      });

      return cycleCounts;
    };

    const cycleCounts = countProspectsByCycle();

    // Création du graphique
    onMounted(() => {
      const ctx = document.getElementById("cycleChart").getContext("2d");
      new Chart(ctx, {
        type: "pie",
        data: {
          labels: cycles,
          datasets: [{
            label: 'Nombre de prospects par cycle',
            data: cycles.map(cycle => cycleCounts[cycle]),
            backgroundColor: ["#4B0082", "#a1a1ff"], // Choisir des couleurs adaptées (violet et bleu foncé)
            borderColor: "#FFFFFF",
            borderWidth: 1,
          }]
        },
        options: {
          responsive: true
        }
      });
    });

    return {};
  }
};
</script>

<style scoped>
.stat-cycle {
  width: 100%;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  text-align: center;
}

h2 {
  color: #333;
}
</style>
