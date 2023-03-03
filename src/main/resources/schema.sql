create table CUSTOMERS(
                          id serial,
                          name varchar(255) not null,
                          surname varchar(255),
                          age smallint,
                          phone_number varchar(30),
                          primary key (id)
);

create table ORDERS(
                       id serial,
                       date timestamp not null,
                       customer_id int not null,
                       product_name varchar(255) not null,
                       amount integer not null,
                       primary key (id),
                       foreign key (customer_id) references customers (id)
);