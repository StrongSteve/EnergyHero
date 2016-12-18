CREATE TABLE household (
  id INT NOT NULL PRIMARY KEY,
  name VARCHAR(999) NOT NULL,
  size INT NOT NULL,
  number_inhabitants INT NOT NULL,
  energyuserid INT
);

CREATE SEQUENCE seq_household START 1;