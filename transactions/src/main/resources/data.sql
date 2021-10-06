DROP TABLE IF EXISTS transactions;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(80)
);
CREATE INDEX categories_name ON categories (name);

CREATE TABLE transactions
(
    id          SERIAL PRIMARY KEY,
    category_id INTEGER,
    date        DATE,
    description VARCHAR(400),
    amount      NUMERIC(10, 2),
    comment     VARCHAR(400)
);
ALTER TABLE transactions
    ADD CONSTRAINT fk_category_transactions FOREIGN KEY (category_id) REFERENCES categories (id);

INSERT INTO categories
VALUES (0, 'Boodschappen');
INSERT INTO categories
VALUES (1, 'Vaste lasten');
INSERT INTO categories
VALUES (2, 'Vakantie');

INSERT INTO transactions (date, category_id, description, amount, comment)
VALUES ('2021-01-01', 1, 'transaction 1', 100.00, 'comment 1'),
       ('2021-01-02', 0, 'transaction 2', 234.56, 'comment 2'),
       ('2021-01-03', 2, 'transaction 3', 50.25, 'comment 3');