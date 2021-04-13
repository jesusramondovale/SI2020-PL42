--Datos para carga inicial de la base de datos

delete from socio;
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES 
	(1,'12345678P','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información','PA11111','ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z');
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES	
	(2,'12345678J','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información','PA22222','ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L');
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES
	(3,'12345678C','Inés','Nistal','Piquero','F','2004-02-11','Club Información','PA33333','ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D');

delete from tecnico;
INSERT INTO tecnico (idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia, numCuenta,cuota) VALUES
	(1,'22334455Z','Pelayo','Ramon','Nistal',4,'ES33 1616 1213 1111 9876 5432',27.00);
INSERT INTO tecnico (idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia,numCuenta,cuota) VALUES
	(2,'10850777D','Jesús','Argüelles','Piquero',5,'ES55 1315 1413 1112 9876 5432',27.00);

delete from juez;
INSERT INTO juez(idJuez,dniJuez,nombreJuez,apellido1Juez,apellido2Juez,idLicencia, numCuenta,cuota) VALUES
	(1,'11223344W','Ines','Paniagua','DoVale',6,'ES22 2626 2223 2121 8765 4321',27.00);
INSERT INTO juez (idJuez,dniJuez,nombreJuez,apellido1Juez,apellido2Juez,idLicencia,numCuenta,cuota) VALUES
	(2,'88866777C','Jesús','Nistal','Arguelles',7,'ES45 2325 2423 2112 8765 4321',27.00);	
	
delete from licencia;
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(1,'PPA11111','Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(2,'PPA22222','Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(3,'PPA33333','Pendiente de pago');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(4,'PPA44444','Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(5,'PPA55555','Pagada');

delete from reservas;
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(1,1,'piscina','2021-03-08',8.30,9.30);

delete from asambleas;
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora) VALUES
	(1,'Ordinaria','Presentacion de la mesa y lectura de presupuestos','2021-04-02',10.00);
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora) VALUES
	(2,'Extraordinaria','','2021-03-30',12.00);

delete from instalacion;
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(1, 'piscina');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(2, 'gimnasio');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(3, 'pista de atletismo');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(4, 'cancha de baloncesto');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(5, 'cancha de balonmano');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(6, 'pista de tenis');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(7, 'campo de hockey');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(8, 'campo de rugby');

delete from recibos;
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta) VALUES
	(1, 1, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 15.60, 'ES85 1234 5678 9101 1121 3141');
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta) VALUES
	(2, 2, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 15.60, 'ES20 1111 2222 3333 4444 5555');
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta) VALUES
	(3, 3, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 10.20, 'ES44 1515 1312 1110 9876 5432');