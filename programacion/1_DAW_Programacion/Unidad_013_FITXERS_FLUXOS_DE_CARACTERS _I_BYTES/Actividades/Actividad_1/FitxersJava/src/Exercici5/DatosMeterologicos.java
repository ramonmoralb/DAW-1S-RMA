package Exercici5;

/**
 *
 * @author ramon
 */
public class DatosMeterologicos {
    private double temperaturaMaxima;
    private String horaMaxima;
    private double temperaturaMinima;
    private String horaMinima;
    private double precipitaciones;

    public DatosMeterologicos(double temperaturaMaxima, String horaMaxima, double temperaturaMinima, String horaMinima, double precipitaciones) {
        this.temperaturaMaxima = temperaturaMaxima;
        this.horaMaxima = horaMaxima;
        this.temperaturaMinima = temperaturaMinima;
        this.horaMinima = horaMinima;
        this.precipitaciones = precipitaciones;
    }

    public double getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(double temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public String getHoraMaxima() {
        return horaMaxima;
    }

    public void setHoraMaxima(String horaMaxima) {
        this.horaMaxima = horaMaxima;
    }

    public double getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(double temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public String getHoraMinima() {
        return horaMinima;
    }

    public void setHoraMinima(String horaMinima) {
        this.horaMinima = horaMinima;
    }

    public double getPrecipitaciones() {
        return precipitaciones;
    }

    public void setPrecipitaciones(double precipitaciones) {
        this.precipitaciones = precipitaciones;
    }
    

    @Override
    public String toString() {
        double diferenciaTemperatura = temperaturaMaxima - temperaturaMinima;
        
        diferenciaTemperatura = Math.round(diferenciaTemperatura * 100.0) / 100.0;
        return "DatosMeterologicos:\n" + "Temperatura Maxima: " + temperaturaMaxima + ", Hora de máxima= " + horaMaxima + 
                ",\nTemperatura Mínima= " + temperaturaMinima + ",  Hora de mínima= " + horaMinima + "\nDiferencia temperatura: " + diferenciaTemperatura +
                ",\nPrecipitaciones= " + precipitaciones;
    }
    
}
