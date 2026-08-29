CREATE TABLE sales_tb(
    uuid CHAR(32) PRIMARY KEY,
    quantity INTEGER NOT NULL,
    rapend_at DATE NOT NULL,
    total_value DECIMAL(16,2) NOT NULL,
    id_product CHAR(32),
    FOREIGN KEY (id_product) REFERENCES product_tb(uuid)
);