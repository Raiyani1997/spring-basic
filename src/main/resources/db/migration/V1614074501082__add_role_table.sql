drop table if exists user_role;

CREATE TABLE user_role (
	id serial NOT NULL,
	created_by integer NOT NULL,
	created_on timestamp NOT NULL,
	modified_by integer NULL,
	modified_on timestamp NULL,
	code varchar(255) NULL,
	description varchar(500) NULL,
	"name" varchar(50) NOT NULL,
	state text
);