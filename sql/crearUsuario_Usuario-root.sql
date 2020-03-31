CREATE USER 'coffee'@'localhost' IDENTIFIED BY 'CarmelitasCoffee100!';
GRANT SELECT ON performance_schema.* TO 'coffee'@'localhost';
CREATE SCHEMA carmelitas_coffee;
GRANT ALL PRIVILEGES ON carmelitas_coffee.* TO 'coffee'@'localhost';
FLUSH privileges;

SELECT @@global.time_zone, @@session.time_zone;