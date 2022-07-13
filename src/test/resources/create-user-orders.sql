-- Add products & categories
INSERT INTO CATEGORY(ID, NAME)
VALUES
    (1, 'informática');

INSERT INTO PRODUCT(ID, NAME, PRICE)
VALUES
    (1, 'computador', 100.00),
    (2, 'impressora', 500.00),
    (3, 'Mouse', 80.00);

-- Add users and addresses
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

-- Add orders
INSERT INTO ORDER_(ID, INSTANT, IDFK_CLIENT_ORDER, IDFK_ADDRESS_ORDER)
VALUES
    (1, '2017-09-30 10:32:00', 1, 1),
    (2, '2017-10-10 19:35:00', 1, 2);

INSERT INTO PAYMENT(IDFK_PAYMENT_ORDER, STATE)
VALUES
    (1, 2),
    (2, 1);

INSERT INTO PAYMENT_WITH_BILL(IDFK_PAYMENT_ORDER, PAYMENT_DATE, DUE_DATE)
VALUES
    (2, null, '2017-10-20 00:00:00');

INSERT INTO PAYMENT_WITH_CARD(IDFK_PAYMENT_ORDER, TOTAL_INSTALLMENTS)
VALUES
    (1, 6);
