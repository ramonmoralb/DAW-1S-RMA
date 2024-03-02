-- 1. Número y nombre de los vendedores que oferten alguna de las piezas que pueden ser suministradas por el vendedor número 1,
-- pero que no oferten ninguna de las que puedan ser suministradas por el vendedor número 2.


SELECT V.NUMVEND, V.NOMVEND FROM VENDEDOR V 
JOIN PRECIOSUM PS ON PS.NUMVEND = V.NUMVEND
WHERE PS.NUMPIEZA IN (SELECT PS.NUMPIEZA FROM PRECIOSUM PS 
JOIN VENDEDOR V ON V.NUMVEND=PS.NUMVEND WHERE PS.NUMVEND=1) 
AND PS.NUMPIEZA NOT IN (SELECT PS.NUMPIEZA FROM PRECIOSUM PS 
JOIN VENDEDOR V ON V.NUMVEND=PS.NUMVEND WHERE PS.NUMVEND=2)
GROUP BY  V.NUMVEND, V.NOMVEND    
;


-- 2. Obtener el número y el nombre de los vendedores y la cantidad de piezas que pueden suministrar a un precio entre 15 y 20 euros, ordenado por el nombre de vendedor.


SELECT V.NUMVEND, V.NOMVEND, COUNT(PS.NUMPIEZA) FROM VENDEDOR V 
JOIN PRECIOSUM PS ON PS.NUMVEND=V.NUMVEND 
WHERE PS.NUMPIEZA IN (SELECT PS.NUMPIEZA FROM PRECIOSUM PS WHERE PS.PRECIOUNIT BETWEEN 15 AND 20)
GROUP BY  V.NUMVEND, V.NOMVEND 
ORDER BY V.NOMVEND 
;




-- 3. Obtener, para el vendedor que cumple que la diferencia de precio al que le compramos una pieza y el precio que nos había ofrecido por ella sea máxima, el número de vendedor, su nombre
-- y la diferencia media entre el precio al que nos vende las piezas y el que nos había ofrecido por las mismas.


SELECT V.NUMVEND, V.NOMVEND, AVG(L.PRECIOCOMPRA-P.PRECIOVENT) FROM VENDEDOR V
JOIN PRECIOSUM PS ON PS.NUMVEND=V.NUMVEND
JOIN PIEZA P ON P.NUMPIEZA=PS.NUMPIEZA
JOIN LINPED L ON L.NUMPIEZA=P.NUMPIEZA    
WHERE (L.PRECIOCOMPRA-P.PRECIOVENT)=(SELECT MAX(L.PRECIOCOMPRA-P.PRECIOVENT) FROM LINPED L
JOIN PIEZA P ON P.NUMPIEZA=L.NUMPIEZA)
GROUP BY  V.NUMVEND, V.NOMVEND
;




-- 4. Obtener el número de pieza de los teclados que nos han sido servidos en el mayo de cualquier año.

SELECT P.NOMPIEZA FROM PIEZA P       
JOIN LINPED L ON L.NUMPIEZA=P.NUMPIEZA
WHERE P.NOMPIEZA LIKE '%TECLADO%' AND
L.NUMPIEZA IN (SELECT L.NUMPIEZA FROM PEDIDO PE 
JOIN LINPED L ON L.NUMPEDIDO=PE.NUMPEDIDO  
WHERE  EXTRACT(MONTH FROM FECHARECEP) = 5
) GROUP BY P.NOMPIEZA 
;


-- 5. Obtener un listado en el que figure el número y nombre de la pieza , junto con el número y nombre de vendedor que nos ha ofertado la pieza, pero al que nunca se la hemos solicitado.


SELECT PS.NUMPIEZA, P.NOMPIEZA, V.NUMVEND, V.NOMVEND FROM VENDEDOR V
JOIN PRECIOSUM PS ON PS.NUMVEND=V.NUMVEND
JOIN PIEZA P ON P.NUMPIEZA=PS.NUMPIEZA
WHERE PS.NUMPIEZA NOT IN (SELECT L.NUMPIEZA FROM LINPED L)
;
