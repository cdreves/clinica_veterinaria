create database clinica_veterinaria;
create table cliente(
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
	rut_cliente varchar(12),
	nombre char(50),
	direccion char(200),
	telefono varchar(20),
	mail char(50),
	PRIMARY KEY (id)

);

create table paciente(
	id MEDIUMINT NOT NULL AUTO_INCREMENT,
	nombre char(50),
	color char(50),
	fecha_nacimiento date,
	especie char(50),
	raza char(50),
	sexo char(20),
	rut_cliente char(12),
	PRIMARY KEY (id)
);

