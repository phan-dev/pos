CREATE TABLE invoice
(
    invoice_id   BIGINT NOT NULL PRIMARY KEY,
    customer_id  BIGINT NOT NULL,
    invoice_data TEXT
);