--Table usaurios x roles
CREATE TABLE public.usuarios_x_role
(
  id_usuario_x_role serial not null primary key,
  id_usuario integer,
  id_role integer,
  
  CONSTRAINT usuario_x_role_roles FOREIGN KEY (id_role)
      REFERENCES public.roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT usuario_x_role_usuarios FOREIGN KEY (id_usuario)
      REFERENCES public.usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

--Se inicializa datos de roles (verificar para su real implementacion en la logia de negocio)
insert into public.roles (role) values ('ROLE_USER');
insert into public.roles (role) values ('ROLE_ADMIN');

--Se inicializa el usuario admin por defecto para desarrollo (cambiar para produccion)
insert into public.usuario (login, password, activo, expira, id_sanatorio) 
values ('admin', '$2a$10$KrFy6PT3HD8PiMQziEcizuMipe5Fe89UXFBcEiWafGsEEGzcKajRS', true, false,1);

--user: admin
--pass: admin

--Se inserta el role USER para el ADMIN
INSERT INTO public.usuarios_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id_usuario FROM public.usuario WHERE login = 'admin'),
    (SELECT id FROM public.roles WHERE role = 'ROLE_USER'));

    --Se inserta el role ADMIN para el ADMIN
INSERT INTO public.usuarios_x_role (id_usuario, id_role)
  VALUES (
    (SELECT id_usuario FROM public.usuario WHERE login = 'admin'),
    (SELECT id FROM public.roles WHERE role = 'ROLE_ADMIN'));
