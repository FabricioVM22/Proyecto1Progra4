create database Proyecto;
use Proyecto;

create table usuarios
(
	id int NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    contrasena varchar(100) NOT NULL,
    estado boolean NOT NULL
);
create table clientes
(
	cedula int NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    tipoCedula varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);
create table productos
(
	numProducto int NOT NULL primary key,
    descripcion varchar(100) NOT NULL,
    cantidad int NOT NULL
);
create table facturas
(
	numFactura int NOT NULL primary key,
    cliente varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);