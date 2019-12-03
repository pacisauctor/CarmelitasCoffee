use carmelitas_coffee;
insert into carmelitas_coffee.empleado (cedula_identidad, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, edad, direccion, telefono, correo, estado_civil, grado_escolaridad)
	values("001-061199-1009L", "Axel", "Eleazar", "Garcia", "Darce", "H", 20, "Distrito 6 de Managua, pista Buenos Aires","81380937" ,"agarciadarce@gmail.com", "soltero", "bachillerato");
insert into carmelitas_coffee.usuario (nombre, id_empleado, clave_acceso, rol, correo)
	values ("admin",1,"admin","maestro","agarciadarce@gmail.com");
    
select * from empleado