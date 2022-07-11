INSERT INTO STATE(ID, NAME)
VALUES
    (1, 'Minas Gerais'),
    (2, 'São Paulo');


INSERT INTO CITY(ID, NAME, IDFK_STATE_CITY)
VALUES
    (1, 'Uberlândia', 1),
    (2, 'São Paulo', 2),
    (3, 'Campinas', 2);

INSERT INTO CLIENT(ID, NAME, EMAIL, CPF_OR_CNPJ, TYPE)
VALUES
    (1, 'foo', 'foo@gmail.com', '1234567890', 1),
    (2, 'bar', 'bar@gmail.com', '1098765432', 2);

INSERT INTO ADDRESS(ID, ADDRESS, NUMBER, ADDITION, AREA, CEP, IDFK_CLIENT_ADDRESS, IDFK_CITY_ADDRESS)
VALUES
    (1, 'Rua flores', '300', 'Apto 203', 'Jardim', '38220834', 1, 1),
    (2, 'Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 1, 2),
    (3, 'Avenida Matos', '105', 'Sala 800', 'Centro', '38777012', 2, 2);