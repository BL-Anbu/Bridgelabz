INSERT INTO Contact (ContactId, FirstName, LastName, PhoneNumber, Email)
VALUES (1, 'Anbu', 'A', '9876543210', 'anbu@gmail.com');

-- CREATE TABLE AddressBookMaster (
--     AddressBookId INT PRIMARY KEY,
--     AddressBookName VARCHAR(50),
--     AddressBookType VARCHAR(50)
-- );


-- CREATE TABLE Contact (
--     ContactId INT PRIMARY KEY,
--     FirstName VARCHAR(50),
--     LastName VARCHAR(50),
--     PhoneNumber VARCHAR(15),
--     Email VARCHAR(100)
-- );

-- CREATE TABLE Address (
--     AddressId INT PRIMARY KEY,
--     ContactId INT,
--     Address VARCHAR(100),
--     City VARCHAR(50),
--     State VARCHAR(50),
--     Zip VARCHAR(10),
--     CONSTRAINT FK_Address_Contact
--         FOREIGN KEY (ContactId)
--         REFERENCES Contact(ContactId)
-- );

-- CREATE TABLE ContactAddressBook (
--     ContactId INT NOT NULL,
--     AddressBookId INT NOT NULL,

--     CONSTRAINT PK_ContactAddressBook
--         PRIMARY KEY (ContactId, AddressBookId),

--     CONSTRAINT FK_CAB_Contact
--         FOREIGN KEY (ContactId)
--         REFERENCES Contact(ContactId),

--     CONSTRAINT FK_CAB_AddressBook
--         FOREIGN KEY (AddressBookId)
--         REFERENCES AddressBookMaster(AddressBookId)
-- );

-- SELECT AddressBookType, COUNT(ContactId) AS Count
-- FROM AddressBookMaster ab
-- JOIN ContactAddressBook cab ON ab.AddressBookId = cab.AddressBookId
-- GROUP BY AddressBookType;

INSERT INTO ContactAddressBook VALUES (1, 1);