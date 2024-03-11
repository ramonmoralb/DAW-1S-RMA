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

/*Actividad 4
Crea un programa que procesa una transacción bancaria. Antes de permitir retirar 500€ de la cuenta 3, 
se asegura de que la cuenta tenga fondos suficientes para cubrir la retirada.
Si los fondos están disponibles, el programa debita la cuenta. De lo contrario,
el programa inserta un registro en una tabla de auditoría.
*/

DECLARE 
    nombre_banco VARCHAR2(50);
    num_cuenta number(20);
    saldo number(9);
    importe_retirar number(6);

BEGIN 
    nombre_banco :='BBVA';
    num_cuenta := 1122334455;
    saldo := 100;
    importe_retirar:= 500;
    
    IF saldo<importe_retirar THEN 
        DBMS_OUTPUT.PUT_LINE('El importe ha retirar seleccionado de la cuenta nº: ['||num_cuenta||' del banco ' ||nombre_banco|| '] es ['||importe_retirar||'] y es menor que el saldo disponible el cual es ['||saldo||']'); 
    ELSE 
    saldo := saldo-importe_retirar;
        DBMS_OUTPUT.PUT_LINE('El importe ha retirar seleccionado es ['||importe_retirar||'] ha sido retirado correctamente.'); 
        DBMS_OUTPUT.PUT_LINE('Su saldo de la cuenta nº: ['||num_cuenta||' del banco ' ||nombre_banco|| '] es de : '||saldo); 
    END IF;

END;


/* Actividad 5
A partir de una base y exponente, mediante la acumulación de productos,
calcula la potencia utilizando la instrucción loop.
*/

DECLARE 
        base NUMBER(5);
        exponente NUMBER(2);
        exponente_print NUMBER(2);
        resultado_potencia NUMBER(9);

BEGIN
    base := 3;
    exponente :=2;
    exponente_print := exponente;
    resultado_potencia := base;
    
     WHILE  exponente-1>0 LOOP  
     resultado_potencia :=resultado_potencia * base;
     exponente:= exponente-1;
     END LOOP;
    
    dbms_output.put_line('El resultado de ['||base||'] elevado a ['||exponente_print||'] es igual a ['||resultado_potencia||']');
    
END;
	