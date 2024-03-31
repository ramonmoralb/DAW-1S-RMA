--Segunda entrega 
--Crea un trigger que cuando se inserte un vendedor se inserte un registro en una tabla adicional que contendrá el numero del vendedor y una contraseña asociada al mismo. 
--Para cálcular esta contraseña debes crear una función o procedimiento adicional que reciba el numero de caracteres que debe tener la contraseña y la genere de forma automática.
--Esta contraseña debe contener letras mayúsculas, minúsculas, números y signos de puntuación.
--Puedes crear cualquier tabla adicional que consideres necesaria, además de las funciones proporcionadas por el SGBD.
--Ten en cuenta la gestión de errores cuando realices la implementación de tu trigger

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

--prueba de generar contraseña
declare 
    contrasena varchar2(100) := generar_contrasenya(100);
begin
    DBMS_OUTPUT.PUT_LINE(contrasena);
end;

