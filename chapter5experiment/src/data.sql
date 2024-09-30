create table order_record
(
    id           int auto_increment
        primary key,
    username     varchar(20) null,
    product_name varchar(30) null,
    num          int         null
);

create table product
(
    id           int auto_increment
        primary key,
    product_name varchar(30) null,
    num          int         null
);

INSERT INTO db_spring.product (product_name,num) VALUES
                                                     ('电视机',9),
                                                     ('冰箱',20),
                                                     ('洗衣机',30);
