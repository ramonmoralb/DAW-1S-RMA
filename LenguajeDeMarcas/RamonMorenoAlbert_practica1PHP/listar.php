<?php
session_start(); //sin sesion_start(); las variables se pierden


//haciendo pruebas de como recibir las variables
$idioma = $_SESSION['idioma'];
$publico = $_SESSION['selectperfilpublico'];
$zona = $_SESSION['zona'];
?>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        echo $idioma;
?>
    </body>
</html>
