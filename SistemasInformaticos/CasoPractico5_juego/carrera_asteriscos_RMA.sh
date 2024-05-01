#!/bin/bash

jugador1=""
jugador2=""
marcador1=0
marcador2=0
turno=0

function imprimir_dado(){
puntos="$1"
case "$puntos" in
    1)
        echo " _____ "
        echo "|     |"
        echo "|  *  |"
        echo "|     |"
        echo " _____ "
        ;;
    2)
        echo " _____ "
        echo "|*    |"
        echo "|     |"
        echo "|    *|"
        echo " _____ "
        ;;
    3)
        echo " _____ "
        echo "|*    |"
        echo "|  *  |"
        echo "|    *|"
        echo " _____ "
        ;;
    4)
        echo " _____ "
        echo "|*   *|"
        echo "|     |"
        echo "|*   *|"
        echo " _____ "
        ;;
    5)
        echo " _____ "
        echo "|*   *|"
        echo "|  *  |"
        echo "|*   *|"
        echo " _____ "
        ;;
    6)
        echo " _____ "
        echo "|* * *|"
        echo "|     |"
        echo "|* * *|"
        echo " _____ "
        ;;
esac

}

function sortear_inicio(){
turno=$((RANDOM % 2))
  echo "Realizando sorteo....."
    if [[ "$turno" -eq 0 ]]; then
        echo "$jugador1 Has ganado el sorteo tu empiezas"
    else
        echo "$jugador2 Has ganado el sorteo tu empiezas"
   fi
}

function cambiar_turno() {
   if [[ "$turno" -eq 1 ]]; then
      turno=0
   else
      turno=1
   fi
}


function anunciar_ganador() {


if [[ "$marcador1" -gt 50 || "$marcador1" -eq 50 ]]; then
   echo "!!! $jugador1 GANADOR ENHORABUENA!!!"
else
   echo "!!! $jugador2 GANADOR ENHORABUENA!!!"
fi
}

function tirar_turno() {

     if [[ "$turno" -eq 0 ]]; then
       read  -s  -p "¡¡ $jugador1 es tu turno pulsa intro para lanzar el dado!!! "   cualquier
             echo ""
             tirada=$((RANDOM % 6 + 1))
             #tirada=50 #pruebas
             imprimir_dado "$tirada"
             echo "Has sacado un [ $tirada ]"
             if [[ ! "$tirada" -eq "$tirada_anteriorj1"  ]]; then
             marcador1=$((marcador1+tirada))
             else
             marcador1=$((marcador1-tirada))
             echo  "Ohhhh! Has sacado lo mismo que antes...Restando puntuación..."
		 if [[ "$marcador1" -lt 0 ]]; then
                 marcador1=0
                     echo "Te quedas en 0 no se peude restar más..."
                 fi
             tirada_anteriorj1="$tirada"
     fi
    else
       read  -s -p "¡¡¡¡ $jugador2 es tu turno pulsa intro para lanzar el dado!!! "    cualquier
             echo ""
             tirada=$((RANDOM % 6 +1))
             #tirada=49 #pruebas 
             imprimir_dado "$tirada"
             echo "Has sacado un [ $tirada ]"
             if [[ ! "$tirada" -eq "$tirada_anteriorj2"  ]]; then
             marcador2=$((marcador2+tirada))
             else
             marcador2=$((marcador2-tirada))
            echo  "Ohhhh! Has sacado lo mismo que antes...Restando puntuación..."
                 if [[ "$marcador2" -lt 0 ]]; then
                 marcador2=0
                     echo "Te quedas en 0 no se peude restar más..."
                 fi
             fi
             tirada_anteriorj2="$tirada"
     fi
}

function pintar_asteriscos() {
#esta función indicara la puntuación de cada jugador haciendo uso
#de la función bucleAsteriscos, a la que se le pasará el marcador del jugador
    echo "  MARCADOR"
    echo "------------"
    echo "$jugador1[$marcador1]"
    bucleAsteriscos "$marcador1"
    echo "                                                  |META"
    echo "$jugador2[$marcador2]"
    bucleAsteriscos "$marcador2"
    echo "                                                  |META"
}

function bucleAsteriscos() {
#esta función pintará tantos asteriscos como puntos tenga el marcador
#del jugador que se le pas
impresiones="$1"
asterisco="*"
    for (( i=0; i<"$impresiones"; i++ )); do
    echo -n "$asterisco"
    done
    echo ""
}

function introducir_nombre_jugador() {
    while [[ "$jugador1" == ""  ]]; do
        read -p "Nombre del primer jugador: " jugador1
           if [[ "$jugador1" == "" ]]; then
              echo "Error. El nombre del Jugador1 no puede estar vacio."
           fi
   done
   while [[ "$jugador2" == ""  ]]; do
       read -p "Nombre del segundo jugador: " jugador2
          if [[ "$jugador2" == ""  ]]; then
             echo "Error. El nombre del jugador 2 no puede estar vacio."
          fi
  done
}

function saludo_inicial() {
   echo "Bienvenidos jugadores $jugador1 y $jugador2 a la CARRERA DE ASTERISCOS"
   echo "El ganador de la carrera será el jugador que primero llegue a 50 puntos o los sobrepase."
   echo "Los puntos se sumarán con el resulado de cada tirada de un dado de 6 caras."
   echo "¡¡¡Cuidado!!! Si sacas 2 veces seguidas el mismo resultado en el dado, la segunda tirada se restará."
   echo "Pero tranquilos para evitar una humillación, el resultado jamás podrá ser negativo."
   echo "Para diluccidar el turno inicial se realiza un sorteo."
   echo "Suerte y al DADO"
   echo ""
}


#inicio
echo "   JUEGO CARRERA DE ASTERISCOS   "
echo ""
    introducir_nombre_jugador
    saludo_inicial
    sortear_inicio
while [[ "$marcador1" -lt 50 && "$marcador2" -lt 50 ]]; do
   tirar_turno
echo ""
   pintar_asteriscos
   cambiar_turno
done
   anunciar_ganador

#FIN DEL CUERPO DEL PROGRAMA
