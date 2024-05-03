class Calculadora {
    /* contructor de la calculadora se debe iniciar con el metodo borrar que usaré en la C*/ 
    constructor() {    
        this.operandoIzquierda = '';
        this.operandoDerecga = '';
        this.operacion = "";
        this.pantalla = document.getElementById('pantalla');
        this.borrar();
    }

    borrar(){
        this.operandoIzquierda=0;
        this.actualizarPantalla();
    }
    borrarUltimo(){
        this.operandoIzquierda =  this.operandoIzquierda.slice(0, -1);
        this.actualizarPantalla();
    }

    presionarNumero(numero) {
        if(this.operandoIzquierda===0 && numero !== '.'){   /*borrar el 5 a la izquierda , pero no si inicia con decimal debe de ser  diferente a . cpnd*/ 
            this.operandoIzquierda= '';
        };
        /**implementar lógica para si no es el primer .puntoDecimal no lo escriba */
        this.operandoIzquierda += numero;
        this.actualizarPantalla();
    }

    actualizarPantalla() {
        this.pantalla.textContent = this.operandoIzquierda;
        /* cuando implemente el metodo que calcule, aquí debera concatenar operando y el operador de la drecha 
        *  puesto que el operador izquierda ya no será el único
        */
    }
     
    calcular(){


    }
}

const calculadora = new Calculadora();