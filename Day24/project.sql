create database eshop;

create table eshop.category(
	cate_id int AUTO_INCREMENT,
	cate_name varchar(100) NOT NULL UNIQUE,	
	PRIMARY KEY(cate_id)
);
create table eshop.subcategory(
	scate_id int AUTO_INCREMENT,
	scate_name varchar(100) NOT NULL UNIQUE,	
	category int,
	FOREIGN KEY(category) REFERENCES eshop.category(cate_id),
	PRIMARY KEY(scate_id)
);
create table eshop.product(
	prod_id int AUTO_INCREMENT,
	prod_name varchar(100) NOT NULL,
	company varchar(100) NOT NULL,
	price float NOT NULL,
	pic1 varchar(100) NOT NULL,
	pic2 varchar(100),
	pic3 varchar(100),
	category int,
	subcategory int,
	isactive boolean default true,
	FOREIGN KEY(category) REFERENCES eshop.category(cate_id),
	FOREIGN KEY(subcategory) REFERENCES eshop.subcategory(scate_id),
	PRIMARY KEY(prod_id)
);
