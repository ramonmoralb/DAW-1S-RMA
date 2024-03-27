<!-- Practica PHP Ramón Moreno Albet -->
<!DOCTYPE html>
<?php
session_start();
$boton_borrar = true;

if (isset($_POST['borrar'])) {
    $_POST = [];
    $_SESSION = [];
    $boton_borrar = false; // Desactiva el botón después de borrar las preferencias
}

if (!empty($_SESSION)) {
    $dni = $_SESSION['dni'];
    $idioma = $_SESSION['idioma'];
    $publico = $_SESSION['publico'];
    $zona = $_SESSION['zona'];
} else {
    $dni = "";
    $idioma = "";
    $publico = "";
    $zona = "";
    $boton_borrar = false; // No hay preferencias, por lo tanto, desactiva el botón
}
?>


<html>
    <head>
        <meta charset="UTF-8">
        <title>LListar</title>
        <style>
            #conte{
                border: solid 1px black;
                width: 450px;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <div id="conte">
            <p>DNI: <?php echo $dni ?></p>
            <p>IDIOMA: <?php echo $idioma ?></p>
            <p>PERFIL PUBLICO: <?php echo $publico ?></p>
            <p>ZONA HORARIA: <?php echo $zona ?></p>

            <?php if ($boton_borrar) { ?>
                <form action="listar.php" method="POST">
                    <input type="submit" name="borrar" value="Borra preferencias">
                <?php } ?>
                <?php if (!$boton_borrar) { ?>
                    <a href="persona.php">Volver</a>
                <?php } ?>
            </form>
        </div>
    </body>
</html>
