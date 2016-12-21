CREATE TABLE measurement (
  id INT NOT NULL PRIMARY KEY,
  householdid INT,
  consumer VARCHAR(999) NOT NULL,
  unit VARCHAR(999) NOT NULL,
  value NUMERIC NOT NULL,
  measuretimestamp TIMESTAMP NOT NULL,
  userid INT
);

CREATE SEQUENCE seq_measurement START 1;