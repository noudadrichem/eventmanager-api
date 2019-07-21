create table event
(
    id          bigint not null
        constraint event_pkey
            primary key,
    description varchar(255),
    end_date    timestamp,
    location    varchar(255),
    name        varchar(255),
    start_date  timestamp
);


create sequence event_seq;