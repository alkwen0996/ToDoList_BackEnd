drop table todo IF EXISTS;
create table todo (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    todo_Subject VARCHAR NOT NULL,
    completed BOOLEAN NOT NULl DEFAULT false
);