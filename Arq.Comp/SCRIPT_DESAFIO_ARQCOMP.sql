CREATE DATABASE desafio_arq_comp;
USE desafio_arq_comp;

CREATE TABLE sensores(
	id_historico_sensor INT PRIMARY KEY AUTO_INCREMENT,
    sensor_lm35 FLOAT,
    sensor_mq2 FLOAT,
    sensor_hcsr04 FLOAT,
    sensor_dht11 FLOAT,
    sensor_ldr FLOAT,
    sensor_solo FLOAT
);