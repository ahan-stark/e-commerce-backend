create database ecommerce;

CREATE TABLE `ecommerce`.`user` (
  `user_id` BIGINT NOT NULL AUTO_INCREMENT,
  `created` DATETIME(6) NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `username` VARCHAR(255) NULL,
  `user_phone_no` BIGINT(15) NULL,
  PRIMARY KEY (`user_id`));
  
  CREATE TABLE `ecommerce`.`category` (
  `category_id` INT NOT NULL AUTO_INCREMENT,
  `category_image` VARCHAR(500) NOT NULL,
  `category_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));

CREATE TABLE `ecommerce`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_category_id` INT NOT NULL,
  `product_image` VARCHAR(1000) NOT NULL,
  `product_name` VARCHAR(100) NOT NULL,
  `product_price` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `product_category_id_idx` (`product_category_id` ASC) VISIBLE,
  CONSTRAINT `product_category_id`
    FOREIGN KEY (`product_category_id`)
    REFERENCES `ecommerce`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `ecommerce`.`cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `product_id` INT NOT NULL,
  PRIMARY KEY (`cart_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `ecommerce`.`orders` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_time_stamp` BIGINT NOT NULL,
  `product_id` INT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `product_id_idx` (`product_id` ASC) VISIBLE,
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `product`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `ecommerce`.`super_cart` (
  `super_cart_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `product_id` INT NOT NULL,
  `product_booking_price` INT NOT NULL,
  `booking_status` VARCHAR(45) NOT NULL DEFAULT 'notify',
  PRIMARY KEY (`super_cart_id`),
  INDEX `users_idx` (`user_id` ASC) VISIBLE,
  INDEX `products_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `users`
    FOREIGN KEY (`user_id`)
    REFERENCES `ecommerce`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `products`
    FOREIGN KEY (`product_id`)
    REFERENCES `ecommerce`.`products` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


