create database electronic_shop;

use electronic_shop;

create table category(
	category_id int AUTO_INCREMENT,
	category_name varchar(100) NOT NULL UNIQUE,	
	PRIMARY KEY(category_id)
);

create table variant(
	variant_id int AUTO_INCREMENT,
	variant_name varchar(100) NOT NULL UNIQUE,	
	category_id int,
	PRIMARY KEY(variant_id),
    FOREIGN KEY(category_id) REFERENCES category(category_id),
);
create table product(
	product_id int AUTO_INCREMENT,
    category_id int,
	variant_id int,
	product_name varchar(100) NOT NULL,
	company_name varchar(100) NOT NULL,
	price float NOT NULL,
    PRIMARY KEY(product_id),
	FOREIGN KEY(category_id) REFERENCES category(category_id),
	FOREIGN KEY(variant_id) REFERENCES variant(variant_id),
);

insert into category(category_name) values("TV");
insert into category(category_name) values("Cooler");
insert into category(category_name) values("Mobile");

insert into variant(variant_name,category_id) values("Plasma TV",1);
insert into variant(variant_name,category_id) values("LCD TV",1);
insert into variant(variant_name,category_id) values("Android",2);
insert into variant(variant_name,category_id) values("iPhone",2);

insert into product(category_id,variant_id,product_name,company_name,price) values(1,2,"MI LED Smart TV","Xiaomi",12000.00);
insert into product(category_id,variant_id,product_name,company_name,price) values(3,3,"Redmi Note 4","Xiaomi",10000.00);
