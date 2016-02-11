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
        TIPO VARCHAR(64) not null,
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
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Generica (C)',300,'Cabeza',30,'Cuerpo a cuerpo',20,80,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Bestial (C)',700,'Cabeza',300,'Cuerpo a cuerpo',70,80,0,20,7);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Mira (C)',500,'Cabeza',200,'Disparo',50,80,0,0,5);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Cura (C)',700,'Cabeza',150,'Regeneracion',60,80,50,0,5);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Cabeza Tanque (C)',600,'Cabeza',300,'Anti aereos',80,80,0,0,5);


/*Brazos*/
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Canon (BD)',500,'BrazoDer',60,'Disparo',50,80,0,0,2);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Canon (BI)',500,'BrazoIzq',60,'Disparo',50,80,0,0,2);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Espada (BD)',500,'BrazoDer',70,'Cuerpo a cuerpo',50,80,0,0,3);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Escudo (BI)',1000,'BrazoIzq',30,'Cuerpo a cuerpo',100,80,0,0,3);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Noqueador (BD)',500,'BrazoDer',60,'Cuerpo a cuerpo',50,80,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Noqueador (BI)',500,'BrazoIzq',60,'Cuerpo a cuerpo',50,80,0,0,1);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Generico (BD)',200,'BrazoDer',30,'Cuerpo a cuerpo',20,80,0,0,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Brazo Generico (BI)',200,'BrazoIzq',30,'Cuerpo a cuerpo',20,80,0,0,1);

/*Piernas*/

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Veloz (PD)',500,'PiernaDer',40,'Cuerpo a cuerpo',30,80,0,15,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Veloz (PI)',500,'PiernaIzq',40,'Cuerpo a cuerpo',30,80,0,15,1);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Generica (PD)',200,'PiernaDer',30,'Cuerpo a cuerpo',20,80,0,5,1);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Generica (PI)',200,'PiernaIzq',30,'Cuerpo a cuerpo',20,80,0,5,1);

insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Armadura (PD)',1000,'PiernaDer',30,'Cuerpo a cuerpo',50,80,0,5,2);
insert into medaparte (nombre,saludmaxima,tipo,ataque,habilidad,defensa,precisio,recuperacion,esquive,puntoshabilidad) values ('Pierna Armadura (PI)',1000,'PiernaIzq',30,'Cuerpo a cuerpo',50,80,0,5,2);


/* Medallas */
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Escarabajo','precision',20,'venganza','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Mono','ataqueCercano',20,'racha','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Tortuga','defensa',20,'concentracion','Poder');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Medusa','esquive',20,'venganza','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Aracna','precision',20,'racha','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Gato','ataqueCercano',20,'concentracion','Velocidad');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Serpiente','defensa',20,'venganza','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Fenix','esquive',30,'racha','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Dragon','precision',40,'concentracion','Regeneracion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Demonio','ataqueCercano',50,'venganza','Reaccion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Angel','defensa',40,'racha','Reaccion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Fantasma','esquive',40,'concentracion','Reaccion');
insert into medalla (nombre,potenciador,cantidad,tipocarga,medafuerza) values ('Caballero','defensa',30,'fe','Invulnerabilidad');

/****************** PNJs  ************************/


/* CPU1 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu1','cpu1','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (1100,'cpu1V1','cpu1','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Mono',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu1','Mono');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu1','Cabeza Generica (C)','Cabeza');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu1','Brazo Generico (BI)','BrazoIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu1','Brazo Generico (BD)','BrazoDer');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu1','Pierna Generica (PI)','PiernaIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu1','Pierna Generica (PD)','PiernaDer');

/* CPU2 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu2','cpu2','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (1100,'cpu2V1','cpu2','Cabeza Generica (C)','Brazo Generico (BI)','Brazo Generico (BD)','Pierna Generica (PI)','Pierna Generica (PD)','Aracna',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu2','Aracna');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu2','Cabeza Generica (C)','Cabeza');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu2','Brazo Generico (BI)','BrazoIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu2','Brazo Generico (BD)','BrazoDer');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu2','Pierna Generica (PI)','PiernaIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu2','Pierna Generica (PD)','PiernaDer');

/* CPU3 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu3','cpu3','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (2500,'cpu3V1','cpu3','Cabeza Cohete (C)','Brazo Canon (BI)','Brazo Canon (BD)','Pierna Veloz (PI)','Pierna Veloz (PD)','Dragon',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu3','Dragon');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu3','Cabeza Cohete (C)','Cabeza');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu3','Brazo Canon (BI)','BrazoIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu3','Brazo Canon (BD)','BrazoDer');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu3','Pierna Veloz (PI)','PiernaIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu3','Pierna Veloz (PD)','PiernaDer');

/* CPU4 */

insert into usuario (nombre,pass,tipo,victorias,derrotas,torneos) values ('cpu4','cpu4','CPU',0,0,0);
insert into medabot (saludmaxima,nombre,usuario,cabeza,brazoizq,brazoder,piernaizq,piernader,medalla,imagen) values (2500,'cpu4V1','cpu4','Cabeza Tanque (C)','Brazo Escudo (BI)','Brazo Espada (BD)','Pierna Armadura (PI)','Pierna Armadura (PD)','Tortuga',0);
insert into medallausuario (usuario,medalla) VALUES ('cpu4','Tortuga');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu4','Cabeza Tanque (C)','Cabeza');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu4','Brazo Escudo (BI)','BrazoIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu4','Brazo Espada (BD)','BrazoDer');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu4','Pierna Armadura (PI)','PiernaIzq');
insert into medaparteusuario (usuario,medaparte,tipo) VALUES ('cpu4','Pierna Armadura (PD)','PiernaDer');