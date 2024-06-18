create database bookmanagesys;


use bookmanagesys;


CREATE TABLE
  Manager(
    manager_user VARCHAR(255) primary key,
    manager_password VARCHAR(255)
  );


insert into
  Manager
values
  ('admin', 'admin');


CREATE TABLE
  Customer(
    customer_user VARCHAR(255) primary key,
    customer_password VARCHAR(255)
  );


CREATE TABLE
  NatureBook(
    number VARCHAR(255) primary key,
    classnumber VARCHAR(255),
    name VARCHAR(255),
    classname VARCHAR(255),
    price VARCHAR(255),
    state VARCHAR(255),
    total VARCHAR(255)
  );


insert into
  NatureBook
values
  (
    'N01',
    '1',
    'Nature and Science',
    'Nature',
    '25',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N02',
    '1',
    'My Nature Science ',
    'Nature',
    '23',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N03',
    '1',
    'Wonderful Nature  ',
    'Nature',
    '21',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N04',
    '1',
    'Amazing Nature    ',
    'Nature',
    '22',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N05',
    '1',
    'Good Science Nature',
    'Nature',
    '25',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N06',
    '1',
    'People and Nature ',
    'Nature',
    '26',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N07',
    '1',
    'Hello Nature      ',
    'Nature',
    '14',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N08',
    '1',
    'Goodbye Nature    ',
    'Nature',
    '26',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N09',
    '1',
    'Great Nature      ',
    'Nature',
    '20',
    'in',
    '1'
  );


insert into
  NatureBook
values
  (
    'N10',
    '1',
    'Buzz Nature       ',
    'Nature',
    '32',
    'in',
    '1'
  );


alter table
  NatureBook
add
  column current VARCHAR(255);


alter table
  NatureBook
add
  column dateon VARCHAR(255);


alter table
  NatureBook
add
  column dateoff VARCHAR(255);


CREATE TABLE
  ScienceBook(
    number VARCHAR(255) primary key,
    classnumber VARCHAR(255),
    name VARCHAR(255),
    classname VARCHAR(255),
    price VARCHAR(255),
    state VARCHAR(255),
    total VARCHAR(255)
  );


alter table
  ScienceBook
add
  column current VARCHAR(255);


alter table
  ScienceBook
add
  column dateon VARCHAR(255);


alter table
  ScienceBook
add
  column dateoff VARCHAR(255);