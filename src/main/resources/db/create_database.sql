-- Run this with psql
CREATE USER "hercules" WITH ENCRYPTED PASSWORD 'hercules';
ALTER ROLE "hercules" WITH createdb;

CREATE DATABASE hercules_rest
  WITH OWNER = hercules
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_PY.UTF-8'
       LC_CTYPE = 'es_PY.UTF-8'
       CONNECTION LIMIT = -1;
