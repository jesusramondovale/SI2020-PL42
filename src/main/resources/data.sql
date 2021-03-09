--Datos para carga inicial de la base de datos
delete from socio;
insert into socio(idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) values 
	(1,'12345678P','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información',1234567,'ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z'),
	(2,'12345678J','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información',1233466,'ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L'),
	(3,'12345678C','Inés','Nistal','Piquero','F','2004-02-11','Club Información',2347890,'ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D');

delete from tecnico; 
insert into tecnico(idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,numLicencia) values
	(1,'22334455Z','Pelayo','Ramon','Nistal',),
	(2,'10850777D','Jesús','Argüelles','Piquero',9871235);

delete from licencia;
insert into licencia(idLicencia,numLicencia,estadoLicencia) values
	(1,1234567,'Pagada'),
	(2,1233466,'Pagada'),
	(3,2347890,'Pendiente de pago');

delete from recibo;
insert into recibo(idRecibo,numRecibo,concepto,fechaV,fechaE,socio) values
	(1,'','','','',1),
	(2,'','','','',2),
	(3,'','','','',3);

delete from asambleas;
insert into asambleas(idAsamblea,tipo,ordenDia,fechaAsamblea,hora) values
	(1,'Ordinaria','Presentacion de la mesa y lectura de presupuestos','2021-04-02',10.00),
	(2,'Extraordinaria','','2021-03-30',12.00);

delete from reservas;
insert into reservas(idReserva,socio,instalacion,fechaReserva,horaInicio,horaFin) values
	(1,1,'piscina','2021-03-08',8.30,9.30);