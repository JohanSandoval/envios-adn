create table if not exists envio(
  id int not null auto_increment,
  nombre varchar(45) not null,
  apellido varchar(45) not null,
  telefono varchar(45) not null,
  ciudad_origen_id int(11) not null,
  ciudad_destino_id int(11) not null,
  peso double not null,
  costo double not null,
  fecha_llegada varchar(45) not null,
  primary key (id)
);