--Datos para carga inicial de la base de datos

delete from socio;
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES 
	(1,'12345678P','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información',1234567,'ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z');
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES	
	(2,'12345678J','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información',1233466,'ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L');
INSERT INTO socio (idSocio,dniSocio,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numLicencia,numCuenta,cuota,dniTutor,dniTecnico) VALUES
	(3,'12345678C','Inés','Nistal','Piquero','F','2004-02-11','Club Información',2347890,'ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D');

delete from tecnico;
INSERT INTO tecnico (idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia) VALUES
	(1,'22334455Z','Pelayo','Ramon','Nistal',4);
INSERT INTO tecnico (idTecnico,dniTecnico,nombreTecnico,apellido1Tecnico,apellido2Tecnico,idLicencia) VALUES
	(2,'10850777D','Jesús','Argüelles','Piquero',5);
	
delete from licencia;
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(1,1234567,'Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(2,1233466,'Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(3,2347890,'Pendiente de pago');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(4,1122334,'Pagada');
INSERT INTO licencia (idLicencia,numLicencia,estadoLicencia) VALUES
	(5,7654321,'Pagada');
<<<<<<< HEAD

=======
	
>>>>>>> refs/remotes/origin/RenovarLicencia
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

