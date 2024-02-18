--1. Seleccciona todos los campos de inventario que hayan sido inventariadas en octubre del 92
/*Para buscar fechas TO_DATE('01-10-92','DD/MM/YY')!!cuidado con el formato*/
--SELECT * FROM INVENTARIO; /*veo la tabla completa para comprobar*/

SELECT * FROM INVENTARIO WHERE FECHARECUENTO>=TO_DATE('01-10-92','DD/MM/YY') AND FECHARECUENTO<=TO_DATE('31-10-92','DD/MM/YY');


--2. Selecciona el nombre de las piezas y el precio de venta de aquellas piezas que sean PEGATINAS y cuyo valor supere los 50€
/* Para usar comodines se necesita LIKE '%COntenido%  %contenio contenido%'*/
--SELECT * FROM PIEZA; /*veo la tabla completa para comprobar*/

SELECT NOMPIEZA "NOMBRE DE PIEZA", PRECIOVENT "PRECIO DE VENTA" FROM PIEZA WHERE NOMPIEZA LIKE '%PEGATINAS%' AND PRECIOVENT > 50 ;


--3. Selecciona el nombre del vendedor, nombre de la comercial y nombre del producto de aquellas piezas que pueden sernos suministradas con un descuento
/*PARA QUE LAS CONDICIONES NO SEAN AMBIGUAS ES NECESARIO INDICAR LA TABLA DESDE LA QUE VIENE EL PARAMETRO ejemplo "VENDEDOR.NUMVENDEDOR"*/

SELECT NOMVEND "Nombre Vendedor", NOMBRECOMER "Nombre comercial", NOMPIEZA "Nombre pieza"
FROM VENDEDOR V,PRECIOSUM PS ,PIEZA P
WHERE V.NUMVEND=PS.NUMVEND AND PS.NUMPIEZA=P.NUMPIEZA AND PS.DESCUENTO IS NOT NULL AND PS.DESCUENTO !=0 ORDER BY PS.NUMPIEZA;


--4. Selecciona la media más alta de descuento de todos los productos que pueden sernos suministrados
/*COMPROBACIÓN PARA VER LOS DESCUENTOS Y SI LAS MEDIAS SON CORRECTAS
SELECT * FROM PRECIOSUM WHERE DESCUENTO IS NOT NULL AND DESCUENTO !=0 ORDER BY NUMPIEZA;*/

SELECT   MAX(AVG(DESCUENTO)) "Media máxima de descuento"  FROM PRECIOSUM WHERE DESCUENTO IS NOT NULL AND DESCUENTO !=0 GROUP BY DESCUENTO;


--5. Selecciona aquellas piezas cuya cantidad pedida media por pedido supere las 30 unidades
/*COMPROBACION TABLA LINPED
SELECT * FROM LINPED ORDER BY NUMPIEZA;*/

SELECT NUMPIEZA, AVG(CANTPEDIDA) "MEDIA" FROM LINPED   GROUP BY NUMPIEZA HAVING AVG(CANTPEDIDA)>30 ORDER BY AVG(CANTPEDIDA) ASC ;