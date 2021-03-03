--Datos para carga inicial de la base de datos

delete from socio;
delete from tecnico;
delete from licencia;
delete from recibo;
delete from asamblea;



insert into socio(id, DNI , nombre , sexo  , fecha_nac, club , num_licencia , IBAN , cuota , DNI_tutor, DNI_tecnico) values 
	
        (1, 00000000A ,'Marta Perez Lopez','M','1965-12-06', 0000001, 'ES6000491500051234567892' , 250 ,  , 73264894D),
        (2, 00000001B ,'Jorge Martinez Sanchez','H','1974-04-01', 0000002, 'ES6000446350056789567892' , 275 ,  , 4523194H),
        (3, 00000002C  ,'Jesus Ramon Ramon','H','1998-06-04', 0000003, 'ES6000491475131245107892' , 220 ,  , 56410347R),
        (4, 00000003D ,'Diego Gonzalez Prieto','H','1985-09-10', 0000004, 'ES4984491450151264037954' , 350 ,  , c); 



insert into tecnico (id_tecnico , DNI_tecnico , nombre_tecnico, num_licencia) values 

       (1, 73264894D, 'Rodrigo Nuñez Gavela', 696969), 
       (2, 4523194H , 'Mario Mendez Martinez', 888888), 
       (3, 56410347R, 'Maria Rodriguez Prieto', 123123),
       (4, 65138741S, 'Luis Ramon Guerrero', 987987); 




insert into licencia (id_licencia , num_licencia, estado) values 

       (1, 0000001, 'Pagada'), 
       (2, 0000002, 'Pendiente'),
       (3, 0000003, 'Pendiente'),
       (4, 0000004, 'Pagada'), 
       (5, 696969 , 'Pagada'),
       (6, 888888 , 'Pagada'),
       (7, 123123 , 'Pagada'),
       (8, 987987 , 'Pagada');



insert into recibo (id_recibo, num_recibo , concepto , fecha_valor , fecha_emision , datos_socio ) values 
     
      (1, 000001, 'Pago matricula total', '2020-05-17', 2020-05-22', 'Marta Perez Lopez'),
      (2, 000002, 'Pago matricula parcial', '2020-11-07', 2020-11-13', 'Jorge Martinez Sanchez'),
      (3, 000003, 'Pago matricula', '2021-01-02', 2021-01-06', 'Jesus Ramon Ramon'),
      (4, 000004, 'Reserva', '2021-02-14', 2021-02-21', 'Diego Gonzalez Prieto'); 



insert into asamblea (id_asamblea , tipo , orden_dia , fecha , hora) values 

      (1, 'Ordinaria', '1.Limpieza Ventanas 2.Limpieza Escalera', '2021-03-15', 17:00:00),
      (2, 'Extraordinaria', '1.Arreglo luces 2.Limpieza Ventanas 3.Sacar basura', '2021-04-20', 12:00:00),
      (3, 'Ordinaria', '1.Eleccion presidente 2.Arreglo caldera', '2021-03-15', 15:15:00),
      (4, 'Extraordinaria', '1.Reparto tareas limpieza 2.Contratacion portero', '2021-03-23', 16:30:00); 




 

    
      





