CREATE TABLE employee (
    emp_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    gender CHAR(1),
    address VARCHAR(255) DEFAULT 'Not Provided'
);

CREATE TABLE payroll (
    emp_id INT,
    basic_pay DOUBLE NOT NULL,
    deductions DOUBLE,
    taxable_pay DOUBLE,
    income_tax DOUBLE,
    net_pay DOUBLE,
    PRIMARY KEY (emp_id),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);

CREATE TABLE department (
    dept_id INT AUTO_INCREMENT PRIMARY KEY,
    dept_name VARCHAR(100) NOT NULL
);

CREATE TABLE employee_department (
    emp_id INT,
    dept_id INT,
    PRIMARY KEY (emp_id, dept_id),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id),
    FOREIGN KEY (dept_id) REFERENCES department(dept_id)
);

CREATE TABLE employee_phone (
    emp_id INT,
    phone_number VARCHAR(15),
    PRIMARY KEY (emp_id, phone_number),
    FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);