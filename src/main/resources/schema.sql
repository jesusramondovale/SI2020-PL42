--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.proyectoClub:
drop table socio;
drop table reservas;
drop table tecnico;
drop table licencia;
drop table asambleas;
drop table recibo;

create table socio (
	idSocio INTEGER PRIMARY KEY AUTOINCREMENT,
	dniSocio varchar(9) not null, 
	nombreSocio varchar(15) not null, 
	apellido1Socio varchar(15) not null,
	apellido2Socio varchar(15) not null,
	sexo varchar(1),
	fechaNacimiento date not null,
	club varchar(50),
	numLicencia integer,
	numCuenta varchar(50) not null,
	cuota float,
	dniTutor varchar(9),
	dniTecnico varchar(9)
);

create table tecnico (
	idTecnico INTEGER PRIMARY KEY AUTOINCREMENT,
	dniTecnico varchar(9),
	nombreTecnico varchar(15) not null, 
	apellido1Tecnico varchar(15) not null,
	apellido2Tecnico varchar(15) not null,
	idLicencia integer,
	FOREIGN KEY (idLicencia) REFERENCES licencia(idLicencia)
);

create table licencia (
	idLicencia INTEGER PRIMARY KEY AUTOINCREMENT,
	numLicencia integer not null,
	estadoLicencia varchar(20) not null
);

create table recibo (
	idRecibo INTEGER PRIMARY KEY AUTOINCREMENT,
	numRecibo varchar(10) not null,
	concepto varchar(30) not null,
	fechaV date not null,
	fechaE date not null,
	idSocio integer not null,
	FOREIGN KEY (idSocio) REFERENCES socio(idSocio)
);

create table asambleas (
	idAsamblea INTEGER PRIMARY KEY AUTOINCREMENT,
	tipo varchar(10) not null,
	ordenDia varchar(200) not null,
	fechaAsamblea date not null,
	hora float not null
);

create table reservas (
	idReserva INTEGER PRIMARY KEY AUTOINCREMENT,
	idSocio integer not null,
	instalacion varchar(15) not null,
	fechaReserva date not null,
	horaInicio float not null,
	horaFin float not null,
	FOREIGN KEY(idSocio) REFERENCES socio(idSocio)
);
