
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
    IF saldo<imp_a_ret THEN
    	DBMS_OUTPUT.PUT_LINE('La cuenta nº: ['||num_cuenta||'] del banco '||nombre_banco||'  no dispone de saldo suficiente.' );
		DBMS_OUTPUT.PUT_LINE('Saldo disponible: '||saldo||'€');
	ELSE 
        saldo := saldo-imp_a_ret;
		DBMS_OUTPUT.PUT_LINE('Operación realizada.  Saldo restante: '||saldo||'€');
	END IF;    
END;

--*** imprimir 10 num usando while
DECLARE 
	total_numeros number(2) := 10;
	numero_inicial number(2):= 1;
BEGIN
	WHILE numero_inicial <= total_numeros LOOP
	DBMS_OUTPUT.PUT_LINE(numero_inicial);
	numero_inicial := numero_inicial+1;
	END LOOP;
END;

-- imprimir 10 rayas '_' usando for
DECLARE 
	raya varchar2(2) :=  '_';
	total_rayas number(2) := 10;
BEGIN 
	FOR i IN 1..total_rayas LOOP  --1. es el valor icicial de 'i', .total_rayas numero que se usa para salir del bucle for 
    	DBMS_OUTPUT.PUT_LINE(raya);
	END LOOP;
END;

--*** funciones
--funcion que suma dos núemros que recibe por parametro.

CREATE OR REPLACE FUNCTION sumar(num1 number, num2 number) RETURN number -- no poner aquí longitudes
IS 
	resultado number;
BEGIN 
	resultado := num1 + num2;
  	RETURN resultado;
END sumar;

-- funcion que saluda a persona pasa por parametro.
CREATE OR REPLACE FUNCTION saludar(nombre VARCHAR2) return VARCHAR2  -- no poner aqui longitudes
IS
    saludo VARCHAR2(100) := 'Hola mi nombre es : ';
begin
    saludo := saludo||nombre;
	return saludo;
end saludar;
begin
dbms_output.put_line(saludar('Ramón'));
end;


-- *** procedimientos
-- procedimiento para borrar vendedores por numero de vendedor
--(Tiene incluido para borrar de la tabla contraseña al ser clave foranea de otra tabla es necesario, si no fallaraia)--
CREATE OR REPLACE PROCEDURE borrar_vendedor(v_numvend vendedor.numvend%TYPE) is
    v_contador_vendedor number;
begin
    select count(*) into v_contador_vendedor from vendedor where numvend = v_numvend; --añade 1 al contador si encuntra vendedores,
    if v_contador_vendedor > 0 then                                                   --uso el contador para el condicional 
 		delete from vendedor_contrasenya where numvend = v_numvend;                   --si existe conttraseña al ser clave foranea, se debe eliminar primero, si no fallar
		delete from vendedor where numvend = v_numvend;
        DBMS_OUTPUT.PUT_LINE('Vendedor borrado correctamente.');
    else
        DBMS_OUTPUT.PUT_LINE('No existe un vendedor con ese número de vendedor');
    end if;
end borrar_vendedor;
--pruebas
insert into vendedor values(33,'pepecont','comerpass','+34446546','calle calle', 'ALICANTE', 'ALICANTE'); 
begin 
borrar_vendedor(33);
end;
