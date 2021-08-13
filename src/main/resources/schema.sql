create table todo (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    todo_subject VARCHAR NOT NULL,
    completed BOOLEAN NOT NULl DEFAULT false
);