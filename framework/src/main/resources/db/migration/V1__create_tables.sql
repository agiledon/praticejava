-- mvn flyway:migrate --

--CREATE DATABASE IF NOT EXISTS training --

USE training;

CREATE TABLE IF NOT EXISTS t_administrator
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_teacher
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  organization VARCHAR(50) NOT NULL,
  title VARCHAR(50) NOT NULL,
  profile TEXT,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_course
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  teacherId INT NOT NULL REFERENCES t_teacher(id),
  name VARCHAR(50) NOT NULL UNIQUE,
  description VARCHAR(255) NOT NULL,
  earning VARCHAR(255),
  trainee VARCHAR(200),
  outline TEXT,
  price DECIMAL(5,2) NOT NULL,
  duration INT NOT NULL,
  createdBy INT NOT NULL REFERENCES t_administrator(id),
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_category
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  courseId INT NOT NULL REFERENCES t_course(id),
  name VARCHAR(50) NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_calendar
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  courseId INT NOT NULL REFERENCES t_course(id),
  place VARCHAR(50) NOT NULL,
  startDate DATETIME NOT NULL,
  endDate DATETIME NOT NULL,
  status ENUM('available', 'overdue') NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_student
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  mobilePhone VARCHAR(20) NOT NULL,
  registeredTime DATETIME NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_wish_list
(
  courseId INT NOT NULL REFERENCES t_course(id),
  studentId INT NOT NULL REFERENCES t_student(id),
  PRIMARY KEY(courseId, studentId)
);

CREATE TABLE IF NOT EXISTS t_training
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  studentId INT NOT NULL REFERENCES t_student(id),
  courseId INT NOT NULL REFERENCES t_course(id),
  calendarId INT NOT NULL REFERENCES t_calendar(id),
  price DECIMAL(5,2) NOT NULL,
  subscribedTime DATETIME NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_order
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  studentId INT NOT NULL REFERENCES t_student(id),
  status ENUM('new', 'paid', 'confirmed', 'completed') NOT NULL,
  placedTime DATETIME NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_order_item
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  orderId INT NOT NULL REFERENCES t_order(id),
  trainingId INT NOT NULL REFERENCES t_training(id),
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS t_payment
(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  studentId INT NOT NULL REFERENCES t_student(id),
  orderId INT NOT NULL REFERENCES t_order(id),
  amount DECIMAL NOT NULL,
  paymentStyle VARCHAR(20) NOT NULL,
  status ENUM('success', 'failure') NOT NULL,
  transactionTime TIMESTAMP NOT NULL,
  createdAt DATETIME NOT NULL,
  updatedAt DATETIME NOT NULL
);

