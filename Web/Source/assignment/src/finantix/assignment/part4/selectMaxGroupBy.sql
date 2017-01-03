CREATE TABLE department 
(
	id bigint NOT NULL,
	name character varying(255) NOT NULL,
	CONSTRAINT department_pkey PRIMARY KEY (id)
);

INSERT INTO department(id, name) VALUES (1, 'DEVELOPMENT');
INSERT INTO department(id, name) VALUES (2, 'TESTER');
INSERT INTO department(id, name) VALUES (3, 'HR');


CREATE TABLE employee 
(
	id bigint NOT NULL,
	name character varying(255) NOT NULL,
	salary bigint NOT NULL,
	department bigint NOT NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (id),
	CONSTRAINT fk_department FOREIGN KEY (department)
      REFERENCES department (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO employee(id, name, salary, department) VALUES (1, 'PhuongDEV1', 1000, 1);
INSERT INTO employee(id, name, salary, department) VALUES (2, 'PhuongDEV2', 2000, 1);
INSERT INTO employee(id, name, salary, department) VALUES (3, 'PhuongDEV3', 3000, 1);

INSERT INTO employee(id, name, salary, department) VALUES (4, 'PhuongQC1', 3000, 2);
INSERT INTO employee(id, name, salary, department) VALUES (5, 'PhuongQC2', 1000, 2);
INSERT INTO employee(id, name, salary, department) VALUES (6, 'PhuongQC3', 2000, 2);

INSERT INTO employee(id, name, salary, department) VALUES (7, 'PhuongHR1', 20000, 3);
INSERT INTO employee(id, name, salary, department) VALUES (8, 'PhuongHR2', 30000, 3);
INSERT INTO employee(id, name, salary, department) VALUES (9, 'PhuongHR3', 10000, 3);

SELECT e.id, e.name, e.salary, d.name as deparment_name
FROM employee e
INNER JOIN (SELECT MAX(salary) AS MaxSalary, department  FROM employee GROUP BY department) e2 ON e.department = e2.department AND e.salary = e2.MaxSalary
LEFT JOIN department d ON e.department = d.id;