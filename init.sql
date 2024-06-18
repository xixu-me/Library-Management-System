create database bookmanagesys;


use bookmanagesys;


create table
  manager(
    manager_user VARCHAR(255) primary key,
    manager_password VARCHAR(255)
  );


insert into
  manager
values
  ('admin', 'admin');


create table
  customer(
    customer_user VARCHAR(255) primary key,
    customer_password VARCHAR(255)
  );


create table
  naturebook(
    number VARCHAR(255) primary key,
    classnumber VARCHAR(255),
    name VARCHAR(255),
    classname VARCHAR(255),
    price VARCHAR(255),
    state VARCHAR(255),
    total VARCHAR(255)
  );


insert into
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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
  naturebook
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


create table
  sciencebook(
    number VARCHAR(255) primary key,
    classnumber VARCHAR(255),
    name VARCHAR(255),
    classname VARCHAR(255),
    price VARCHAR(255),
    state VARCHAR(255),
    total VARCHAR(255)
  );