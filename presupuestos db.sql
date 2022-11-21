
create database presupuestos_db;

drop database presupuestos_db;
use presupuestos_db;

create table Ingresos(
	id int auto_increment,
    descripcion varchar(20),
    valor float,
    presupuesto int,
    primary key(id),
    foreign key(presupuesto) references Presupuesto(id)
);

create table Egresos(
	id int auto_increment,
    descripcion varchar(20),
    valor float,
	presupuesto int,
    primary key(id),
    foreign key(presupuesto) references Presupuesto(id)
);

create table Presupuesto(
	id int auto_increment,
    valor float,
    primary key(id)
);

select * from Presupuesto;


drop table Presupueso;
describe presupuesto_db;

show tables;

/* adding foreign key ingresos */
alter table Presupuesto add column ingresos int;

alter table Presupuesto
add foreign key (ingresos) references Presupuesto(id);

/* adding foreign key egresos */
alter table Presupuesto add column egresos int;

alter table Presupuesto
add foreign key (egresos) references Presupuesto(id);

update Presupuesto
set ingresos = 4;

insert into Presupuesto (valor) values
(2000.00),
(4300.00),
(432000.00),
(1200.00),
(4900.00);


insert into Presupuesto (valor) values
(2290.00);



insert into Ingresos (descripcion, valor, presupuesto) values
("ventas", 200.0, 3),
("codigo", 200.0, 2);

select * from Ingresos;

insert into Egresos (descripcion, valor, presupuesto) values
("ropa", 300.0, 4),
("comida", 140.0, 1),
("pasaje", 493.0, 2),
("visita", 140.0, 4),
("zapatos", 400.0, 3);

/* all describe */
describe Ingresos;
describe Presupuesto;
describe Egresos;

/* all selects */
select * from Egresos;
select * from Ingresos;
select * from Presupuesto;

