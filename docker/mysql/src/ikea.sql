DROP DATABASE IF EXISTS ikea;
CREATE DATABASE ikea DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE ikea;

DROP TABLE IF EXISTS furnitures;
DROP TABLE IF EXISTS material;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS color;

CREATE TABLE material(
	id INT,
	name VARCHAR(40) NOT NULL,

	PRIMARY KEY (id)
);

CREATE TABLE category(
	id INT,
	name VARCHAR(40) NOT NULL,

	PRIMARY KEY (id)
);

CREATE TABLE color(
	id INT,
	name VARCHAR(40) NOT NULL,

	PRIMARY KEY (id)
);

CREATE TABLE furnitures (
    id INT AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    colorID INT NOT NULL,
    materialID INT NOT NULL,
    categoryID INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (colorID)
        REFERENCES color (id),
    FOREIGN KEY (materialID)
        REFERENCES material (id),
    FOREIGN KEY (categoryID)
        REFERENCES category (id)
);

INSERT INTO material (id,name) VALUES(1,'Wood');
INSERT INTO material (id,name) VALUES(2,'Metal');
INSERT INTO material (id,name) VALUES(3,'Plastic');
INSERT INTO material (id,name) VALUES(4,'Horse');

INSERT INTO category (id,name) VALUES(1,'Meatballs');
INSERT INTO category (id,name) VALUES(2,'Chair');
INSERT INTO category (id,name) VALUES(3,'Bed');
INSERT INTO category (id,name) VALUES(4,'Cabinet');
INSERT INTO category (id,name) VALUES(5,'Table');

INSERT INTO color (id,name) VALUES(1,'Black');
INSERT INTO color (id,name) VALUES(2,'Brown');
INSERT INTO color (id,name) VALUES(3,'Red');