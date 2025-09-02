CREATE DATABASE IF NOT EXISTS qcrecetas;
USE qcrecetas;

DROP TABLE IF EXISTS receta_etiquetas;
DROP TABLE IF EXISTS receta_ingredientes;
DROP TABLE IF EXISTS receta;

CREATE TABLE receta (
    id_receta BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    preparacion VARCHAR(255),
    tiempo INT,
    likes INT
);

CREATE TABLE receta_ingredientes (
    id_receta BIGINT NOT NULL,
    ingrediente VARCHAR(255),
    FOREIGN KEY (id_receta) REFERENCES receta(id_receta)
);

CREATE TABLE receta_etiquetas (
    id_receta BIGINT NOT NULL,
    etiqueta VARCHAR(50),
    FOREIGN KEY (id_receta) REFERENCES receta(id_receta)
);
