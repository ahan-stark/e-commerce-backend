CREATE TABLE `ecommerce`.`users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`));

CREATE TABLE `ecommerce`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`));

CREATE TABLE `ecommerce`.`payment` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `payment_method` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`payment_id`));

CREATE TABLE `ecommerce`.`user_deatils` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `user_address` VARCHAR(45) NULL,
  `phone_no` INT NULL,
  `full_name` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `ecommerce`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NOT NULL,
  `product_category_id` INT NULL,
  `product_image` VARCHAR(45) NULL,
  PRIMARY KEY (`product_id`),
  INDEX `product_category_id_idx` (`product_category_id` ASC) VISIBLE,
  CONSTRAINT `product_category_id`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `ecommerce`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `ecommerce`.`cart` (
  `user_id` INT NULL,
  `product_id` INT NULL,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `user_id_cart`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id_cart`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `ecommerce`.`cart`
ADD COLUMN `cart_id` INT NOT NULL AUTO_INCREMENT AFTER `product_id`,
ADD PRIMARY KEY (`cart_id`);
;

CREATE TABLE `ecommerce`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `order_time_stamp` BIGINT(16) NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id_orders`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id_orders`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

