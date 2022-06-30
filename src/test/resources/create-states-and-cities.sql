INSERT INTO STATE(ID, NAME)
VALUES
    (1, 'Minas Gerais'),
    (2, 'São Paulo');


INSERT INTO CITY(ID, NAME, IDFK_STATE_CITY)
VALUES
    (1, 'Uberlândia', 1),
    (2, 'São Paulo', 2),
    (3, 'Campinas', 2);
