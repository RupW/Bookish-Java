create database bookish_schema;
use bookish_schema;

create table users (
    id int not null auto_increment primary key,
    fname varchar(100),
    lname varchar(100),
    no_of_books int default 0
);

create table book (
    id int not null auto_increment primary key,
    title varchar(100) not null,
    author varchar(100) not null,
    genre varchar(30),
    year int,
    no_in_stock int
);

create table rental (
    id int not null auto_increment primary key,
    user_id int not null,
    book_id int not null,
    date_out datetime,
    date_in datetime,
    foreign key rental_user_id (user_id) references users(id),
    foreign key rental_book_id (book_id) references book(id)
);

create table technologies (
    id int not null auto_increment primary key,
	name varchar(100),
    logoUrl varchar(256)
);
