drop table if exists item;
create table item
(
    id       integer auto_increment primary key,
    name     varchar(100) null,
    price    decimal(10, 2) null,
    quantity integer null
);