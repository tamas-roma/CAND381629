# CAND381629 for REQ10612

Solution

## Installing

create the 'test.mv.db' to the correct place for h2 database

mvn clean install

## Database

Used **JPA**, for the demo the program contains **h2 database**

The source files, contains the schema (src\main\resources\schema.sql ) , and some sample data (src\main\resources\data.sql) for testing and reviewing.

## Usage

via rest

Example request for the first task: 
>http://localhost:8080/send-email-to/3

Example request for the second task:

> URL: http://localhost:8080/search-cars
> Header: Content-Type: application/json
> Body:
> {
    "personId": 1
}

or
> {
    "carId": 1
}


