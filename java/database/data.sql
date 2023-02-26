BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Eli','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Kirk','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Luke','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Daniel','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Drew','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('TonyHawk','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('string','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Bill','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Susan','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Richard','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Steven','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Joyce','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Matt','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Chris','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Anna','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Peter','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Nate','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Cassandra','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Sophie','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Ellie','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Clemmie','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Lacy','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('Maci','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO groups (group_owner, group_name, group_code, date_created) values (1, 'Fridggrs', '111', '10-11-2020');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'All You', '222', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (3, 'Need', '333', '10-12-2019');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'No Kirks', '333', '10-13-2020');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'Tony Hawks', '444', '10-14-2020');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (3, 'Campers', '111', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'Skaters', '111', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (3, 'Vue Fans', '444', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'Zoomers', '333', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (3, 'Boomers', '444', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (2, 'Doomers', '222', '10-15-2021');
INSERT INTO groups (group_owner, group_name, group_code, date_created) values (3, 'Zombies', '444', '10-15-2021');

INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1001, 'Weekly', 'Our weekly needs', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1001, 'Monthly', 'Our weekly needs', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1001, 'Yearly', 'test description', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1001, 'Christmas', 'Santa has lists, too', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1001, 'Flag Day', 'All of your flag day needs', 'date', false, 0);

INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1002, 'Weekly', 'No, our weekly needs!', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1002, 'List of List', 'No, our weekly needs!', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1002, 'Flag Day', 'No, this is the list for flag day!', 'date', false, 0);

INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1003, 'Tax Day', ' :( ', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1003, 'Christmas', 'Santa has needs too :(', 'date', false, 0);

INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1004, 'Birthday Cake', 'Cake for Daniels bday', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1005, 'Misc', 'Just some other groceries', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1006, 'Weekly', 'Our weekly needs', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1007, 'School Supplies', 'Back to school needs', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1008, 'Christmas', 'Santa has needs too', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1009, 'Pizza Night', 'What Dad needs to pizza', 'date', false, 0);
INSERT INTO list (group_id, list_title, description, date_modified, list_completed, claimed) VALUES (1010, 'Game Night', 'What the game needs to pizza', 'date', false, 0);




INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 2, 2, false, 2001, 1001, 'Half eggs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 60, 2, false, 2002, 1001,'Half monthly eggs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 2, false, 2003, 1001, 'Half yearly eggs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 5, 2, false, 2004, 1001, 'Half Xmas eggs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 4, 2, false, 2008, 1001, 'Half flags');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 2, 2, false, 2001, 1001, 'dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 50,2, false, 2002, 1001, 'monthly dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 2, false, 2003, 1001, 'yearly dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 5, 2, false, 2004, 1001, 'Christmas dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 4, 2, false, 2008, 1001, 'dozen flags');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 9, 2, false, 2001, 1001, 'Cups of almonds');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 29, 2, false, 2002, 1001, 'Cups of almonds');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 39, 2, false, 2003, 1001, 'lbs of flour');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 49, 2, false, 2004, 1001, 'Cups of Xmas nuts');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 59, 2, false, 2008, 1001, 'Cups of flags');


INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 9, 2, false, 2001,  1002, 'Hydrous of almonds');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 29, 2, false, 2002, 1002, 'Cups of juice');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 39, 2, false, 2003, 1002, 'lbs. Sugar');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 2, false, 2004, 1002, 'dozen hot yearly dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 5, 2, false, 2004, 1002, 'lbs. Sugar');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 4, 2, false, 2005, 1002, 'Hydrous flags');


INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2001, 1002, 'Barkeepers Friend');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 5, false, 2003, 1002, 'lbs. Sugar');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 4, false, 2001, 1002, 'Bags of Flour');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 4, false, 2002, 1002, 'Gal. of Milk');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 21, 4, false,2001, 1002, 'Birthday Candles');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2002, 1002, 'Hydrofluoric Acid');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2003, 1002, 'Tube furnace');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 3, false, 2002, 1002, 'Hydrous methylation');


INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 9, 2, false, 2009,  1003, 'Hydrous of almonds');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 29, 2, false, 2010, 1003, 'Cups of juice');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 39, 2, false, 2009, 1003, 'lbs. Sugar');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 2, false, 2009, 1003, 'dozen hot yearly dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 5, 2, false, 2010, 1003, 'lbs. Sugar');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 4, 2, false, 2009, 1003, 'Hydrous flags');


INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2009, 1003, 'Barkeepers Friend');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 5, false, 2010, 1003, 'lbs. Sugar');



INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 2, false, 2006, 1002, 'dozen hot yearly dogs');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 5, 2, false, 2008, 1002, 'lbs. Sugar');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 4, 2, false, 2008, 1002, 'Hydrous flags');


INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2006, 1002, 'Barkeepers Friend');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 5, false, 2006, 1002, 'lbs. Sugar');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 4, false, 2007, 1002, 'Bags of Flour');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 4, false, 2002, 1002, 'Gal. of Milk');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 21, 4, false,2006, 1002, 'Birthday Candles');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2007, 1002, 'Hydrofluoric Acid');
INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 1, 3, false, 2007, 1002, 'Tube furnace');

INSERT INTO list_item (date_modified, quantity, last_modifier, status, list_id, group_id, item_name) VALUES ('CHANGE date', 6, 3, false, 2006, 1002, 'Hydrous methylation');



INSERT INTO group_member (user_id, group_id, date_joined) VALUES (1,  1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (11, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (12, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (13, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (14, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (15, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (16, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (17, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (18, 1001, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (19, 1001, 'date');

INSERT INTO group_member (user_id, group_id, date_joined) VALUES (1, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (8, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (2, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (3, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (4, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (5, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (6, 1002, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (7, 1002, 'date');


INSERT INTO group_member (user_id, group_id, date_joined) VALUES (2, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (3, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (4, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (5, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (6, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (7, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (8, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (9, 1003, 'date');
INSERT INTO group_member (user_id, group_id, date_joined) VALUES (10, 1003, 'date');

COMMIT TRANSACTION;
