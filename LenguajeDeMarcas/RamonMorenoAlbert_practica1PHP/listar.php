<!-- Practica PHP Ramón Moreno Albet -->
<!DOCTYPE html>
<?php
session_start();
$boton_borrar = true;

if (isset($_POST['borrar'])) {
    $_POST = [];
    $_SESSION = [];
    $boton_borrar = false;
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
    $boton_borrar = false;
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title>LListar</title>
        <link rel="stylesheet" href="style.css"/>

    </head>
    <body>
        <div id="conte">
            <p class="plistar" >DNI: <?php echo $dni ?></p>
            <p class="plistar" >IDIOMA: <?php echo $idioma ?></p>
            <p class="plistar" >PERFIL PUBLICO: <?php echo $publico ?></p>
            <p class="plistar" >ZONA HORARIA: <?php echo $zona ?></p>

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
