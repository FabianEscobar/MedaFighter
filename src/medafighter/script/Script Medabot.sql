create table MEDABOT
(
	SALUDMAXIMA INTEGER not null,
	NOMBRE VARCHAR(64) not null,
	USUARIO VARCHAR(64) not null,
	CABEZA VARCHAR(64) not null,
	BRAZOIZQ VARCHAR(64) not null,
	BRAZODER VARCHAR(64) not null,
	PIERNAIZQ VARCHAR(64) not null,
	PIERNADER VARCHAR(64) not null,
	MEDALLA VARCHAR(64) not null,
	IMAGEN INTEGER default 1 not null
);

create table MEDALLA
(
	NOMBRE VARCHAR(64) not null primary key,
	POTENCIADOR VARCHAR(64) not null,
	CANTIDAD INTEGER not null,
	TIPOCARGA VARCHAR(64) not null,
	MEDAFUERZA VARCHAR(64) default 'Poder' not null
);

create table MEDALLAUSUARIO
(
	USUARIO VARCHAR(64) not null,
	MEDALLA VARCHAR(64) not null,
	primary key (USUARIO, MEDALLA)
);

create table MEDAPARTE
(
	NOMBRE VARCHAR(64) not null primary key,
	SALUDMAXIMA INTEGER not null,
	TIPO VARCHAR(64) not null,
	ATAQUE INTEGER not null,
	HABILIDAD VARCHAR(64) not null,
	DEFENSA INTEGER not null,
	PRECISIO INTEGER not null,
	RECUPERACION INTEGER not null,
	ESQUIVE INTEGER not null,
	PUNTOSHABILIDAD INTEGER not null
);

create table MEDAPARTEUSUARIO
(
	USUARIO VARCHAR(64) not null,
	MEDAPARTE VARCHAR(64) not null,
	primary key (USUARIO, MEDAPARTE)
);

create table USUARIO
(
	NOMBRE VARCHAR(64) not null primary key,
	PASS VARCHAR(64) not null,
	TIPO VARCHAR(16) default 'CPU' not null,
	VICTORIAS INTEGER default 0 not null,
	DERROTAS INTEGER default 0 not null,
	TORNEOS INTEGER default 0 not null
);

create table SESIONESACTIVAS
(
	NOMBRE VARCHAR(64) not null primary key,
	PASS VARCHAR(64) not null
);


/*Script*/
/****************** MEDAPARTES  ************************/
/*Cabezas*/
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Cohete (C)',500,'Cabeza',250,'Misiles rastreadores',50,50,0,0,5);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Generica (C)',300,'Cabeza',10,'Cuerpo a cuerpo',20,50,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Bestial (C)',700,'Cabeza',300,'Cuerpo a cuerpo',70,50,0,20,7);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Mira (C)',500,'Cabeza',200,'Disparo',50,70,0,0,5);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Cura (C)',700,'Cabeza',150,'Regeneracion',60,30,50,0,5);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Tanque (C)',600,'Cabeza',300,'Anti aereos',80,40,0,0,5);


/*Brazos*/
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Canon (BD)',500,'BrazoDer',40,'Disparo',50,20,0,0,2);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Canon (BI)',500,'BrazoIzq',40,'Disparo',50,30,0,0,2);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Noqueador (BD)',500,'BrazoDer',10,'Cuerpo a cuerpo',50,45,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Noqueador (BI)',500,'BrazoIzq',10,'Cuerpo a cuerpo',50,30,0,0,1);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Generico (BD)',200,'BrazoDer',5,'Cuerpo a cuerpo',20,50,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Generico (BI)',200,'BrazoIzq',5,'Cuerpo a cuerpo',20,50,0,0,1);

/*Piernas*/

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Veloz (PD)',500,'PiernaDer',10,'Cuerpo a cuerpo',30,35,0,15,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Veloz (PI)',500,'PiernaIzq',10,'Cuerpo a cuerpo',30,35,0,15,1);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Generica (PD)',200,'PiernaDer',5,'Cuerpo a cuerpo',20,40,0,5,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Generica (PI)',200,'PiernaIzq',5,'Cuerpo a cuerpo',20,40,0,5,1);


/* Medallas */
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Escarabajo','precision',50,'venganza','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Mono','ataqueCercano',50,'racha','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Tortuga','defensa',50,'concentracion','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Medusa','esquive',50,'venganza','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Aracna','precision',50,'racha','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Gato','ataqueCercano',50,'concentracion','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Serpiente','defensa',50,'venganza','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Fenix','esquive',50,'racha','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Dragon','precision',50,'concentracion','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Demonio','ataqueCercano',50,'venganza','Reaccion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Angel','defensa',50,'racha','Reaccion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Fantasma','esquive',50,'concentracion','Reaccion');


/****************** PNJs  ************************/


/* CPU1 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu1','cpu1','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (1100,'cpu1','cpu1','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu1','Mono');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu1','Cabeza Generica (C)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu1','Brazo Generico (BI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu1','Brazo Generico (BD)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu1','Pierna Generica (PI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu1','Pierna Generica (PD)');

/* CPU2 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu2','cpu2','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (1100,'cpu2','cpu2','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Aracna',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu2','Aracna');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu2','Cabeza Generica (C)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu2','Brazo Generico (BI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu2','Brazo Generico (BD)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu2','Pierna Generica (PI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu2','Pierna Generica (PD)');

/* CPU3 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu3','cpu3','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (2500,'cpu3','cpu3','Cabeza Cohete (C)','Brazo Canon (BI)','Brazo Canon (BD)','Pierna Veloz (PI)','Pierna Veloz (PD)','Dragon',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu3','Dragon');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu3','Cabeza Cohete (C)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu3','Brazo Canon (BI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu3','Brazo Canon (BD)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu3','Pierna Veloz (PI)');
insert into medaparteusuario (usuario,medaparte) VALUES ('cpu3','Pierna Veloz (PD)');