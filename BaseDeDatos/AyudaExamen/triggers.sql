--Ejecución de un trigger desencadenado por varias operaciones

create or replace trigger  mostra_accion_linped before insert or update or delete on linped 
begin 
if updating then
dbms_output.put_line('Modificacion en linped');
elsif deleting then
dbms_output.put_line('Borrado en linped');
elsif inserting then
dbms_output.put_line('Insercion en linped');
end if;
end;

select * from linped;
insert into linped values(1,17,'O-0002-PP',555,2000, TO_DATE('25/08/95','DD/MM/YY'),100);


--Crea un trigger que imprima impida la ejecución de sentencias de borrado en la tabla preciosum 
--ejecutadas durante el primer día de cada mes.
select * from preciosum;

create or replace trigger primero_mes_no_delete before delete on preciosum
declare
	dia_actual number;
begin
	dia_actual := EXTRACT(DAY FROM(SYSDATE));    
if dia_actual=1 then
raise_application_error(-20001, 'No puede hacer borrados el dia 1');  -- genera una excepcion
end if;
end;

delete from preciosum where numvend=3;