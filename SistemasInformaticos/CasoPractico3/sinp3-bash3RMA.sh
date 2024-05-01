#!/bin/bash

#metodo para verificar entrada por teclado
comprobar_opcion(){
if [[ $1 =~ ^[[0-7]+$ ]]; then 
opcion_valida=1
else
opcion_valida=0
fi
}
#bucle que muestra el menu mientras no se selecciona salir
while [[ $salir -eq 0 ]]; do 
opcion_valida=0
echo "/*********BIENVENIDO**********/"
echo "1) Cuál es mi nombre de ususario."
echo "2) En qué directorio estoy."
echo "3) Crea una carpeta en una ruta concreta."
echo "4) Cambia la contraseña de mi usuario."
echo "5) Abre el navegador web Firefox."
echo "6) Descarga un fichero de una ruta determinada."
echo "7) Reinicia el sístema."

echo "0) Salir" 
#comprobación de entrada valida
while [[ $opcion_valida -eq 0 ]]; do
read -p "Elige una opción: " opcion
comprobar_opcion "$opcion"
if [[ $opcion_valida -ne 1 ]]; then 
echo "Error. Debes introducir una opción del 0 al 7."
fi
done

#switch desde el que se seleccionan las opciones
 case "$opcion" in
   0)
      salir=1
   ;;

   1)
      nombre_usuario=$USER
echo ""
echo "El nombre de usuario es: $nombre_usuario"
echo ""
   ;;

   2)
      localizacion=$(pwd)
echo ""
echo "La localizacion actual es $localizacion"
echo ""
   ;;

   3)
    read -p "Introduzaca el nombre de su nueva carpeta: " nombre_carpeta
    read -p "Introduzaca la ubicacíon de su nueva carpeta: " ubicacion
    mkdir "$ubicacion/$nombre_carpeta"
   ;;

   4)
   echo "Cambiando la contraseña del usuario actual $USER"
   sudo passwd
   echo ""
   ;;

   5)

   firefox

   ;;

   6)
   echo "Introduce la ruta desde la que desea descargar el archivo."
   read -p "Aquí su ruta: " ruta 
   wget "$ruta"
   echo ""
   ;;

   7)
echo "Reiniciando....."    
    sudo reboot
   ;;
esac

if [[ $salir -eq 1 ]]; then
echo "Programa finalizado."
fi
done

