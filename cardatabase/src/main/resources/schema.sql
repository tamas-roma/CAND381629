    drop table if exists cars cascade;
    drop table if exists cars_of_people cascade;
    drop table if exists email_templates cascade; 
    drop table if exists person_data cascade; 
    
    create table cars (
        calculated_value numeric(38,2),
        car_id numeric(38,2) not null,
        driven_distance numeric(38,2),
        is_sent boolean not null,
        year_of_manufacture integer,
        brand varchar(255),
        plate_number varchar(255),
        type varchar(255),
        primary key (car_id)
    );

    create table cars_of_people (
        car_id numeric(38,2) not null,
        person_id numeric(38,2) not null,
        primary key (car_id, person_id)
    );
 
    create table email_templates (
        language_id numeric(38,2) not null,
         text clob,
        primary key (language_id)
    );
 
    create table person_data (
        data_of_birht date,
        language_id numeric(38,2),
        person_id numeric(38,2) not null,
        country varchar(255),
        name varchar(255),
        primary key (person_id)
    );