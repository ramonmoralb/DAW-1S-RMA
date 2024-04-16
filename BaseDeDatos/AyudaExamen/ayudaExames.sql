
-- %type otorga a la variable declarada el mismo tipo de dato de la columna a la que hace referencia en una tabla 
-- ejemplo %type ->  v_numvend vendedor.numvend%type;



-- ***Escribir por consola, concatenación, bucle while y subtring.

DECLARE 
	saludo VARCHAR2(10) := 'Hola';
	nombre VARCHAR2(10) := 'Ramón';
	tres_letras_ramdon VARCHAR2(10) := '';
	contador number(5) := 0;
BEGIN
 	WHILE contador < 3 LOOP
        tres_letras_ramdon := tres_letras_ramdon || SUBSTR(nombre, DBMS_RANDOM.VALUE(1, LENGTH(nombre)), 1); -- el ramndom devuelve un número aleatorio entre 1 y en este caso la longitud del nombre
        contador := contador + 1;
    END LOOP;
DBMS_OUTPUT.PUT_LINE(saludo||' mi nombre es: '||nombre);
DBMS_OUTPUT.PUT_LINE('Las tres primeras letras de mi nombre usando substring son: '|| SUBSTR(nombre, 1, 3));
DBMS_OUTPUT.PUT_LINE(tres_letras_ramdon);
END;

--substring
DECLARE 
	vocales VARCHAR2(8) :='AEIOU';
BEGIN
	DBMS_OUTPUT.PUT_LINE('Las tres primeras letras de mi nombre usando substring son: '|| SUBSTR(vocales, 3,1 )); --Imprime la "I", 3->posición de inicio, 1-> posiciones que avanza  
END;

-- *** excepciones dividir entre 0
DECLARE
    dividendo NUMBER := 5;
    divisor NUMBER := 0;
    resultado NUMBER;
BEGIN 
    resultado := dividendo / divisor;  
    -- Imprimir el resultado con un decimal en caso de no entrar a la excepcion
    DBMS_OUTPUT.PUT_LINE('Resultado: ' || TO_CHAR(resultado, '9.9')); 
EXCEPTION 
    WHEN ZERO_DIVIDE THEN
        DBMS_OUTPUT.PUT_LINE('No se puede dividir entre 0');
END;

--*** condicional if
DECLARE
	nombre_banco VARCHAR2(10) := 'BBVA';
	num_cuenta VARCHAR2(20) := '20604785226-7';
	saldo number(9) := 500;
	imp_a_ret number(9) := 600;
    
BEGIN 
    IF saldo<imP_a_ret THEN
    	DBMS_OUTPUT.PUT_LINE('La cuenta nº: ['||num_cuenta||'] del banco '||nombre_banco||'  no dispone de saldo suficiente.' );
		DBMS_OUTPUT.PUT_LINE('Saldo disponible: '||saldo||'€');
	ELSE 
        saldo := saldo-imp_a_ret;
		DBMS_OUTPUT.PUT_LINE('Operación realizada.  Saldo restante: '||saldo||'€');
	END IF;    
END;