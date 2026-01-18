use addressbookdb;

CREATE TABLE AddressBook (
    ContactId INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip VARCHAR(10),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100)
);

INSERT INTO AddressBook
VALUES (1,'Anbu','A','MG Road','Chennai','TN','600001','9876543210','anbu@gmail.com');
