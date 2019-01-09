/*INSERT INTO PERSON (
  PERSON_ID,
  PERSON_FIRST_NAME,
  PERSON_MIDDLE_NAME,
  PERSON_LAST_NAME
  ) values(1,'Elson','Renato','de Franca');

INSERT INTO DOCUMENT_IDENTIFICATION (
   DOC_ID,
   DOC_SERIAL_NUMBER,
   DOC_ISSUE_DATE,
   DOC_EXPIRATION_DATE,
   DOC_ISSUER_COUNTRY,
   PERSON_ID
   )
VALUES(1000,'GR754','2017-09-23','2027-09-22','Brazil',1);


INSERT INTO PHONE(
  PHONE_ID,
  PHONE_NUMBER,
  PERSON_ID
)
VALUES(1000,'55 41 3547-8760',1);


INSERT INTO PHONE_DETAILS(
  PHONE_DETAILS_ID,
  MANUFACTURER,
  MODEL,
  COLOR,
  PHONE_ID
)
VALUES(1,'SAMSUNG','S7','BLACK',1000);


INSERT INTO ADDRESSES (
    ADDR_ID,
    ADDR_NUMBER,
    ADDR_POSTAL_CODE,
    ADDR_STREET,
    PERSON_ID
)
VALUES(1,'139','8767543','Joao Marchesini',1);

INSERT INTO CUSTOMERS(
   CUST_ID,
   PERSON_ID,
)
VALUES(1,1);

INSERT INTO ORDERS(
    ORDER_ID,
    CUST_ID,
    TOTAL_PRICE,
    ORDER_DESC,
    ORDER_DATE,
    LAST_UPDATED_TIME
)
VALUES(1,1,324.00,'Order-1','2018-08-12','2018-08-12');


INSERT INTO PRODUCTS (
    PROD_ID,
    PROD_NAME,
    PROD_DESC,
    REGULAR_PRICE,
    serialNumber
)
VALUES(1,'Arroz Tio Joao','Parboilizado',8.80,'3413-ZX');

INSERT INTO ORDER_ITEMS(
    ORDER_ITEM_NUMBER,
    ORDER_ID,
    PROD_ID,
    QUANTITY
)
VALUES(100,1,1,20);
*/