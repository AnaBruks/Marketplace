CREATE TABLE Users(
    user_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(15) NOT NULL,
    surname varchar(15) NOT NULL,
    money double CHECK (money > 0)
)


CREATE TABLE Product(
    product_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(20) NOT NULL,
    price double CHECK(price > 0)
)

CREATE TABLE Orders(
    order_id int NOT NULL REFERENCES Users (user_id),
    product_id int NOT NULL REFERENCES Products (product_id) ON DELETE CASCADE
)


INSERT INTO Users(name, surname, money) VALUES ('Elena', 'Prihodko', 100000.01);
INSERT INTO Users(name, surname, money) VALUES ('Nasia', 'Darenko', 99000.50);
INSERT INTO Users(name, surname, money) VALUES ('Vasia', 'Nikitin', 100);
INSERT INTO Users(name, surname, money) VALUES ('Roman', 'Evtushenko', 9878.67);
INSERT INTO Users(name, surname, money) VALUES ('Nikita', 'Babay', 11,99);

INSERT INTO Products(name, price) VALUES ('Laptop', 1000.0);
INSERT INTO Products(name, price) VALUES ('Skovorodka', 10999.90);
INSERT INTO Products(name, price) VALUES ('Lamp', 200.56);
INSERT INTO Products(name, price) VALUES ('Pen', 222.22);
INSERT INTO Products(name, price) VALUES ('Mouse', 100.67);

