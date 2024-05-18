class CalculadoraD {
    
    constructor(){
        this.operandoIzq = '';
        this.operandoDer = '';
        this.operador = null;
        this.pantalla = document.getElementById('pantalla');
        this.resultado = '';
        this.error= false;
        this.borrar();   
        
    }

    borrar(){
        this.operandoDer='';
        this.operandoIzq='0';
        this.operador = null;
        this.error=false;
        this.updatePantalla();
    }

    borrarAnterior(){
            if(this.operandoIzq !== '0'){   
            this.operandoIzq = this.operandoIzq.slice(0, -1);
            }
            if(this.operandoIzq === '' && this.operandoDer ===''){
                this.operandoIzq='0';
            }
            this.updatePantalla();
    }



    pulsarTecla(tecla){
        if(this.error===true){
            this.borrar();
        } 
        let tipo = tecla.getAttribute("data-tecla-type");
 
        switch (tipo) {
            case 'operador':
               this.cambiarOperador(tecla);
            break;

            case 'borradoAnterior':
                this.borrarAnterior();       
            break;

            case 'numero':
                this.anyadirNumero(tecla);
            break;

            case 'coma':
                this.ponerComa(tecla);
            break;

            case 'calcular':
                this.calcular();
            break;

            case 'borrar':
                this.borrar();
            break;
        }
    }

    cambiarOperador(tecla){
        if(this.operador===null){
        this.operador = tecla.textContent; 
        this.operandoDer = this.operandoIzq;
        this.operandoIzq = '';
        this.updatePantalla();
        }
    }

    anyadirNumero(tecla){
        if(this.operandoIzq === '0'){
            this.operandoIzq = ''
        }
        this.operandoIzq += tecla.textContent;
        this.updatePantalla();
    }


    ponerComa(tecla){ 
        if (!this.operandoIzq.includes('.')) {  
            if(this.operandoDer!=='' && this.operandoIzq===''){
                this.operandoIzq='0';
            }
            this.operandoIzq += tecla.textContent;
            this.updatePantalla();
        }
    }
     

    updatePantalla() {  
        if(this.operandoDer !== ''){   
            this.pantalla.textContent= this.operandoDer +this.operador+ this.operandoIzq;
        } else {
            this.pantalla.textContent = this.operandoIzq;
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
                    this.error=true;
                    this.excepcionDivisionMensaje();
                } else {
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

    excepcionDivisionMensaje(){
        const modal = document.getElementById('modal');
        modal.classList.add('mostrar');
    }
    cerrarModal(){
        const modal = document.getElementById('modal');
        modal.classList.remove('mostrar');
    }
}   

const calculadorad = new CalculadoraD();
