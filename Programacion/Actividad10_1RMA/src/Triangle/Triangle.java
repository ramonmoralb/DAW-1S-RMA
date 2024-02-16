
package Triangle;
/**
 * @author RamonMorenoAlbert
 */
public class Triangle {
    private double lado1;
    private double lado2;
    private double lado3;
    
    
    public Triangle(double lado1, double lado2, double lado3) throws TriangleIllegalException {
    String mensajeError = "";
    
    if ((lado1 + lado2) < lado3) {
        mensajeError += "La suma del lado 1: ["+lado1+"] y lado 2: ["+lado2+"] es: ["+(lado1 + lado2)+"] y es menor que el lado 3:["+lado3+"]. \n"
                + "La regla de los lados de los triángulos, también conocida como desigualdad triangular,\n"
                + "establece que en un triángulo cualquiera, la longitud de cada uno de sus lados debe ser menor que la suma de las longitudes de los otros dos lados.\n";
    }
    if ((lado2 + lado3) < lado1) {
       mensajeError += "La suma del lado 2: ["+lado2+"] y lado 3: ["+lado3+"] es: ["+(lado2 + lado3)+"] y es menor que el lado 1:["+lado1+"]. \n"
                + "La regla de los lados de los triángulos, también conocida como desigualdad triangular,\n "
                + "establece que en un triángulo cualquiera, la longitud de cada uno de sus lados debe ser menor que la suma de las longitudes de los otros dos lados.\n";
    }
    if ((lado3 + lado1) < lado2) {
       mensajeError += "La suma del lado 3: ["+lado3+"] y lado 1: ["+lado1+"] es: ["+(lado1 + lado3)+"] y es menor que el lado 2:["+lado2+"]. \n"
                + "La regla de los lados de los triángulos, también conocida como desigualdad triangular,\n "
                + "establece que en un triángulo cualquiera, la longitud de cada uno de sus lados debe ser menor que la suma de las longitudes de los otros dos lados.\n";
    }
    
    if (!mensajeError.isEmpty()) {      
        throw new TriangleIllegalException(mensajeError);
    }
    
    this.lado1 = lado1;
    this.lado2 = lado2;
    this.lado3 = lado3;
}
    

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    public void mostarTriangulo(){
        System.out.println("El triángulo se ha creado correctamente.");
        System.out.println("Lado1 ="+getLado1());
        System.out.println("Lado2 ="+getLado2());
        System.out.println("Lado3 ="+getLado3());
    }
   
}
