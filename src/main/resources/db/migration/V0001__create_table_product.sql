create table Product
(
    id             bigint primary key generated always as identity,
    product_name   varchar(50)    not null,
    description    varchar(300)   not null,
    price          real           not null,
    quantity       integer        not null
);