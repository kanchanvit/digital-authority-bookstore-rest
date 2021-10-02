DROP TABLE IF EXISTS BOOK;

CREATE TABLE BOOK (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  description VARCHAR(250) ,
  author VARCHAR(150) NOT NULL,
  classification VARCHAR(30) NOT NULL,
  price DECIMAL,
  ISBN VARCHAR(20) DEFAULT NULL
);

INSERT INTO BOOK (name, description, author, classification,price,ISBN) VALUES
  ('Client Server Computing', 'Kanchn', 'Sharad Kumar Verma','COMIC',888.33,' 978-93-8067-432-2'),
  ('Client Server Computing', 'Kanchna', 'Ramesh','FICTION',988.33,' 978-93-8067-432-2');