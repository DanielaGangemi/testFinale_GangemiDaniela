DROP DATABASE IF EXISTS test_finale_gangemi_daniela;
CREATE DATABASE test_finale_gangemi_daniela;

USE test_finale_gangemi_daniela;

DROP TABLE IF EXISTS hourly_units;
CREATE TABLE hourly_units (
	
    id_hourly_units INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `time` VARCHAR(255) DEFAULT NULL,
    temperature_2m VARCHAR(255) DEFAULT NULL,
    relative_humidity_2m VARCHAR(255) DEFAULT NULL,
    precipitation_probability VARCHAR(255) DEFAULT NULL

);

DROP TABLE IF EXISTS weather_forecast;
CREATE TABLE weather_forecast (
	
    id_weather_forecast INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    latitude DOUBLE DEFAULT NULL,
    longitude DOUBLE DEFAULT NULL,
    generationtime_ms DOUBLE DEFAULT NULL,
    utc_offset_seconds DOUBLE DEFAULT NULL,
    timezone VARCHAR(255) DEFAULT NULL,
    timezone_abbreviation VARCHAR(255) DEFAULT NULL,
    elevation INT DEFAULT NULL,
    id_hourly_units INT DEFAULT NULL,
    FOREIGN KEY (`id_hourly_units`) REFERENCES `hourly_units` (`id_hourly_units`)

);

DROP TABLE IF EXISTS hourly;
CREATE TABLE hourly (
	
    id_hourly INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `time` DATE DEFAULT NULL,
    temperature_2m DOUBLE DEFAULT NULL,
    relative_humidity_2m INT DEFAULT NULL,
    precipitation_probability INT DEFAULT NULL,
    id_weather_forecast INT DEFAULT NULL,
	FOREIGN KEY (`id_weather_forecast`) REFERENCES `weather_forecast` (`id_weather_forecast`)

);

DROP TABLE IF EXISTS city;
CREATE TABLE city (
	
    id_city INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    latitude DOUBLE DEFAULT NULL,
    longitude DOUBLE DEFAULT NULL,
    `name` VARCHAR(255) DEFAULT NULL,
    id_weather_forecast INT DEFAULT NULL,
	FOREIGN KEY (`id_weather_forecast`) REFERENCES `weather_forecast` (`id_weather_forecast`)

);

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(

	id_user INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255) DEFAULT NULL,
    last_name VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(255) DEFAULT NULL
    
);

DROP TABLE IF EXISTS user_city;
CREATE TABLE user_city (

	id_user INT NOT NULL,
    id_city INT NOT NULL,
    PRIMARY KEY (id_user, id_city),
    FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
    FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`)

);

INSERT INTO city(latitude, longitude, name) VALUES (38.1939, 15.5526, "Messina");
INSERT INTO city(latitude, longitude, name) VALUES (37.4922, 15.0704, "Catania");
INSERT INTO city(latitude, longitude, name) VALUES (38.132, 13.3356, "Palermo");
