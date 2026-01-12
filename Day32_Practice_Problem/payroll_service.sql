CREATE DATABASE payroll_service;

USE payroll_service;

CREATE TABLE employee (
    emp_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    gender CHAR(1),
    start_date DATE,
    PRIMARY KEY (emp_id)
);

CREATE TABLE payroll (
    payroll_id INT NOT NULL AUTO_INCREMENT,
    emp_id INT NOT NULL,
    salary DOUBLE,
    PRIMARY KEY (payroll_id),
    CONSTRAINT FK_Payroll_Employee
        FOREIGN KEY (emp_id)
        REFERENCES employee(emp_id)
        ON DELETE CASCADE
);

CREATE TABLE department (
    dept_id INT NOT NULL AUTO_INCREMENT,
    dept_name VARCHAR(50),
    PRIMARY KEY (dept_id)
);

CREATE TABLE employee_department (
    emp_id INT NOT NULL,
    dept_id INT NOT NULL,
    PRIMARY KEY (emp_id, dept_id),
    CONSTRAINT FK_ED_Employee
        FOREIGN KEY (emp_id)
        REFERENCES employee(emp_id)
        ON DELETE CASCADE,
    CONSTRAINT FK_ED_Department
        FOREIGN KEY (dept_id)
        REFERENCES department(dept_id)
        ON DELETE CASCADE
);

-- Insert Employee
INSERT INTO employee (name, gender, start_date)
VALUES ('Terisa', 'F', '2019-01-01');

-- Insert Payroll
INSERT INTO payroll (emp_id, salary)
VALUES (1, 3000000.00);

-- Insert Departments
INSERT INTO department (dept_name)
VALUES ('HR'), ('Finance');

-- Map Employee to Departments
INSERT INTO employee_department VALUES (1, 1);
INSERT INTO employee_department VALUES (1, 2);