create database Proyecto;
use Proyecto;

create table usuario
(
	id int auto_increment NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    contrasena varchar(100) NOT NULL,
    estado boolean NOT NULL
);
create table cliente
(
	cedula int auto_increment NOT NULL primary key,
    nombre varchar(100) NOT NULL,
    tipo_cedula varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);
create table producto
(
	num_producto int auto_increment NOT NULL primary key,
    descripcion varchar(100) NOT NULL,
    cantidad int NOT NULL
);
create table factura
(
	num_factura int auto_increment NOT NULL primary key,
    cliente varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);

insert into usuario(id,nombre,email,contrasena,estado)values(1,'admin','admin','admin',true);
insert into cliente(cedula,nombre,tipo_cedula,correo)values(18620,'Carlos','nacional','carlitos@gmail.com');
insert into producto(num_producto,descripcion,cantidad)values(1,'Natilla',50);
insert into factura(num_factura,cliente,email)values(1,'Carlos','carlitos@gmail.com');
