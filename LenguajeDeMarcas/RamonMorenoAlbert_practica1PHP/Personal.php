<!-- Ramón Moreno Albert Práctica 1 PHP -->
<?php
session_start(); //sin sesion_start(); las variables se pierden

if (isset($_POST['preferencias'])) {
    $_SESSION['idioma'] = $_POST['idioma'];
    $_SESSION['selectperfilpublico'] = $_POST['selectperfilpublico'];
    $_SESSION['zona'] = $_POST['zona'];
} else {
    $_SESSION['idioma'] = 'espanyol';  //valores predefinidos
    $_SESSION['selectperfilpublico'] = 'si';
    $_SESSION['zona'] = 'zona1';
}
$idioma = $_SESSION['idioma'];
$publico = $_SESSION['selectperfilpublico'];
$zona = $_SESSION['zona'];
?>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>PracticaPHPRMA</title>
    </head>
    <body>
        <div id="formulario" name="formulario-div">
            <h2>Preferencias</h2>   
            <form name="persona" method="POST" action="Personal.php">
                <div>
                    <label for="dni">DNI: </label>
                    <input type="text" id="dni" name="dni">
                </div>
                <div>
                    <label for="idioma">IDIOMA: </label>
                    <select id="idioma" name="idioma">
                        <?php
                        if ($idioma == 'espanyol') {
                            echo '<option value="espanyol" selected>ESPAÑOL</option>';
                            echo '<option value="ingles">INGLÉS</option>';
                            echo '<option value="valenciano">VALENCIANO</option>';
                        }
                        if ($idioma == 'ingles') {
                            echo '<option value="espanyol">ESPAÑOL</option>';
                            echo '<option value="ingles" selected>INGLÉS</option>';
                            echo '<option value="valenciano">VALENCIANO</option>';
                        }
                        if ($idioma == 'valenciano') {
                            echo '<option value="espanyol">ESPAÑOL</option>';
                            echo '<option value="ingles">INGLÉS</option>';
                            echo '<option value="valenciano" selected>VALENCIANO</option>';
                        }
                        ?>
                    </select>

                </div>
                <div>
                    <label for="perfilpublico">PERFIL PÚBLICO </label>
                    <select id="selectperfilpublico" name="selectperfilpublico">
                        <?php
                        if ($publico == 'si') {
                            echo '<option value="si">SI</option>';
                            echo '<option value="no">NO</option>';
                        }
                        if ($publico == 'no') {
                            echo '<option value="no">NO</option>';
                            echo '<option value="si">SI</option>';
                        }
                        ?>                  
                    </select>
                </div>
                <div>
                    <label for="zonahoraria">ZONA HORARIA: </label>
                    <select id="zona" name="zona">
                        <?php
                        if ($zona == 'zona1') {
                            echo '<option value="zona1">ZONE+1</option>';
                            echo '<option value="zona-1">ZONE-1</option>';
                            echo '<option value="zona0">ZONE-0</option>';
                        }
                        if ($zona == 'zona-1') {
                            echo '<option value="zona-1">ZONE-1</option>';
                            echo '<option value="zona0">ZONE-0</option>';
                            echo '<option value="zona1">ZONE+1</option>';
                        }
                        if ($zona == 'zona0') {
                            echo '<option value="zona0">ZONE-0</option>';
                            echo '<option value="zona-1">ZONE-1</option>';
                            echo '<option value="zona1">ZONE+1</option>';
                        }
                        ?> 
                    </select>
                </div>
                <button type="submit" name="preferencias">Establecer preferencias del usuario</button>
            </form>
            <a href="listar.php" target="_blank">Mostrar preferencias</a>
        </div>    
    </body>
</html>
