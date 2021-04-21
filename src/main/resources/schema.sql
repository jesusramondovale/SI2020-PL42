--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.proyectoClub

drop table socio;
CREATE TABLE socio (
	idSocio INTEGER PRIMARY KEY AUTOINCREMENT,
	dniSocio TEXT NOT NULL, 
	nombreSocio TEXT NOT NULL, 
	apellido1Socio TEXT NOT NULL,
	apellido2Socio TEXT NOT NULL,
	sexo TEXT,
	fechaNacimiento DATE NOT NULL,
	club TEXT NOT NULL,
	numLicencia TEXT NOT NULL,
	numCuenta TEXT NOT NULL,
	cuota FLOAT,
	dniTutor TEXT,
	dniTecnico TEXT,
	grupoBurbuja INTEGER
);

drop table tecnico;
CREATE TABLE tecnico (
	idTecnico INTEGER PRIMARY KEY AUTOINCREMENT,
	dniTecnico TEXT NOT NULL,
	nombreTecnico TEXT NOT NULL, 
	apellido1Tecnico TEXT NOT NULL,
	apellido2Tecnico TEXT NOT NULL,
	idLicencia INTEGER,
	numCuenta TEXT NOT NULL,
	cuota FLOAT,
	FOREIGN KEY (idLicencia) REFERENCES licencia(idLicencia)
);
drop table juez;
CREATE TABLE juez (
	idJuez INTEGER PRIMARY KEY AUTOINCREMENT,
	dniJuez TEXT NOT NULL,
	nombreJuez TEXT NOT NULL, 
	apellido1Juez TEXT NOT NULL,
	apellido2Juez TEXT NOT NULL,
	idLicencia INTEGER,
	numCuenta TEXT NOT NULL,
	cuota FLOAT,
	FOREIGN KEY (idLicencia) REFERENCES licencia(idLicencia)
);

drop table licencia;
CREATE TABLE licencia (
	idLicencia INTEGER PRIMARY KEY AUTOINCREMENT,
	numLicencia TEXT NOT NULL,
	estadoLicencia TEXT NOT NULL,
	precio FLOAT
);

drop table reservas;
CREATE TABLE reservas (
	idReserva INTEGER PRIMARY KEY AUTOINCREMENT,
	idSocio INTEGER,
	instalacion TEXT NOT NULL,
	fechaReserva DATE NOT NULL,
	horaInicio FLOAT NOT NULL,
	horaFin TEXT NOT NULL,
	FOREIGN KEY(idSocio) REFERENCES socio(idSocio)
);

drop table asambleas;
create table asambleas (
	idAsamblea INTEGER PRIMARY KEY AUTOINCREMENT,
	tipo TEXT NOT NULL,
	ordenDia TEXT NOT NULL,
	fechaAsamblea DATE NOT NULL,
	hora1 TEXT NOT NULL,
	hora2 TEXT NOT NULL
);

drop table instalacion;
create table instalacion (
		idInstalacion INTEGER PRIMARY KEY AUTOINCREMENT,
		nombreInstalacion TEXT NOT NULL,
		aforo INTEGER NOT NULL
);

drop table recibos;
create table recibos (
		idRecibo INTEGER PRIMARY KEY AUTOINCREMENT,
		idSocio INTEGER,
		fechaValor TEXT NOT NULL,
		fechaEmision TEXT NOT NULL,
		concepto TEXT NOT NULL,
		importe TEXT NOT NULL,
		numCuenta TEXT NOT NULL,
		FOREIGN KEY(idSocio) REFERENCES socio(idSocio)
);