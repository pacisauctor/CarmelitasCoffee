use carmelitas_coffee;
insert into carmelitas_coffee.empleado (cedula_identidad, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, sexo, edad, direccion, telefono, correo, estado_civil, grado_escolaridad)
	values("001-061199-1009L", "Axel", "Eleazar", "Garcia", "Darce", "H", 20, "Distrito 6 de Managua, pista Buenos Aires","81380937" ,"agarciadarce@gmail.com", "soltero", "Lic.");
insert into carmelitas_coffee.usuario (nombre, id_empleado, clave_acceso, rol)
	values ("admin",1,"admin","maestro");
    
    insert into carmelitas_coffee.cliente ( numero_ruc, nombres, apellidos, telefono, correo, direccion, id_persona_contacto) 
								values('J0110000018511','margarita','gracia',18002020,'magracia@gmail.com','hola', 2);
    
select * from persona_contacto

/*
	opciones con la tabla empleado:
		agregar nuevo empleado (y nuevo contrato por supuesto)
        cancelar contrato
        renovar contrato

*/

call empleado_nuevoContrato();