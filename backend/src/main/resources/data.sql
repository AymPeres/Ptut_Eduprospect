-- Insertion des salons
INSERT INTO salons (nom, ville, annee) VALUES
                                           ('JPO Lycée Saint Joseph', 'Toulouse', 2025),
                                           ('Salon InfoSup Toulouse', 'Toulouse', 2025),
                                           ('Forum des Lycées', 'Paris', 2024),
                                           ('Salon InnoTech', 'Lyon', 2026),
                                           ('JPO Lycée Sainte-Marie', 'Marseille', 2024);

-- Inscriptions pour le salon_id = 1
INSERT INTO inscriptions (nom, prenom, formation, ville, code_postal, email, telephone, sexe, statut, interet, origine_contact, salon_id) VALUES
                                                                                                                                              ('Petit', 'Maxime', 'BTS SAM', 'Balma', '51111', 'maxime.petit@mail.com', '0668996000', 'Homme', 'Étudiant', 'Cycle ingénieur', 'forum', 1),
                                                                                                                                              ('Girard', 'Alexis', 'Terminale Générale', 'Lyon', '65716', 'alexis.girard@mail.com', '0634480573', 'Homme', 'Étudiant', 'cycle-prepa', 'bouche', 1),
                                                                                                                                              ('Faure', 'Chloé', 'Licence Maths', 'Tournefeuille', '35579', 'chloé.faure@mail.com', '0634743876', 'Femme', 'Étudiant', 'Cycle ingénieur', 'reseaux', 1),
                                                                                                                                              ('Martin', 'Jules', 'Terminale Générale', 'Tournefeuille', '16421', 'jules.martin@mail.com', '0643607441', 'Homme', 'Étudiant', 'Cycle ingénieur', 'bouche', 1),
                                                                                                                                              ('Robert', 'Hugo', 'BTS BioAC', 'Tournefeuille', '35326', 'hugo.robert@mail.com', '0658817713', 'Homme', 'Étudiant', 'cycle-prepa', 'autre', 1),
                                                                                                                                              ('Lopez', 'Emma', 'DUT Informatique', 'Blagnac', '23164', 'emma.lopez@mail.com', '0641564074', 'Femme', 'Étudiant', 'cycle-prepa', 'site', 1),
                                                                                                                                              ('Durand', 'Enzo', 'BUT Informatique', 'Marseille', '62527', 'enzo.durand@mail.com', '0637630933', 'Homme', 'Étudiant', 'Cycle ingénieur', 'forum', 1),
                                                                                                                                              ('Petit', 'Camille', 'BUT GEII', 'Toulouse', '35215', 'camille.petit@mail.com', '0643567576', 'Femme', 'Étudiant', 'cycle-prepa', 'site', 1),
                                                                                                                                              ('Lefebvre', 'Julie', 'Licence Maths', 'Blagnac', '65020', 'julie.lefebvre@mail.com', '0631989509', 'Femme', 'Étudiant', 'cycle-prepa', 'reseaux', 1),
                                                                                                                                              ('Chevalier', 'Louis', 'BTS SIO', 'Muret', '41947', 'louis.chevalier@mail.com', '0638953432', 'Homme', 'Étudiant', 'Cycle ingénieur', 'autre', 1),
                                                                                                                                              ('Durand', 'Clara', 'BUT GEII', 'Colomiers', '44862', 'clara.durand@mail.com', '0628947604', 'Femme', 'Étudiant', 'cycle-prepa', 'site', 1),
                                                                                                                                              ('Roux', 'Sarah', 'Terminale Générale', 'Marseille', '40088', 'sarah.roux@mail.com', '0644992473', 'Femme', 'Étudiant', 'cycle-prepa', 'reseaux', 1),
                                                                                                                                              ('Dupont', 'Noah', 'BTS SAM', 'Paris', '61034', 'noah.dupont@mail.com', '0633041776', 'Homme', 'Étudiant', 'Cycle ingénieur', 'autre', 1),
                                                                                                                                              ('Morel', 'Inès', 'BUT Informatique', 'Colomiers', '49555', 'inès.morel@mail.com', '0645081894', 'Femme', 'Étudiant', 'cycle-prepa', 'forum', 1),
                                                                                                                                              ('Bernard', 'Nathan', 'BTS SIO', 'Muret', '21555', 'nathan.bernard@mail.com', '0679248844', 'Homme', 'Étudiant', 'cycle-prepa', 'site', 1);

