-- CREATE DATABASE address_book_service;
-- USE address_book_service;

-- CREATE TABLE address_book (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     first_name VARCHAR(50),
--     last_name VARCHAR(50),
--     address VARCHAR(150),
--     city VARCHAR(50),
--     state VARCHAR(50),
--     zip VARCHAR(10),
--     phone VARCHAR(15),
--     email VARCHAR(100)
-- );

-- INSERT INTO address_book
-- (first_name, last_name, address, city, state, zip, phone, email)
-- VALUES
-- ('Anbu', 'A', 'MG Road', 'Chennai', 'Tamil Nadu', '600001', '9876543210', 'anbu@gmail.com'),
-- ('Raj', 'Kumar', 'BTM Layout', 'Bangalore', 'Karnataka', '560076', '9123456789', 'raj@gmail.com');


-- UPDATE address_book
-- SET phone = '9999999999'
-- WHERE first_name = 'Anbu';

 select * FROM address_book;

-- DELETE FROM address_book WHERE first_name = 'Raj';

-- SELECT * FROM address_book WHERE city = 'Chennai';

-- SELECT * FROM address_book WHERE state = 'Tamil Nadu';

-- SELECT city, COUNT(*) AS count FROM address_book GROUP BY city;

-- SELECT * FROM address_book WHERE city = 'Chennai' ORDER BY first_name ASC;

-- ALTER TABLE address_book ADD address_book_name VARCHAR(50),ADD type VARCHAR(50);

-- UPDATE address_book SET address_book_name = 'MyContacts', type = 'Friends' WHERE first_name = 'Anbu';

-- SELECT type, COUNT(*) FROM address_book GROUP BY type;