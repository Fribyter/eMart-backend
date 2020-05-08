SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(50) DEFAULT NULL,
  `PASSWORD` VARCHAR(256) DEFAULT NULL,
  `TYPE` INT(1) NOT NULL, -- 0 BUYER, 1 SELLER
  `EMAIL` VARCHAR(50) DEFAULT NULL,
  `MOBILE` VARCHAR(100) DEFAULT NULL,
  `COMPANY` VARCHAR(50) DEFAULT NULL, -- FOR SELLER
  `CREATE_DATE` DATETIME NOT NULL,
  `ENABLED` INT(1) NOT NULL,
  `LAST_PASSWORD_RESET_DATE` DATETIME NOT NULL,
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `CATEGORY`;
CREATE TABLE `CATEGORY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) DEFAULT NULL,
  `DETAIL` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `ITEM`;
CREATE TABLE `ITEM` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_ID` INT(11) NOT NULL,
  `PRICE` DOUBLE DEFAULT NULL,
  `NAME` VARCHAR(50) DEFAULT NULL,
  `DESCRIPTION` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT ITEM_CATEGORY_FK FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY (ID)
);

DROP TABLE IF EXISTS `TRANSACTION`;
CREATE TABLE `TRANSACTION` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` INT(11) NOT NULL,
  `AMOUNT` DOUBLE DEFAULT NULL,
  `CREATE_DATE` DATETIME NOT NULL,
  `REMARKS` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT TRANSACTION_USER_FK FOREIGN KEY (USER_ID) REFERENCES USER (ID)
);

DROP TABLE IF EXISTS `PURCHASE_HISTORY`;
CREATE TABLE `PURCHASE_HISTORY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` INT(11) NOT NULL,
  `TRANSACTION_ID` INT(11) NOT NULL,
  `ITEM_ID` INT(11) NOT NULL,
  `NUMBER_OF_ITEMS` INT(11) NOT NULL,
  `CREATE_DATE` DATETIME NOT NULL,
  `REMARKS` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT PURCHASE_HISTORY_ITEM_FK FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID),
  CONSTRAINT PURCHASE_HISTORY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USER (ID),
  CONSTRAINT PURCHASE_HISTORY_TRANSACTION_FK FOREIGN KEY (TRANSACTION_ID) REFERENCES TRANSACTION (ID)
);

DROP TABLE IF EXISTS `DISCOUNT`;
CREATE TABLE `DISCOUNT` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `CODE` VARCHAR(50) NOT NULL,
  `PERCENTAGE` DOUBLE NOT NULL,
  `START_DATE` DATETIME NOT NULL,
  `END_DATE` DATETIME NOT NULL,
  `DESCRIPTION` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `AUTHORITY`;
CREATE TABLE `AUTHORITY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`ID`)
);

DROP TABLE IF EXISTS `USER_AUTHORITY`;
CREATE TABLE `USER_AUTHORITY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` INT(11) NOT NULL,
  `AUTHORITY_ID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT USER_AUTHORITY_USER_FK FOREIGN KEY (USER_ID) REFERENCES USER (ID),
  CONSTRAINT USER_AUTHORITY_AUTHORITY_FK FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITY (ID)
);
