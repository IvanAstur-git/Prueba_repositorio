CREATE DATABASE empleados CHARACTER SET utf8mb4;
USE empleados;

CREATE TABLE departamento (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  presupuesto DOUBLE UNSIGNED NOT NULL,
  gastos DOUBLE UNSIGNED NOT NULL
);

CREATE TABLE empleado (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nif VARCHAR(9) NOT NULL UNIQUE,
  nombre VARCHAR(100) NOT NULL,
  apellido1 VARCHAR(100) NOT NULL,
  apellido2 VARCHAR(100),
  id_departamento INT UNSIGNED,
  FOREIGN KEY (id_departamento) REFERENCES departamento(id)
);

INSERT INTO departamento VALUES(1, 'Desarrollo', 120000, 6000);
INSERT INTO departamento VALUES(2, 'Sistemas', 150000, 21000);
INSERT INTO departamento VALUES(3, 'Recursos Humanos', 280000, 25000);
INSERT INTO departamento VALUES(4, 'Contabilidad', 110000, 3000);
INSERT INTO departamento VALUES(5, 'I+D', 375000, 380000);
INSERT INTO departamento VALUES(6, 'Proyectos', 0, 0);
INSERT INTO departamento VALUES(7, 'Publicidad', 0, 1000);

INSERT INTO empleado VALUES(1, '32481596F', 'Aarón', 'Rivero', 'Gómez', 1);
INSERT INTO empleado VALUES(2, 'Y5575632D', 'Adela', 'Salas', 'Díaz', 2);
INSERT INTO empleado VALUES(3, 'R6970642B', 'Adolfo', 'Rubio', 'Flores', 3);
INSERT INTO empleado VALUES(4, '77705545E', 'Adrián', 'Suárez', NULL, 4);
INSERT INTO empleado VALUES(5, '17087203C', 'Marcos', 'Loyola', 'Méndez', 5);
INSERT INTO empleado VALUES(6, '38382980M', 'María', 'Santana', 'Moreno', 1);
INSERT INTO empleado VALUES(7, '80576669X', 'Pilar', 'Ruiz', NULL, 2);
INSERT INTO empleado VALUES(8, '71651431Z', 'Pepe', 'Ruiz', 'Santana', 3);
INSERT INTO empleado VALUES(9, '56399183D', 'Juan', 'Gómez', 'López', 2);
INSERT INTO empleado VALUES(10, '46384486H', 'Diego','Flores', 'Salas', 5);
INSERT INTO empleado VALUES(11, '67389283A', 'Marta','Herrera', 'Gil', 1);
INSERT INTO empleado VALUES(12, '41234836R', 'Irene','Salas', 'Flores', NULL);
INSERT INTO empleado VALUES(13, '82635162B', 'Juan Antonio','Sáez', 'Guerrero', NULL);

-- Tarea 1
Select nombre, apellido1, apellido2
from empleado;

-- Tarea 2
Select apellido1 
from empleado;

-- Tarea 3
Select *
from empleado;

-- Tarea 4
Select id_departamento, nombre
from empleado;

-- Tarea 5
Select id_departamento
from empleado;
-- Tarea 6
select concat_ws("_", nombre, apellido1) as "Nombre de empleado"
from empleado;

-- Tarea 7
select concat (lower (nombre),"__",  lower(apellido1), "__", lower(apellido2)) as "Nombre de empleado" 
from empleado;

-- Tarea 8 (no compleatada)
select id, substr(nif, 1, 8) as "número_nif", substr(nif, 9, 1) as "letra_nif"
from empleado;

-- Tarea 9
select nombre, presupuesto, gastos, presupuesto - gastos as "Presupuesto actual"
from empleado;

-- Tarea 10 
select nombre, presupuesto
from departamento
order by nombre, presupuesto asc;

-- Tarea 11
select nombre
from departamento
order by nombre desc;

-- Tarea 12
select nombre, apellido1, apellido2
FROM empleado
order by 2,3,1;

-- Tarea 13
select nombre, presupuesto
from departamento
order by 2 desc
limit 3;

-- Tarea 14
select nombre, gastos
from departamento
order by 2 desc
limit 2;

-- Tarea 16
select nombre, gastos
from departamento
order by 2 asc
limit 2;

-- Tarea 17
select *
from empleado
limit 5 offset 2;

-- Tarea 18
select nombre, presupuesto
from departamento
where presupuesto >= 15000;

-- Tarea 19
select nombre, presupuesto
from departamento
where presupuesto >= 150000 and presupuesto <= 200000;

-- Tarea 20 
select nombre, presupuesto
from departamento
where presupuesto between 150000 and 200000 ;

-- Tarea 21
select gastos, presupuesto
from departamento
where gastos < presupuesto;

-- Tarea 26
select *
from empleado
where apellido2= "Lopéz"; 

-- Tarea 27
select *
from empleado
WHERE apellido2 like "Diaz" or apellido2 LIKE "Moreno";

-- Tarea 28
select *
from empleado
WHERE apellido2 in ("Diaz", "Moreno");

-- Tarea 29
select nombre, apellido1, apellido2, nif
from empleado
where id_departamento=3;

-- Tarea 30
select sum(presupuesto)
from empleado;

-- Tarea 31
select round(avg(presupuesto),2) as "Medía del presupuesto", "€" as "Moneda"
from departamento;

-- Tarea 34
select nombre, presupuesto
from departamento
where presupuesto = (select min(presupuesto) from departamento);

-- Tarea 35
select nombre, presupuesto
from departamento
where presupuesto = (select max(presupuesto) from departamento);

-- Tarea 36
select nombre, presupuesto
from departamento
where presupuesto = (select max(presupuesto) from departamento);

-- tarea 37
select count(*)
from empleado;
