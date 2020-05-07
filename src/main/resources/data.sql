drop table if exists items;
drop table if exists order_details;
drop table if exists item_details;
drop table if exists items_sequence;
drop table if exists item_sequence;
drop table if exists order_details_sequence;
create table items_sequence (next_val bigint not null) engine=InnoDB;
create table item_sequence (next_val bigint not null) engine=InnoDB;
create table order_details_sequence (next_val bigint not null) engine=InnoDB;
insert into item_sequence values ( 10001 );
insert into items_sequence values ( 20001 );
insert into order_details_sequence values ( 30001 );
create table item_details (id integer not null, amount double precision, descritpion varchar(100), item_category varchar(100), item_type varchar(100), name varchar(100), primary key (id)) engine=InnoDB;
create table items (id integer not null, item_total double precision, quantity integer not null, order_id integer not null, product_id integer not null, primary key (id)) engine=InnoDB;
create table order_details (id integer not null, name varchar(100) not null, order_date datetime(6), status varchar(50), primary key (id)) engine=InnoDB;
alter table items add constraint FK2lxjlojvpofhkxqq552r5q1s2 foreign key (order_id) references order_details (id);
alter table items add constraint FKr143c1qf52800v8edneaogdxt foreign key (product_id) references item_details (id);

insert into item_details (id, amount, descritpion, item_category, item_type, name) values(
10001,
300,
'Java Book',
'Books',
'Books',
'Java-8 Book'
);

insert into item_details (id, amount, descritpion, item_category, item_type, name) values(
10002,
500,
'MicroService Book',
'Books',
'Books',
'MicroService Book'
);

insert into order_details(id, name, order_date, status) values(
3001,
'order-1001',
curdate(),
'Ordered'
);

insert into items(id, product_id, item_total, quantity, order_id) values(
2001,
10001,
1,
4,
3001
);

insert into items(id, product_id, item_total, quantity, order_id) values(
2002,
10002,
1,
4,
3001
);

insert into order_details(id, name, order_date, status) values(
3002,
'order-1002',
curdate(),
'Ordered'
);

--insert into items(id, item_id, item_total, product_id, quantity, order_id) values(
--2003,
--'item-1',
--1001,
--1,
--4,
--3002
--);
--
--insert into items(id, item_id, item_total, product_id, quantity, order_id) values(
--2004,
--'item-1',
--1002,
--1,
--4,
--3002
--);


