create table estado_factura (
	id_estado_factura serial not null primary key,
	descripcion character varying(100)
);

insert into estado_factura (descripcion) values ('ORIGEN');
insert into estado_factura (descripcion) values ('ENVIADO');
insert into estado_factura (descripcion) values ('RECIBIDO');
-- Tabla factura
create table factura (
	id_factura serial not null primary key,
	id_sanatorio integer,
	nro_factura character varying(200),
        usuariolog character varying(100),
	id_estado integer not null,
	observacion character varying(200),
        fechalog timestamp default now()
);


