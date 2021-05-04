--Datos para carga inicial de la base de datos

delete from socio;
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico,grupoBurbuja) VALUES 
	(1,'12345678P','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información','PA11111','ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z',1);
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico,grupoBurbuja) VALUES	
	(2,'12345678J','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información','PA22222','ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L',1);
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2Socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico,grupoBurbuja) VALUES
	(3,'12345678C','Inés','Nistal','Piquero','F','2004-02-11','Club Información','PA33333','ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D',2);

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
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia,precio) VALUES
	(1,'PPA11111','Pagada',45.00);
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia,precio) VALUES
	(2,'PPA22222','Pagada',45.00);
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia,precio) VALUES
	(3,'PPA33333','Pendiente de pago',45.00);
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia,precio) VALUES
	(4,'PPA44444','Pagada',27.00);
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia,precio) VALUES
	(5,'PPA55555','Pagada',27.00);

delete from reservas;
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(1,1,'Piscina','2021-04-16','8.30','9.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(2,2,'Gimnasio','2021-04-16','9.30','10.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(3,3,'Campo','2021-04-16','10.30','11.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(4,4,'Galería','2021-04-16','11.30','12.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(5,5,'Cancha de baloncesto','2021-04-16','12.30','13.00');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(6,6,'Pista de tenis','2021-04-16','13.30','14.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(7,7,'Campo de rugby','2021-04-16','11.30','12.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(8,8,'Campo de hockey','2021-04-16','11.30','12.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(9,9,'Pista de Atletismo','2021-04-16','11.30','12.30');

delete from asambleas;
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora1,hora2) VALUES
	(1,'Ordinaria','Presentacion de la mesa y lectura de presupuestos','2021-04-02',10.00,11.00);
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora1,hora2) VALUES
	(2,'Extraordinaria','','2021-03-30',12.00,13.00);

delete from instalacion;
INSERT INTO instalacion (idInstalacion, nombreInstalacion, aforo) VALUES
	(1, 'Galería', 0);
INSERT INTO instalacion (idInstalacion, nombreInstalacion, aforo) VALUES
	(2, 'Campo', 0);

delete from recibos;
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta,estado) VALUES
	(1, 1, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 15.60, 'ES85 1234 5678 9101 1121 3141','generado');
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta,estado) VALUES
	(2, 2, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 15.60, 'ES20 1111 2222 3333 4444 5555','generado');
INSERT INTO recibos (IdRecibo, idSocio, fechaValor, fechaEmision, concepto, importe, numCuenta,esatdo) VALUES
	(3, 3, '2021-03-01', '2021-03-15', 'Cuota Club Mes Marzo', 10.20, 'ES44 1515 1312 1110 9876 5432','generado');

