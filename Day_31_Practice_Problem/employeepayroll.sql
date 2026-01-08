-- -- CREATE DATABASE payroll_service;

-- SHOW DATABASES;

-- USE payroll_service;

-- CREATE TABLE employee_payroll (
--     id INT AUTO_INCREMENT PRIMARY KEY,
--     name VARCHAR(100),
--     salary DOUBLE,
--     start DATE
-- );

-- DESCRIBE employee_payroll;

-- INSERT INTO employee_payroll (name, salary, start)
-- VALUES
-- ('Bill', 100000.00, '2018-01-03'),
-- ('Charlie', 120000.00, '2019-11-13'),
-- ('Terisa', 90000.00, '2020-05-21');

-- SELECT * FROM employee_payroll;

-- SELECT salary FROM employee_payroll WHERE name = 'Bill';

-- SELECT * FROM employee_payroll WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW());

-- ALTER TABLE employee_payroll ADD gender CHAR(1) AFTER name;

-- UPDATE employee_payroll SET gender = 'M' WHERE name = 'Bill' OR name = 'Charlie';

-- UPDATE employee_payroll SET gender = 'F' WHERE name = 'Terisa';

-- SELECT gender, SUM(salary) FROM employee_payroll GROUP BY gender;

-- SELECT gender, AVG(salary) FROM employee_payroll GROUP BY gender;

-- SELECT gender, MIN(salary), MAX(salary) FROM employee_payroll GROUP BY gender;

--SELECT gender, COUNT(*) FROM employee_payroll GROUP BY gender;