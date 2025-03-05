INSERT INTO salons (nom, ville, annee) VALUES
                                           ('JPO Lycée Saint Joseph', 'Toulouse', 2025),
                                           ('Salon InfoSup Toulouse', 'Toulouse', 2025);

INSERT INTO inscriptions (nom, prenom, formation, ville, code_postal, email, telephone, sexe, statut, interet, origine_contact, salon_id) VALUES
                                                                                                             ('Dupont', 'Emma', 'Terminale Générale', 'Toulouse', '31000', 'emma.dupont@mail.com', '0601020304', 'Femme', 'Étudiant', 'Cycle ingénieur', 'Forum/Salon', 1),
                                                                                                                                              ('Martin', 'Lucas', 'BTS SIO', 'Colomiers', '31770', 'lucas.martin@mail.com', '0611223344', 'Homme', 'Étudiant', 'Cycle préparatoire', 'Réseaux sociaux', 1);

INSERT INTO inscriptions (nom, prenom, formation, ville, code_postal, email, telephone, sexe, statut, interet, origine_contact, salon_id) VALUES
                                                                                                                                              ('Lefebvre', 'Camille', 'DUT Informatique', 'Blagnac', '31700', 'camille.lefebvre@mail.com', '0655667788', 'Femme', 'Étudiant', 'Cycle ingénieur', 'Bouche à oreille', 2),
                                                                                                                                              ('Morel', 'Thomas', 'Terminale STI2D', 'Toulouse', '31000', 'thomas.morel@mail.com', '0677889900', 'Homme', 'Étudiant', 'Cycle préparatoire', 'Forum/Salon', 2);

INSERT INTO utilisateurs (email, mot_de_passe, role) VALUES
    ('admin@isis.fr', 'motdepasse123', 'admin');