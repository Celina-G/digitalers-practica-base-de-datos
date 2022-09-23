use sistemabancario;

-- create database if not exists sistemabancario
-- drop database if exists SistemaBancario;

create table if not exists clientes(
	id varchar(10) not null,
	nombre varchar(100) not null,
	ciudad varchar(100) not null,
	calle varchar(100) not null,
	primary key (id)
);

create table if not exists sucursales(
	nombre varchar(100) not null,
	ciudad varchar(100) not null,
	primary key (nombre)
);
	
create table if not exists Empleados(
	id varchar(10) not null,
	nombre varchar(100) not null,
	numero_telefono varchar(15),
	fecha_incorporacion timestamp default current_timestamp(),
	primary key (id)
);

create table if not exists Prestamos(
	numero_prestamo varchar(15) not null,
	importe int(10) not null,
	nombre_sucursal varchar(100) not null,
	foreign key (nombre_sucursal) references Sucursales(nombre),
	primary key(numero_prestamo)
);

create table if not exists Cuentas(
	nroCuenta varchar(20) not null,
	nombre_sucursal varchar(100) not null,
	foreign key (nombre_sucursal) references Sucursales(nombre),
	primary key (nroCuenta)
);

create table if not exists CajasDeAhorro(
	tipo_interes double (5,2) not null,
	nroCajaDeAhorro varchar(20) primary key references Cuentas(nroCuenta)
);

create table if not exists CuentasCorrientes(
	descubierto double (11,2) not null,
	nroCuentaCorriente varchar(20) primary key references Cuentas(nroCuenta)
);

create table if not exists Subordinados(
	nombre_subordinado varchar(100) not null,
	id_empleado_jefe varchar(10) not null,
	foreign key (id_empleado_jefe) references Empleados(id),
	primary key (id_empleado_jefe, nombre_subordinado)	
);

create table if not exists Cliente_cuenta(
	id_cliente varchar(10) not null,
	numero_cuenta varchar(20) not null,
	foreign key (id_cliente) references clientes(id),
	foreign key (numero_cuenta) references Cuentas(nroCuenta),
	primary key (id_cliente, numero_cuenta)
);

create table if not exists cliente_empleado(
	id_cliente varchar(10) not null,
	id_empleado varchar(10) not null,
	foreign key (id_cliente) references clientes(id),
	foreign key (id_empleado) references Empleados(id),
	primary key (id_cliente, id_empleado)
); 

create table if not exists Prestatarios(
	id_cliente varchar(10) not null,
	numero_prestamo varchar(15) not null,
	foreign key (id_cliente) references Clientes(id),
	foreign key (numero_prestamo) references Prestamos(numero_prestamo)
);	
