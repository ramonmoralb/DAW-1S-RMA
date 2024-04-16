--Crea un trigger que cuando se inserte un vendedor se inserte un registro en una tabla adicional que contendrá el numero del vendedor y una contraseña asociada al mismo. 
--Para cálcular esta contraseña debes crear una función o procedimiento adicional que reciba el numero de caracteres que debe tener la contraseña y la genere de forma automática.
--Esta contraseña debe contener letras mayúsculas, minúsculas, números y signos de puntuación.
--Puedes crear cualquier tabla adicional que consideres necesaria, además de las funciones proporcionadas por el SGBD.
--Ten en cuenta la gestión de errores cuando realices la implementación de tu trigger.

--Creación de procedimiento que genera la cotraseña.
CREATE OR REPLACE FUNCTION generar_contrasenya (v_num_caracteres number) RETURN varchar2
    IS
     v_contrasenya varchar2(100);
     v_caracteres VARCHAR2(100) := 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=';
     v_contador number:=0;
	BEGIN
	WHILE v_num_caracteres>v_contador  LOOP
        v_contrasenya := v_contrasenya || substr(v_caracteres, dbms_random.value(1, length(v_caracteres)),1);
        v_contador := v_contador+1;
    END LOOP;   
	RETURN v_contrasenya;
END generar_contrasenya;

-- creo la tabla que almacena la contraseña y el número del nuevo vendedor.
CREATE TABLE vendedor_contrasenya (
    numvend NUMBER(22) PRIMARY KEY,
    contrasenya VARCHAR2(100) NOT NULL,
    FOREIGN KEY (numvend) REFERENCES vendedor(numvend)
);

--creo el trigger que se ejecutará despued de la inserción de un nuevo vendedor.
CREATE OR REPLACE TRIGGER relacion_contrasenya_vendedor AFTER INSERT ON vendedor FOR EACH ROW
    DECLARE
    	v_numvend vendedor.numvend%type;                  -- %type recoge el mismo tipo de dato que la columna de la tabla a la que hace referencia.
	v_contrasena vendedor_contrasenya.contrasenya%type;
    BEGIN 
    	v_numvend := :new.numvend; 
      	v_contrasena := generar_contrasenya(6); 
		INSERT INTO vendedor_contrasenya values(v_numvend,v_contrasena);          
	 	DBMS_OUTPUT.PUT_LINE('Creada contraseña para el nuevo vendedor.');
		DBMS_OUTPUT.PUT_LINE('Número de vendedor: [ '||v_numvend|| ' ]');
		DBMS_OUTPUT.PUT_LINE('Contraseña : [ '||v_contrasena||' ]');
    EXCEPTION 
        WHEN DUP_VAL_ON_INDEX THEN  --inserta el vendedor, pero no falla como ya tiene una contraseña asignada
        DBMS_OUTPUT.PUT_LINE('Error: El número de vendedor ya tiene una contraseña asignada.'); 
		 WHEN OTHERS THEN
    	DBMS_OUTPUT.PUT_LINE('Error: Se produjo un error al insertar en la tabla vendedor_contrasenya.');
END;

insert into vendedor values(33,'pepecont','comerpass','+34446546','calle calle', 'ALICANTE', 'ALICANTE'); 
delete from vendedor where NUMVEND=33;
delete from vendedor_contrasenya where NUMVEND=33;
select * from vendedor;
select * from vendedor_contrasenya;
select v.numvend, v.NOMVEND, vc.CONTRASENYA from vendedor v
join vendedor_contrasenya vc on v.numvend=vc.numvend;
