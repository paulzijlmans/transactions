CREATE TABLE IF NOT EXISTS categories
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS transactions
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(400),
    amount      NUMERIC(10, 2),
    comment     VARCHAR(400),
    category_id INTEGER
--    ,
--    constraint fk_category
--        foreign key(category_id)
--            references categories(id)
);