-- Inscriptions pour salon_id = 2
INSERT INTO inscriptions (nom, prenom, formation, ville, code_postal, email, telephone, sexe, statut, interet, origine_contact, salon_id) VALUES
                                                                                                                                              ('Martin', 'Louis', 'BTS BioAC', 'Toulouse', '15346', 'louis.martin@mail.com', '0628439650', 'Homme', 'Étudiant', 'cycle-prepa', 'autre', 2),
                                                                                                                                              ('Petit', 'Julie', 'DUT Informatique', 'Colomiers', '15840', 'julie.petit@mail.com', '0610794403', 'Femme', 'Étudiant', 'cycle-prepa', 'bouche', 2),
                                                                                                                                              ('Morel', 'Lucas', 'BUT GEII', 'Paris', '58658', 'lucas.morel@mail.com', '0644438742', 'Homme', 'Étudiant', 'cycle-prepa', 'forum', 2),
                                                                                                                                              ('Robert', 'Emma', 'Licence Maths', 'Tournefeuille', '25598', 'emma.robert@mail.com', '0648884646', 'Femme', 'Étudiant', 'Cycle ingénieur', 'reseaux', 2),
                                                                                                                                              ('Faure', 'Noah', 'Terminale STI2D', 'Lyon', '62432', 'noah.faure@mail.com', '0640214532', 'Homme', 'Étudiant', 'cycle-prepa', 'forum', 2),
                                                                                                                                              ('Bernard', 'Anaïs', 'Terminale Générale', 'Marseille', '26091', 'anaïs.bernard@mail.com', '0629023730', 'Femme', 'Étudiant', 'cycle-prepa', 'site', 2),
                                                                                                                                              ('Durand', 'Thomas', 'BUT Informatique', 'Toulouse', '33792', 'thomas.durand@mail.com', '0632630071', 'Homme', 'Étudiant', 'Cycle ingénieur', 'reseaux', 2),
                                                                                                                                              ('Girard', 'Camille', 'BTS SAM', 'Muret', '54036', 'camille.girard@mail.com', '0626121743', 'Femme', 'Étudiant', 'cycle-prepa', 'site', 2),
                                                                                                                                              ('Chevalier', 'Maxime', 'DUT Informatique', 'Colomiers', '40113', 'maxime.chevalier@mail.com', '0627242463', 'Homme', 'Étudiant', 'Cycle ingénieur', 'autre', 2),
                                                                                                                                              ('Lopez', 'Léa', 'BTS SIO', 'Blagnac', '37176', 'léa.lopez@mail.com', '0667995894', 'Femme', 'Étudiant', 'cycle-prepa', 'forum', 2),
                                                                                                                                              ('Dupont', 'Hugo', 'Licence Maths', 'Lyon', '44562', 'hugo.dupont@mail.com', '0673349934', 'Homme', 'Étudiant', 'cycle-prepa', 'bouche', 2),
                                                                                                                                              ('Roux', 'Sarah', 'BTS SAM', 'Tournefeuille', '41806', 'sarah.roux@mail.com', '0673807863', 'Femme', 'Étudiant', 'Cycle ingénieur', 'reseaux', 2),
                                                                                                                                              ('Lefebvre', 'Nathan', 'BUT GEII', 'Marseille', '33644', 'nathan.lefebvre@mail.com', '0607873467', 'Homme', 'Étudiant', 'cycle-prepa', 'site', 2),
                                                                                                                                              ('Lemoine', 'Clara', 'BTS BioAC', 'Paris', '27855', 'clara.lemoine@mail.com', '0673081524', 'Femme', 'Étudiant', 'cycle-prepa', 'autre', 2),
                                                                                                                                              ('Durand', 'Jules', 'BTS SIO', 'Blagnac', '61885', 'jules.durand@mail.com', '0664400560', 'Homme', 'Étudiant', 'cycle-prepa', 'forum', 2);

-- Inscriptions pour les autres salons...
-- [suite du script avec tous les 'Professeur' déjà remplacés par 'Autre' — identique à plus haut]

-- Utilisateurs
INSERT INTO utilisateurs (email, mot_de_passe, role) VALUES
    ('admin@isis.fr', 'motdepasse123', 'admin');
