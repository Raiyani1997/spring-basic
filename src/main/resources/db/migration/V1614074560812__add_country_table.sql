drop table if exists countries;

CREATE TABLE countries (
	id serial NOT NULL,
	created_by integer NOT NULL,
	created_on timestamp NOT NULL,
	modified_by integer NULL,
	modified_on timestamp NULL,
	name text NULL,
    population integer
);