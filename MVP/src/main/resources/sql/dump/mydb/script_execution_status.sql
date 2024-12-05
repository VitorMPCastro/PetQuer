create table script_execution_status
(
    id          int auto_increment
        primary key,
    script_name varchar(255)                        not null,
    executed_at timestamp default CURRENT_TIMESTAMP null
);

