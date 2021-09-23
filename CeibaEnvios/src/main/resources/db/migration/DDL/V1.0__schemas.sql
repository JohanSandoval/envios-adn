create table if not exists usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

CREATE TABLE destinatario (
  id int(11) NOT NULL auto_increment,
  cedula int(11) NOT NULL,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  ciudad varchar(45) NOT NULL,
  direccion varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE remitente (
  id int(11) NOT NULL auto_increment,
  cedula int(11) NOT NULL,
  nombre varchar(45) NOT NULL,
  apellido varchar(45) NOT NULL,
  ciudad varchar(45) NOT NULL,
  telefono varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

create table envio(
id int(11) not null auto_increment,
id_remitente int(11) not null,
id_destinatario int(11) not null,
peso double not null,
costo double(11,0) not null,
fecha_llegada datetime not null,
primary key (id),
foreign key (id_remitente) references remitente(id),
foreign key (id_destinatario) references destinatario(id)
);

