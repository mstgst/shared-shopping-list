BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, list, list_item, groups, group_member;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	is_activated boolean,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


DROP SEQUENCE IF EXISTS seq_group_id, seq_list_id, seq_list_item_id;

CREATE SEQUENCE seq_group_id
	INCREMENT BY 1
	START WITH 1001
	NO MAXVALUE;
CREATE TABLE  groups (
	group_id int NOT NULL DEFAULT nextval('seq_group_id'),
	group_name varchar(50) NOT NULL,
	group_owner int NOT NULL,
	description varchar(500),
	group_code varchar(10) NOT NULL,
	date_created varchar(500) NOT NULL,
	CONSTRAINT PK_group PRIMARY KEY (group_id),
	CONSTRAINT FK_group_owner FOREIGN KEY (group_owner) REFERENCES users (user_id)
);

CREATE TABLE group_member (
    user_id int NOT NULL,
    group_id int NOT NULL,
    date_joined varchar(50) NOT NULL,
    CONSTRAINT PK_group_member PRIMARY KEY (user_id, group_id),
    CONSTRAINT FK_group_member_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_group_member_group FOREIGN KEY (group_id) REFERENCES groups (group_id)
);

CREATE SEQUENCE seq_list_id
	INCREMENT BY 1
	START WITH 2001
	NO MAXVALUE;
CREATE TABLE list (
	list_id int NOT NULL DEFAULT nextval('seq_list_id'),
	group_id int NOT NULL,
	list_title varchar(50) NOT NULL,
	list_completed boolean,
	claimed int,
	description varchar(500),
    date_modified varchar(50) NOT NULL,
	CONSTRAINT PK_list PRIMARY KEY (list_id),
	CONSTRAINT FK_list_group FOREIGN KEY (group_id) REFERENCES groups (group_id)
);

CREATE SEQUENCE seq_list_item_id
    INCREMENT BY 1
    START WITH 3001
    NO MAXVALUE;
CREATE TABLE list_item (
    list_item_id int NOT NULL DEFAULT nextval('seq_list_item_id'),
    list_id int NOT NULL,
    group_id int NOT NULL,
    status boolean NULL,
    date_modified varchar(50) NULL,
    quantity int NOT NULL,
    last_modifier int NOT NULL,
    item_name varchar(50),
    CONSTRAINT PK_list_item PRIMARY KEY (list_item_id),
    CONSTRAINT FK_list_item_list FOREIGN KEY (list_id) REFERENCES list (list_id),
    CONSTRAINT FK_list_item_group FOREIGN KEY (group_id) REFERENCES groups (group_id),
    CONSTRAINT chk_quantity CHECK (quantity > 0)
    );

COMMIT TRANSACTION;
