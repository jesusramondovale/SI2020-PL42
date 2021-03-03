--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:

drop table socio;
drop table tecnico;
drop table licencia;
drop table recibo;
drop table asamblea;
drop table reserva;


create table Socio (id_socio int primary key not null, DNI varchar(12) not null, nombre varchar(32) not null, sexo varchar(1) not null, fecha_nac date not null, club varchar (12) not null, 
                    num_licencia int not null, IBAN int not null, cuota int not null, DNI_tutor varchar (12), DNI_tecnico varchar(12),
                    foreign key(DNI_tecnico) references tecnico(id_tecnico));  



create table tecnico (id_tecnico int primary key not null, DNI_tecnico varchar (12) not null, nombre_tecnico varchar (32) not null, num_licencia int not null); 



create table licencia (id_licencia int primary key not null, num_licencia int not null, estado varchar(12) not null);



create table recibo (id_recibo int primary key not null, num_recibo int not null, concepto varchar(32) not null, fecha_valor date not null, fecha_emision date not null, datos_socio int not null,
                    foreign key (datos_socio) references socio(id_socio)); 



create table asamblea (id_asamblea int primary key not null, tipo varchar(12) not null, orden_dia varchar(120) not null, fecha date not null, hora time not null); 



create table reserva (id_reserva primary key not null, id_socio int not null, tipo_instalacion varchar(32) not null, fecha date not null, hora_ini time not null, hora_fin time not null,
                      foreign key (id_socio) references socio(id_socio)); 

     

