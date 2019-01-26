-- Tabla apis logger
create table api_log (
	id_api_log serial not null primary key,
	api character varying(100),
        usuariolog character varying(50),
	param1 character varying(20),
	param2 character varying(20),
	param3 character varying(20),
        fechalog timestamp default now()
);


