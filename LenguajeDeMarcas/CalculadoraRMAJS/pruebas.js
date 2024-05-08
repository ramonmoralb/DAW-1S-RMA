class CalculadoraD {
    
    constructor(){
        this.operandoIzq = '';
        this.operandoDer = '';
        this.operador = null;
        this.pantalla = document.getElementById('pantalla');
        this.resultado = '';
        this.borrar();
       
    }    
    borrar(){
        this.operandoDer='';
        this.operandoIzq='0';
        this.updatePantalla();
    }

    pulsarTecla(tecla){
        if (this.operandoIzq === '0') {
            this.operandoIzq = '';
        }
        let tipo = tecla.getAttribute("data-tecla-type"); // le doy a la variable el tipo y luego lo uso en el if para el operador.
        if(tipo === 'operador'){  // si el tipo es igual a operador... podría usar los tipos para desde el metodo pulsar tecla hacer la operación, borrar, 
            this.operador=tecla.textContent;  //y todo simplemente en el html hay que definir el tipo adecuado a cada botón
            this.operandoDer = this.operandoIzq;
            this.operandoIzq = '';
        } else {
            
            this.operandoIzq += tecla.textContent;
        }
        this.updatePantalla();
    }


/*  // sin data
    pulsarNumero(numero) {
        if (this.operandoIzq === '0') {
            this.operandoIzq = '';
        }
       
        if (numero === '+' || numero === '-' || numero === '/' || numero === 'x') {
            // Si se presiona un botón de operador, asignar el operador y mover el operando izquierdo al derecho
            this.operador = numero;
            this.operandoDer = this.operandoIzq;
            this.operandoIzq = '';
        } else {
            // Si se presiona un botón de número, simplemente agregarlo al operando izquierdo
            this.operandoIzq += numero;
        }
        this.updatePantalla();
    }
    
*/
   
    updatePantalla() {  
        if(this.operandoDer !== ''){
            
            this.pantalla.textContent= this.operandoDer +this.operador+ this.operandoIzq;
        }else{
        this.pantalla.textContent =this.operandoIzq;
        }
    }
    calcular() {
        let izq = parseFloat(this.operandoIzq);
        let der = parseFloat(this.operandoDer);
        
        switch (this.operador) {
            case '+':
                this.resultado = izq + der;
                break;
            case '-':
                this.resultado = der - izq;
                break;
            case 'x':
                this.resultado = izq * der;
                break;
            case '/':
                if(izq ===0){
                    this.resultado= "Err"
                }else{
                this.resultado = der / izq;
                }
                break;
            default:
                return;
        }
        this.operandoIzq = this.resultado.toString();
        this.operandoDer = '';
        this.operador = null;
        this.updatePantalla();
    }
}   

const calculadorad = new CalculadoraD();