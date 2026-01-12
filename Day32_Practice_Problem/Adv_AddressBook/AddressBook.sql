CREATE DATABASE AddressBookDB;
USE AddressBookDB;

CREATE TABLE AddressBook (
    ContactId INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip VARCHAR(10),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    PRIMARY KEY (ContactId)
);

INSERT INTO AddressBook
(FirstName, LastName, Address, City, State, Zip, PhoneNumber, Email)
VALUES
('Anbu','A','MG Road','Chennai','TN','600001','9876543210','anbu@gmail.com');

UPDATE AddressBook
SET PhoneNumber = '9999999999'
WHERE ContactId = 1;

DELETE FROM AddressBook
WHERE FirstName = 'Anbu' AND LastName = 'A';

CREATE TABLE Contact (
    ContactId INT NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    Email VARCHAR(100),
    PRIMARY KEY (ContactId)
);

CREATE TABLE Address (
    AddressId INT NOT NULL AUTO_INCREMENT,
    ContactId INT NOT NULL,
    Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip VARCHAR(10),
    PRIMARY KEY (AddressId),
    CONSTRAINT FK_Address_Contact
        FOREIGN KEY (ContactId)
        REFERENCES Contact(ContactId)
        ON DELETE CASCADE
);

CREATE TABLE Address (
    AddressId INT NOT NULL AUTO_INCREMENT,
    ContactId INT NOT NULL,
    Address VARCHAR(100),
    City VARCHAR(50),
    State VARCHAR(50),
    Zip VARCHAR(10),
    PRIMARY KEY (AddressId),
    CONSTRAINT FK_Address_Contact
        FOREIGN KEY (ContactId)
        REFERENCES Contact(ContactId)
        ON DELETE CASCADE
);

CREATE TABLE AddressBookMaster (
    AddressBookId INT NOT NULL AUTO_INCREMENT,
    AddressBookName VARCHAR(50),
    AddressBookType VARCHAR(50),
    PRIMARY KEY (AddressBookId)
);

CREATE TABLE ContactAddressBook (
    ContactId INT NOT NULL,
    AddressBookId INT NOT NULL,
    PRIMARY KEY (ContactId, AddressBookId),
    CONSTRAINT FK_CAB_Contact
        FOREIGN KEY (ContactId)
        REFERENCES Contact(ContactId)
        ON DELETE CASCADE,
    CONSTRAINT FK_CAB_AddressBook
        FOREIGN KEY (AddressBookId)
        REFERENCES AddressBookMaster(AddressBookId)
        ON DELETE CASCADE
);

SELECT ab.AddressBookType, COUNT(cab.ContactId) AS Count
FROM AddressBookMaster ab
JOIN ContactAddressBook cab
ON ab.AddressBookId = cab.AddressBookId
GROUP BY ab.AddressBookType;

INSERT INTO ContactAddressBook VALUES (1, 1);
INSERT INTO ContactAddressBook VALUES (1, 2);

SELECT c.*
FROM Contact c
JOIN Address a ON c.ContactId = a.ContactId
WHERE a.City = 'Chennai';

SELECT c.*
FROM Contact c
JOIN Address a ON c.ContactId = a.ContactId
WHERE a.City = 'Chennai'
ORDER BY c.FirstName, c.LastName;