create table user
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    email      varchar(255) null,
    password   varchar(255) null,
    user_type  varchar(255) null,
    username   varchar(255) null
);

