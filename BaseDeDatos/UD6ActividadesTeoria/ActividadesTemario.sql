/*
# Actividad 2

Escribe un programa que almacene en variables tu nombre, primer apellido, segundo apellido, 
email, año de nacimiento y teléfono. Luego muéstralos por pantalla  en una línea el nombre 
completo y crea una cuenta para tus datos que tendrá el formato primerapellido_segundoapellido@iespacomolla.es.
 Adicionalmente, crea la contraseña de este usuario con el nombre todo el mayúsculas seguido de una barra baja
 con los dos últimos digitos de año de nacimiento.
*/
DECLARE 
 	nombre VARCHAR2(25);
 	apellido1 VARCHAR2(25);
	apellido2 VARCHAR2(25);	
	anyo_nac NUMBER(4);
	telefono NUMBER(9);
	fin_email VARCHAR2(25);
	dosDigPass NUMBER(2);
		
BEGIN
	nombre := 'Ramon';
	apellido1 := 'Moreno';
	apellido2 := 'Albert';
	anyo_nac := 1986;
	telefono := 555999777;
	fin_email := '@iespacomolla.es';
	dosDigPass := MOD(anyo_nac,100);                --módulo entre 100

DBMS_OUTPUT.PUT_LINE(nombre||' '||apellido1||' '||apellido2);
DBMS_OUTPUT.PUT_LINE('E_mail : '||LOWER(apellido1)||LOWER(apellido2)||fin_email);
DBMS_OUTPUT.PUT_LINE('Contraseña : '||UPPER(nombre)||'_'||dosDigPass);

END;


--Actividad 3
/*Crea un bloque que realice la división de dos variables y muestre una excepción ZERO_DIVIDE si el divisor es cero*/
SET SERVEROUTPUT on;

DECLARE
    divisor NUMBER;
    dividendo NUMBER;
    resultado NUMBER;

BEGIN
    
    divisor := 0;
    dividendo := 1;
    resultado := dividendo/divisor;
    
    DBMS_OUTPUT.PUT_LINE(resultado);
    
    EXCEPTION
    WHEN ZERO_DIVIDE THEN 
        DBMS_OUTPUT.PUT_LINE('El divisor no puede ser 0');
END;
	