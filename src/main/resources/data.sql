--Datos para carga inicial de la base de datos

delete from socio;
delete from tecnico;
delete from licencia;
delete from recibo;
delete from asambleas;
delete from reservas;

insert into socio(idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) values 
	(1,'12345678P','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información',1234567,'ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z');
insert into socio(idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) values	
	(2,'12345678J','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información',1233466,'ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L');
insert into socio(idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) values
	(3,'12345678C','Inés','Nistal','Piquero','F','2004-02-11','Club Información',2347890,'ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D');

insert into tecnico(idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia) values
	(1,'22334455Z','Pelayo','Ramon','Nistal',4);
insert into tecnico(idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia) values
	(2,'10850777D','Jesús','Argüelles','Piquero',5);

insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(1,1234567,'Pagada');
insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(2,1233466,'Pagada');
insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(3,2347890,'Pendiente de pago');
insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(4,1122334,'Pagada');
insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(5,7654321,'Pagada');

insert into recibo(idRecibo,numRecibo,concepto,fechaV,fechaE,idSocio) values
	(1,'','','','',1);
insert into recibo(idRecibo,numRecibo,concepto,fechaV,fechaE,idSocio) values
	(2,'','','','',2);
insert into recibo(idRecibo,numRecibo,concepto,fechaV,fechaE,idSocio) values
	(3,'','','','',3);

insert into asambleas(idAsamblea,tipo,ordenDia,fechaAsamblea,hora) values
	(1,'Ordinaria','Presentacion de la mesa y lectura de presupuestos','2021-04-02',10.00);
insert into asambleas(idAsamblea,tipo,ordenDia,fechaAsamblea,hora) values
	(2,'Extraordinaria','','2021-03-30',12.00);

insert into reservas(idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) values
	(1,1,'piscina','2021-03-08',8.30,9.30);