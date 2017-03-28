delete from drivers;
delete from users;
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (1, 'default.png', 'nash@gmail.com', 'John', 'Nash', 'jonny',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (2, 'default.png', 'turing@gmail.com', 'Alan', 'Turing', 'automan',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (3, 'default.png', 'nash@gmail.com', 'John', 'Nash', 'jonny',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (4, 'default.png', 'turing@gmail.com', 'Alan', 'Turing', 'automan',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (5, 'default.png', 'nash@gmail.com', 'John', 'Nash', 'jonny',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (6, 'default.png', 'turing@gmail.com', 'Alan', 'Turing', 'automan',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (7, 'default.png', 'nash@gmail.com', 'John', 'Nash', 'jonny',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (8, 'default.png', 'turing@gmail.com', 'Alan', 'Turing', 'automan',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (9, 'default.png', 'nash@gmail.com', 'John', 'Nash', 'jonny',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');
insert into users(id, avatar, email, firstname, surname, nickname, password, role)
values (10, 'default.png', 'turing@gmail.com', 'Alan', 'Turing', 'automan',  'd41d8cd98f00b204e9800998ecf8427e', 'USER');

insert into drivers(id, experience, rating,user_id)
values (1, 3, 4, 2);
insert into drivers(id, experience, rating,user_id)
values (2, 0, 1, 1);
insert into drivers(id, experience, rating,user_id)
values (3, 1, 2, 3);
insert into drivers(id, experience, rating,user_id)
values (4, 2, 2, 4);
insert into drivers(id, experience, rating,user_id)
values (5, 5, 5, 5);
insert into drivers(id, experience, rating,user_id)
values (6, 4, 1, 6);
insert into drivers(id, experience, rating,user_id)
values (7, 6, 3, 7);
insert into drivers(id, experience, rating,user_id)
values (8, 8, 0, 8);
insert into drivers(id, experience, rating,user_id)
values (9, 7, 1, 9);
insert into drivers(id, experience, rating,user_id)
values (10, 9, 0, 10);