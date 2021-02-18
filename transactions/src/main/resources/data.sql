DROP TABLE IF EXISTS transaction;

CREATE TABLE transaction (
        id          BIGSERIAL PRIMARY KEY,
        date        DATE,
        description VARCHAR,
        amount      NUMERIC,
        comment     VARCHAR
);

INSERT INTO transaction (date, description, amount, comment) VALUES
  ('2021-01-01', 'transaction 1', 100.00, 'comment 1'),
  ('2021-01-02', 'transaction 2', 234.56, 'comment 2'),
  ('2021-01-03', 'transaction 3', 50.25, 'comment 3');