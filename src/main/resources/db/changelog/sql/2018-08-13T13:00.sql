-- Tabla usuario
CREATE TABLE public.usuario
(
  id_usuario serial not null primary key,
  login character varying(30) not null,
  password character varying(256) NOT NULL,  
  activo boolean,
  expira boolean,
  fecha_expiracion date,
  id_sanatorio int4
  
);

--Tabla roles
CREATE TABLE public.roles
(
  id serial not null primary key,
  role character varying(50)
);
