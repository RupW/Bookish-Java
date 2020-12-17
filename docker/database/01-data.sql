use bookish_schema;

insert into users(fname, lname) values ('Will', 'Rothery');
insert into users(fname, lname) values ('John', 'Lennon');
insert into users(fname, lname) values ('Paul', 'McCartney');
insert into users(fname, lname) values ('George', 'Harrison');
insert into users(fname, lname) values ('Ringo', 'Starr');

insert into book(title, author, genre, year, no_in_stock)
values ('Harry Potter and the Philosopher\'s Stone', 'JK Rowling', 'Fantasy', 1997, 5);
insert into book(title, author, genre, year, no_in_stock)
values ('The Gruffalo', 'Julia Donaldson', 'Childrens', 1999, 2);
insert into book(title, author, genre, year, no_in_stock)
values ('The Hunger Games', 'Suzanne Collins', 'Fantasy', 2008, 1);

insert into technologies(name, logoUrl)
values ('Spring Boot', 'https://spring.io/images/spring-logo-9146a4d3298760c2e7e49595184e1975.svg');
