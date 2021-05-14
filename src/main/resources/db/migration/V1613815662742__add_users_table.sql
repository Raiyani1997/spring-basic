DROP TABLE if exists users;

CREATE TABLE users (
	id serial NOT NULL,
	user_name text NOT NULL,
	first_name text NULL,
	last_name text NULL,
	email_id text NULL,
	"password" text NULL,
	state text NULL DEFAULT 'ACTIVE'::text,
	role_id integer NULL,
	created_on timestamp NULL,
	modified_on timestamp NULL,
	contact_number varchar(15) NULL,
	created_by integer NULL,
	modified_by integer NULL
);