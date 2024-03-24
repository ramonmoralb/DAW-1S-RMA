DECLARE 
    importe number(5)=139;
    cantidad_bil_mon number(3);
    resto number(5);
    billete_500 number(3)= 500;
    billete_200 number(3)=200;
    billete_100 number(3)=100;
    billete_50 number(2)=50;
    billete_20 number(20)=20;
    billete_10 number(2)=10;
    billete_5 number (1)=5;
    moneda_2 number (1)=2;
    moneda_1 number (1)=1;
    

BEGIN
    dbms_output.put_line('Descomposición de importe en máximo valor de billetes y monedas');
    cantidad_bil_mon = trunc(importebillete_500);
    importe = importe - (cantidad_bil_monbillete_500);
    dbms_output.put_line('Billetes de 500€ 'cantidad_bil_mon);
    
    cantidad_bil_mon = trunc(importebillete_200);
    importe = importe - (cantidad_bil_monbillete_200);
    dbms_output.put_line('Billetes de 200€ 'cantidad_bil_mon);
    
    
    cantidad_bil_mon = trunc(importebillete_100);
    importe = importe - (cantidad_bil_monbillete_100);
    dbms_output.put_line('Billetes de 100€ 'cantidad_bil_mon);

    cantidad_bil_mon = trunc(importebillete_50);
    importe = importe - (cantidad_bil_monbillete_50);
    dbms_output.put_line('Billetes de  50€ 'cantidad_bil_mon);
    
    cantidad_bil_mon = trunc(importebillete_20);
    importe = importe - (cantidad_bil_monbillete_20);
    dbms_output.put_line('Billetes de  20€ 'cantidad_bil_mon);
    
    cantidad_bil_mon = trunc(importebillete_10);
    importe = importe - (cantidad_bil_monbillete_10);
    dbms_output.put_line('Billetes de  10€ 'cantidad_bil_mon);
    
    cantidad_bil_mon = trunc(importebillete_5);
    importe = importe - (cantidad_bil_monbillete_5);
    dbms_output.put_line('Billetes de   5€ 'cantidad_bil_mon);
    
    cantidad_bil_mon = trunc(importemoneda_2);
    importe = importe - (cantidad_bil_monmoneda_2);
    dbms_output.put_line('Monedas de    2€ 'cantidad_bil_mon);

    cantidad_bil_mon = trunc(importemoneda_1);
    importe = importe - (cantidad_bil_monmoneda_1);
    dbms_output.put_line('Monedas de    1€ 'cantidad_bil_mon);
END;