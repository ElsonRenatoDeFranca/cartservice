DROP TABLE IF EXISTS PUBLIC.CART;

CREATE SEQUENCE IF NOT EXISTS PUBLIC.CART_SEQ;

CREATE TABLE PUBLIC.CART(
   CART_ID BIGINT DEFAULT CART_SEQ.nextval,
   CART_DESCRIPTION VARCHAR(50) NOT NULL,
   PRIMARY KEY (PERSON_ID)
);