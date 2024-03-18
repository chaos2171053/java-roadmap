CREATE TABLE product (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         stock INT NOT NULL
);

INSERT INTO product (name, price, stock) VALUES ('Sample Product', 99.99, 100);
