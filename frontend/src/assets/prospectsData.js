const villes = ["Albi", "Castres", "Gaillac", "Carmaux", "Lavaur", "Mazamet", "Graulhet", "Toulouse", "Montauban", "Rodez"];
const salons = ["Forum des métiers", "Infosup", "Portes ouvertes", "Salon de l'Étudiant"];
const formations = ["Terminale", "Première", "Réorientation", "BTS", "Médecine", "BUT"];
const statuts = ["Étudiant", "Apprenti"];
const cycles = ["Ingénieur", "Préparatoire"];
const modes_connaissance = ["Bouche à oreille", "Site web", "Réseaux sociaux", "Salons", "Professeurs"];
const genres = ["Homme", "Femme", "Non spécifié"];

function genererProspects() {
  return [
    { id: 1, nom: "Martin Dupont", ville: "Toulouse", annee: 2022, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 2, nom: "Sophie Lambert", ville: "Toulouse", annee: 2022, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 3, nom: "Thomas Roux", ville: "Albi", annee: 2022, salon: "Forum des métiers", formation: "Terminale", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Professeurs", genre: "Homme" },
    { id: 4, nom: "Camille Vidal", ville: "Gaillac", annee: 2022, salon: "Infosup", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 5, nom: "Alexis Marchand", ville: "Carmaux", annee: 2022, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Bouche à oreille", genre: "Non spécifié" },
    { id: 6, nom: "Laura Bertrand", ville: "Lavaur", annee: 2022, salon: "Portes ouvertes", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 7, nom: "Nicolas Fabre", ville: "Mazamet", annee: 2022, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 8, nom: "Émilie Garnier", ville: "Toulouse", annee: 2023, salon: "Forum des métiers", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Homme" },
    { id: 9, nom: "Pierre Lacroix", ville: "Montauban", annee: 2023, salon: "Infosup", formation: "BUT", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Professeurs", genre: "Homme" },
    { id: 10, nom: "Claire Moreau", ville: "Albi", annee: 2023, salon: "Forum des métiers", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Bouche à oreille", genre: "Femme" },
    { id: 11, nom: "Antoine Roche", ville: "Toulouse", annee: 2023, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Site web", genre: "Homme" },
    { id: 12, nom: "Sarah Leroux", ville: "Toulouse", annee: 2023, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 13, nom: "Maxime Bernard", ville: "Castres", annee: 2023, salon: "Portes ouvertes", formation: "Réorientation", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 14, nom: "Julie Perrot", ville: "Gaillac", annee: 2024, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Professeurs", genre: "Femme" },
    { id: 15, nom: "Baptiste Fontaine", ville: "Carmaux", annee: 2024, salon: "Forum des métiers", formation: "Terminale", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Bouche à oreille", genre: "Homme" },
    // Ajouts supplémentaires avec déséquilibres marqués
    { id: 16, nom: "Chloé Lefevre", ville: "Toulouse", annee: 2024, salon: "Forum des métiers", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 17, nom: "Maxime Dupuis", ville: "Mazamet", annee: 2024, salon: "Portes ouvertes", formation: "Réorientation", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Professeurs", genre: "Homme" },
    { id: 18, nom: "Caroline Leroy", ville: "Gaillac", annee: 2024, salon: "Infosup", formation: "Médecine", statut: "Apprenti", cycle: "Préparatoire", connaissance_ecole: "Site web", genre: "Femme" },
    { id: 19, nom: "Lucas Dufresne", ville: "Montauban", annee: 2024, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 20, nom: "Marie Lefranc", ville: "Toulouse", annee: 2024, salon: "Forum des métiers", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Non spécifié" },
    { id: 21, nom: "Julien Martin", ville: "Castres", annee: 2024, salon: "Infosup", formation: "BUT", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Bouche à oreille", genre: "Homme" },
    { id: 22, nom: "Mélanie Charrier", ville: "Lavaur", annee: 2024, salon: "Salon de l'Étudiant", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Site web", genre: "Femme" },
    { id: 23, nom: "Antoine Lemoine", ville: "Mazamet", annee: 2024, salon: "Portes ouvertes", formation: "Réorientation", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 24, nom: "Sophie Mercier", ville: "Toulouse", annee: 2024, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 25, nom: "Bastien Hélie", ville: "Carmaux", annee: 2024, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 26, nom: "Élodie Fournier", ville: "Montauban", annee: 2024, salon: "Infosup", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Site web", genre: "Femme" },
    { id: 27, nom: "Mathieu Perrin", ville: "Toulouse", annee: 2024, salon: "Forum des métiers", formation: "Réorientation", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Réseaux sociaux", genre: "Homme" },
    { id: 28, nom: "Clémentine Gauvin", ville: "Gaillac", annee: 2024, salon: "Portes ouvertes", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Bouche à oreille", genre: "Femme" },
    { id: 29, nom: "Guillaume André", ville: "Lavaur", annee: 2024, salon: "Infosup", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Homme" },
    { id: 30, nom: "Alice Gauthier", ville: "Toulouse", annee: 2024, salon: "Salon de l'Étudiant", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Femme" },
    { id: 31, nom: "Paul Boucher", ville: "Mazamet", annee: 2024, salon: "Forum des métiers", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 32, nom: "Aurélie Pires", ville: "Carmaux", annee: 2024, salon: "Portes ouvertes", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Site web", genre: "Femme" },
    { id: 33, nom: "Théo Lambert", ville: "Montauban", annee: 2024, salon: "Infosup", formation: "Réorientation", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Bouche à oreille", genre: "Homme" },
    { id: 34, nom: "Amandine Joly", ville: "Gaillac", annee: 2024, salon: "Forum des métiers", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Femme" },
    { id: 35, nom: "Laurent Thomas", ville: "Toulouse", annee: 2024, salon: "Salon de l'Étudiant", formation: "Réorientation", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 36, nom: "Margaux Hubert", ville: "Castres", annee: 2024, salon: "Portes ouvertes", formation: "Terminale", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Professeurs", genre: "Femme" },
    { id: 37, nom: "Julien Giraud", ville: "Montauban", annee: 2024, salon: "Infosup", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Bouche à oreille", genre: "Homme" },
    { id: 38, nom: "Lucie Deschamps", ville: "Toulouse", annee: 2024, salon: "Portes ouvertes", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 39, nom: "Olivier Vincent", ville: "Gaillac", annee: 2024, salon: "Forum des métiers", formation: "Réorientation", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 40, nom: "Léa Plouhinec", ville: "Lavaur", annee: 2024, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Bouche à oreille", genre: "Femme" },
    { id: 41, nom: "Victor Charbonnier", ville: "Montauban", annee: 2024, salon: "Infosup", formation: "BTS", statut: "Apprenti", cycle: "Ingénieur", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 42, nom: "Charlotte Fouquet", ville: "Carmaux", annee: 2024, salon: "Forum des métiers", formation: "Médecine", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 43, nom: "Nicolas Gauthier", ville: "Toulouse", annee: 2024, salon: "Portes ouvertes", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Site web", genre: "Homme" },
    { id: 44, nom: "Alice Lemoine", ville: "Mazamet", annee: 2024, salon: "Forum des métiers", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Réseaux sociaux", genre: "Femme" },
    { id: 45, nom: "Théo Mercier", ville: "Gaillac", annee: 2024, salon: "Portes ouvertes", formation: "Réorientation", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Salons", genre: "Homme" },
    { id: 46, nom: "Emilie Brasseur", ville: "Castres", annee: 2024, salon: "Infosup", formation: "BTS", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Site web", genre: "Femme" },
    { id: 47, nom: "Victor Moreau", ville: "Lavaur", annee: 2024, salon: "Forum des métiers", formation: "Terminale", statut: "Étudiant", cycle: "Ingénieur", connaissance_ecole: "Site web", genre: "Homme" },
    { id: 48, nom: "Chloé Dubois", ville: "Montauban", annee: 2024, salon: "Salon de l'Étudiant", formation: "Première", statut: "Étudiant", cycle: "Préparatoire", connaissance_ecole: "Bouche à oreille", genre: "Femme" }
  ];
}

const prospects = genererProspects();

export default prospects;
