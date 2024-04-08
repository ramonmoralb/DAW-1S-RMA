<!-- Practica PHP Ramón Moreno Albet -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Preferencias</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <header id="cabecera"><h2>Preferencias</h2></header>
        <?php
        session_start();
        $mostrar = false;
        if (isset($_POST['enviar'])) {
            $_SESSION['dni'] = $_POST['dni'];
            $_SESSION['idioma'] = $_POST['idioma'];
            $_SESSION['publico'] = $_POST['publico'];
            $_SESSION['zona'] = $_POST['zona'];
            $mostrar = true;
        }
        if (isset($_POST['borrar'])) {
            $_POST = []; // Limpiar $_POST solo si se ha enviado el formulario "borrar"
        }
        ?>


        <?php if ($mostrar) { ?>
            <aside>
                <h2>Sus preferencias han sido guardadas.</h2>


                <a href="listar.php">Mostrar preferencias</a>
                <form method="POST" action="Persona.php">
                    <input type="submit" name="borrar" value="Borrar">
                </form>


            </aside>
            <?php
            $mostrar = false;
        }
        ?>
        <div id="contenedorformulario">
            <form id="primerf" method="POST" action="Persona.php">
                <label for="dni">DNI: </label>
                <input type="text" name="dni">
                <label for="idioma">Idioma: </label>
                <select id="id" name="idioma">
                    <option value="ESPAÑOL" <?php if (isset($_SESSION['idioma']) && $_SESSION['idioma'] == 'ESPAÑOL') echo 'selected="selected"'; ?>>ESPAÑOL</option>
                    <option value="INGLES" <?php if (isset($_SESSION['idioma']) && $_SESSION['idioma'] == 'INGLES') echo 'selected="selected"'; ?>>INGLÉS</option>
                    <option value="VALENCIANO" <?php if (isset($_SESSION['idioma']) && $_SESSION['idioma'] == 'VALENCIANO') echo 'selected="selected"'; ?>>VALENCIANO</option>
                </select>
                <label for="publico">PERFIL PÚBLICO: </label>
                <select id="" name="publico"> 
                    <option value="SI" <?php if (isset($_SESSION['publico']) && $_SESSION['publico'] == 'SI') echo 'selected="selected"'; ?> >SI</option>
                    <option value="NO" <?php if (isset($_SESSION['publico']) && $_SESSION['publico'] == 'NO') echo 'selected="selected"'; ?>>NO</option>
                </select>
                <label for="zona">Zona: </label>
                <select id="" name="zona">
                    <option value="ZONA+1" <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] == 'ZONA+1') echo 'selected="selected"'; ?>>ZONA+1</option>
                    <option value="ZONA0" <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] == 'ZONA0') echo 'selected="selected"'; ?> >ZONA0</option>
                    <option value="ZONA-1" <?php if (isset($_SESSION['zona']) && $_SESSION['zona'] == 'ZONA-1') echo 'selected="selected"'; ?>>ZONA-1</option>
                </select>



                <input type="submit" name="enviar" value="enviar">
            </form>
        </div>


    </body>
</html>
