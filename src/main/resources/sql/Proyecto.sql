create database Proyecto;
use Proyecto;

create table usuario
(
	id int NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    contrasena varchar(100) NOT NULL,
    estado boolean NOT NULL
);
create table cliente
(
	cedula int NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    tipoCedula varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);
create table producto
(
	numProducto int NOT NULL primary key,
    descripcion varchar(100) NOT NULL,
    cantidad int NOT NULL
);
create table factura
(
	numFactura int NOT NULL primary key,
    cliente varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);

insert into usuarios(id,nombre,email,contrasena,estado)values(1,"admin","admin","admin",true);