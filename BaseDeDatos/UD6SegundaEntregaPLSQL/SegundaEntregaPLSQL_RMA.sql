--Crea un trigger que cuando se inserte un vendedor se inserte un registro en una tabla adicional que contendrá el numero del vendedor y una contraseña asociada al mismo. 
--Para cálcular esta contraseña debes crear una función o procedimiento adicional que reciba el numero de caracteres que debe tener la contraseña y la genere de forma automática.
--Esta contraseña debe contener letras mayúsculas, minúsculas, números y signos de puntuación.
--Puedes crear cualquier tabla adicional que consideres necesaria, además de las funciones proporcionadas por el SGBD.
--Ten en cuenta la gestión de errores cuando realices la implementación de tu trigger

--creo la función que genera contraseña
create or replace function generar_contrasenya (v_num_caracteres number) return varchar2
    is
     v_contrasenya varchar2(100);
     v_caracteres VARCHAR2(100) := 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=';
     v_contador number:=0;
	begin

	while v_num_caracteres>v_contador  loop
        v_contrasenya := v_contrasenya || substr(v_caracteres, dbms_random.value(1, length(v_caracteres)),1);
        v_contador := v_contador+1;
    end loop;   
	return v_contrasenya;
end generar_contrasenya;

declare 
    contrasena varchar2(100) := generar_contrasenya(100);
begin
    DBMS_OUTPUT.PUT_LINE(contrasena);
end;

--creacion del trigger
create or replace trigger relacion_contrasenya_vendedor after insert on vendedor for each row
    declare
    	v_numvend vendedor.numvend%type;
		v_contrasena varchar2(100);
    begin 
    	v_numvend := :new.numvend; 
      	v_contrasena := generar_contrasenya(3); 
	 	DBMS_OUTPUT.PUT_LINE('Creado vendedor con numero '||v_numvend|| ' y contraseña : ['||v_contrasena||']');
end;
--pruebas
INSERT INTO vendedor VALUES(33,'nombre de prueba','empresa de prueba','999333444','Avda. Valencia 3205','ALICANTE','ALICANTE');
INSERT INTO vendedor VALUES(35,'nombre de prueba','empresa de prueba','999333444','Avda. Valencia 3205','ALICANTE','ALICANTE');

select * from vendedor;




