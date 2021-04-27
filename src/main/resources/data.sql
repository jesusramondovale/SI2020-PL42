--Datos para carga inicial de la base de datos

delete from socio;
delete from tecnico;
delete from licencia;
--Datos para carga inicial de la base de datos



delete from socio;
INSERT INTO socio (idSocio,dniSocio,numLicencia,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numCuenta,cuota,dniTutor,dniTecnico,correo,grupoBurbuja) VALUES 
	(1,'12345678P','11111','Pelayo','Argüelles','Paniagua','M','1988-06-25','Club Información','ES85 1234 5678 9101 1121 3141',15.60,'11223344T','22334455Z', 'cliente1@gmail.com',7);
INSERT INTO socio (idSocio,dniSocio,numLicencia,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numCuenta,cuota,dniTutor,dniTecnico,correo,grupoBurbuja) VALUES	
	(2,'12345678J','22222','Jesus','Ramon','Do Vale','M','1995-12-07','Club Información','ES20 1111 2222 3333 4444 5555',15.60,'12312300M','57442168L', 'cliente2@gmail.com',8);
INSERT INTO socio (idSocio,dniSocio,numLicencia,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numCuenta,cuota,dniTutor,dniTecnico,correo,grupoBurbuja) VALUES
	(3,'12345678C','33333','Inés','Nistal','Piquero','F','2004-02-11','Club Información','ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D','cliente3@gmail.com',9);
INSERT INTO socio (idSocio,dniSocio,numLicencia,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numCuenta,cuota,dniTutor,dniTecnico,correo,grupoBurbuja) VALUES
	(4,'44444444C','44444','Luis','Fernadez','Alonso','M','2002-11-04','Club Información','ES44 1515 1312 1110 9876 5432', 10.20,'56789101K','10850777D','cliente4@gmail.com',7);
INSERT INTO socio (idSocio,dniSocio,numLicencia,nombreSocio,apellido1Socio,apellido2socio,sexo,fechaNacimiento,club,numCuenta,cuota,dniTutor,dniTecnico,correo,grupoBurbuja) VALUES
	(5,'32456778C','55555','Mario','Mendez','Martinez','M','1999-11-14','Club Información','ES44 1533 3333 3330 9876 5432', 10.20,'56789101K','10850777D','cliente5@gmail.com',8);





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
	(1,1,'Galería','2021-04-16','8.30','9.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(2,2,'Galería','2021-04-16','9.30','10.30');
INSERT INTO reservas (idReserva,idSocio,instalacion,fechaReserva,horaInicio,horaFin) VALUES
	(3,3,'Campo','2021-04-16','10.30','11.30');





delete from asambleas;
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora1,hora2) VALUES
	(1,'Ordinaria','Presentacion de la mesa y lectura de presupuestos','2021-04-02',10.00,11.00);
INSERT INTO asambleas (idAsamblea,tipo,ordenDia,fechaAsamblea,hora1,hora2) VALUES
	(2,'Extraordinaria','','2021-03-30',12.00,13.00);




delete from instalacion;
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(1, 'Piscina');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(2, 'Gimnasio');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(3, 'Pista de atletismo');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(4, 'Cancha de baloncesto');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(5, 'Cancha de balonmano');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(6, 'Pista de tenis');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(7, 'Campo de hockey');
INSERT INTO instalacion (idInstalacion, nombreInstalacion) VALUES
	(8, 'Campo de rugby');



 

    
      





