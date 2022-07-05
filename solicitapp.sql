CREATE DATABASE solicitapp;

USE solicitapp;

CREATE TABLE usuario(
idUsua int PRIMARY KEY,
nombUsua varchar(255),
correoUsua varchar(255),
contraUsua varchar(255),
tipoUsua enum('Profesor', 'Coordinador')
);

CREATE TABLE profesor(
idProf int PRIMARY KEY,
idCubi int,
idUsua int,
FOREIGN KEY(idCubi) REFERENCES cubiculo(idCubi),
FOREIGN KEY(idUsua) REFERENCES usuario(idUsua)
);

CREATE TABLE solicitud(
idSoli int PRIMARY KEY,
idProf int,
matAlumnSoli varchar(255),
FOREIGN KEY(idProf) REFERENCES profesor(idProf)
);

CREATE TABLE cubiculo(
idCubi int PRIMARY KEY,
codCubi varchar(50),
dispCubi enum('Si', 'No')
);

CREATE TABLE turno(
idTurn int PRIMARY KEY,
idSoli int,
estaTurn enum('Pendiente','Aceptada','Rechazada'),
FOREIGN KEY(idSoli) REFERENCES solicitud(idSoli)
);