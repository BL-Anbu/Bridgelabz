create database Day_35_payroll_service;
use Day_35_payroll_service;

CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender CHAR(1),
    phone_number VARCHAR(15),
    address VARCHAR(255) DEFAULT 'India',
    start DATE NOT NULL
);

CREATE TABLE payroll (
    payroll_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    basic_pay DOUBLE NOT NULL,
    deductions DOUBLE NOT NULL,
    taxable_pay DOUBLE NOT NULL,
    tax DOUBLE NOT NULL,
    net_pay DOUBLE NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE department (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE employee_department (
    employee_id INT NOT NULL,
    department_id INT NOT NULL,
    PRIMARY KEY (employee_id, department_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

INSERT INTO employee (name, gender, start)
VALUES ('Terissa', 'F', '2018-01-03');

INSERT INTO department (department_name)
VALUES ('Sales'), ('Marketing');

INSERT INTO payroll (employee_id, basic_pay, deductions, taxable_pay, tax, net_pay)
VALUES
(1, 3000000, 1000000, 2000000, 500000, 1500000);

INSERT INTO employee_department VALUES (1, 1);
INSERT INTO employee_department VALUES (1, 2);

SELECT * FROM employee;

SELECT e.name, p.net_pay
FROM employee e
JOIN payroll p ON e.employee_id = p.employee_id
WHERE e.name = 'Terissa';

SELECT *
FROM employee
WHERE start BETWEEN CAST('2018-01-01' AS DATE) AND DATE(NOW());

SELECT e.name, d.department_name
FROM employee e
JOIN employee_department ed ON e.employee_id = ed.employee_id
JOIN department d ON ed.department_id = d.department_id;

SELECT e.gender, SUM(p.net_pay) AS total_salary
FROM employee e
JOIN payroll p ON e.employee_id = p.employee_id
GROUP BY e.gender;

ALTER TABLE employee
ADD is_active BOOLEAN DEFAULT TRUE;

UPDATE employee
SET is_active = TRUE
WHERE is_active IS NULL;