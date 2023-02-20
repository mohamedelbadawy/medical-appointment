CREATE TABLE `medical_assignment`.`patient` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `patient_name` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC) VISIBLE);
  
  
 CREATE TABLE `medical_assignment`.`appointment` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `patient_id` BIGINT NOT NULL,
  `date` DATE NOT NULL,
  `appointment_status` INT NOT NULL,
  `cancelation_reason` VARCHAR(250) NULL,
  PRIMARY KEY (`id`),
  INDEX `patient_FK_idx` (`patient_id` ASC) VISIBLE,
  CONSTRAINT `patient_FK`
    FOREIGN KEY (`patient_id`)
    REFERENCES `medical_assignment`.`patient` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 