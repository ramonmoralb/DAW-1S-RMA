#!/bin/bash
#script creado por RMA**

salir=1  #hará de condición para la salida del bucle.

comprobar_opcion(){ #metodo que comprueba que la opción elegida está en rango
   if [[ $1 =~ ^[[1-7]+$ ]]; then
opcion_valida=1
else
opcion_valida=0
fi
}


while [[ $salir -eq  1 ]]; do  # el bucle repetirá el menu
opcion_valida=0 #inicializó la condición de comprobar rango
    echo "1. Listar ficheros."
    echo "2. Ver directorios de trabajo."
    echo "3. Crear directorio."
    echo "4. Borrar directorio."
    echo "5. Crear usuario."
    echo "6. Borrar usuario."
    echo "7. Salir"
while [[ "$opcion_valida" -eq 0  ]]; do
    read -p "Elija una opción: " opcion
    comprobar_opcion  "$opcion" # el metodo recibe por parametro la opción
done
   case "$opcion" in # swicht
     1)
       directorio_actual=$(pwd)
       echo "Lista de ficheros del directorio actual:  [ $directorio_actual ]"
       ls -l
       echo ""
     ;;
     2)
     directorio_actual=$(pwd)
     echo "Directorio actual: [ $directorio_actual ]"
     echo ""
     ;;
     3)
     directorio_actual=$(pwd)
     read -p "Indiqué el nombre del directorio:  " nombre_dir
     echo "El directorio $nombre_dir se creará en [ $directorio_actual ]"
     read -p "Confirmar pulse 's', Cancelar pulse 'c'" opcion
     if [[ "$opcion" == "s" ]]; then
     mkdir "$nombre_dir"
     echo "Directorio creado correctamente."
     echo ""
     else
     echo "Cancelado"
     echo ""
     fi
     ;;
     4)
     directorio_actual=$(pwd)
     read -p "Indique el nombre del directorio vacio que desea borrar: " nombre_dir
     if [[ -d  "$nombre_dir" ]]; then # -d comprueba la direccion actual
     rmdir "$nombre_dir"
     echo "Directorio [ $nombre_dir  ]   eliminado en [ $directorio_actual ]"
     echo ""
     else
     echo "No existe el directorio [ $nombre_dir ]  en [ $directorio_actual ]"
     echo ""
     fi
     ;;
     5)
     #para comprobar quien ejecuta uso EUID en una condición
     # EUID es el numero del usuario y sabemos que root es el 0
     if [[ "$EUID" -eq 0 ]]; then
     read -p "Introduzca el nombre del nuevo usuario: " nombre_user
     useradd -m -d  "/home/$nombre_user" "$nombre_user" #crea el ususrio y su directorio
     echo "Usuario $nombre_user creado correctamente y carpeta de usuario creade en /home/$nombre_user " 
     else
     echo "Debe ejecutar el Script como ROOT para poder crear un usuario [ sudo ./SINF_B_P4.sh  ]"
     fi
     echo ""
     ;;
     6)
     if [[ $EUID -eq 0 ]]; then #si usuario es igual a 0  ROOT ... else
     read -p "Introduce el nombre del usuario que desea eliminar, también se eliminara su carpeta de usuario: " nombre_usuario
     userdel -r  "$nombre_usuario" 2>/dev/null  #hace que no muestre el error de la recrisividad cuando intenta borra carpetas inexistentes
     echo "Borrado $nombre_usuario y su carpeta."
     else
     echo "Este script debe ser ejecutado por root."
     echo ""
     fi
     ;;
     7)
       salir=0
    ;;
    esac

done
