CREATE TABLE `order` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `order_name` VARCHAR(255) NOT NULL,
                         `order_user` INT NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE `stock` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(255) NOT NULL,
                         `stock` INT NOT NULL,
                         `version` INT NOT NULL DEFAULT 0,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `stock` (`name`, `stock`) VALUES ('Q弹豆干', 10);
