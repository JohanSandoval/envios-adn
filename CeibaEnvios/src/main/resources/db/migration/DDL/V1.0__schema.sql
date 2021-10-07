CREATE TABLE ciudad (
      id INT NOT NULL AUTO_INCREMENT,
      nombre VARCHAR(45) NOT NULL,
      PRIMARY KEY (id)
);

CREATE TABLE dias_espera (
      id INT(11) NOT NULL AUTO_INCREMENT,
      id_ciudad_origen INT(11) NOT NULL,
      id_ciudad_destino INT(11) NOT NULL,
      dias INT(11) NOT NULL,
      PRIMARY KEY (id),
      foreign key (id_ciudad_origen) references ciudad(id),
      foreign key (id_ciudad_destino) references ciudad(id)
);

CREATE TABLE usuario (
      id int(11) NOT NULL auto_increment,
      cedula int(11) NOT NULL,
      nombre varchar(45) NOT NULL,
      apellido varchar(45) NOT NULL,
      id_ciudad int(11) NOT NULL,
      telefono varchar(45) NOT NULL,
      PRIMARY KEY (id),
      foreign key (id_ciudad) references ciudad(id)
);

CREATE TABLE costo_envio (
      id int NOT NULL AUTO_INCREMENT,
      peso_maximo double NOT NULL,
      peso_minimo double NOT NULL,
      costo double NOT NULL,
      PRIMARY KEY (id)
);

CREATE TABLE envio(
    id int(11) not null auto_increment,
    id_usuario_remitente int(11) not null,
    id_usuario_destinatario int(11) not null,
    peso double not null,
    costo double not null,
    fecha_llegada datetime,
    direccion varchar(150) not null,
    primary key (id),
    foreign key (id_usuario_remitente) references usuario(id),
    foreign key (id_usuario_destinatario) references usuario(id)
);

