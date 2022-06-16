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
    description VARCHAR(400),
    amount      NUMERIC(10, 2),
    comment     VARCHAR(400),
    category_id INTEGER,
    constraint fk_category
        foreign key(category_id)
            references categories(id)
);