CREATE TABLE measurement (
  id INT NOT NULL PRIMARY KEY,
  householdid INT,
  creationtimestamp TIMESTAMP NOT NULL,
  consumer VARCHAR(999) NOT NULL,
  unit VARCHAR(999) NOT NULL,
  value NUMERIC NOT NULL
);

CREATE SEQUENCE seq_measurement START 1;