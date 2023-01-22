/*
CREATE TABLE users (
  id INT AUTO_INCREMENT NOT NULL,
   email VARCHAR(255),
   password VARCHAR(255),
   first_name VARCHAR(255),
   last_name VARCHAR(255),
   role VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (id)
);
*/

INSERT INTO users (id, email, password, first_name, last_name, role) VALUES
(

    1,
    'testuser@gmail.com',
    'Password1*',
    'Testerson',
    'Usertown',
    'Manager'
);