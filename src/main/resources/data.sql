

INSERT INTO projects (id, status, name)
VALUES

    (30, 1, 'Reconstructie | Croydonstraat | Tilburg'),
    (31, 3, 'Reconstructie | Spoorlaan | Tilburg'),
    (32, 4, 'Onderhoud | Nieuwlandstraat | Eindhoven'),
    (33, 0, 'Nieuwbouw | Boonakker | Velp'),
    (34, 4, 'Nieuwbouw | Laan van Nieuw Oost-Indië | Amstelveen'),
    (35, 5, 'Bestaat niet');

INSERT INTO cross_sections (id, name,  status, left_border, right_border, width,  project_id)
VALUES

    (40, 'DWP 1 - Croydonstraat, Tilburg',1,1,1,16.50,30),
    (41,'DWP 1 - Spoorlaan, Tilburg',1,2,3,16.50,31),
    (42,'DWP 1 - Nieuwlandstraat, Tilburg',1,3,4,16.50,32),
    (43,'DWP 1 - Boonakker, Velp',1,4,5,16.50,33),
    (44,'DWP 1 - Laan van Nieuw Oost-Indië, Amstelveen',1,5,5,16.50,34),
    (45,'DWP 1 - X',1,4,3,16.50,35);


