import java.io.Serializable;

public class Activo implements Informe, Serializable {
    private String nombre;
    private double monto;

    public Activo(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    @Override
    public void listarInformacion() {
        System.out.println("Nombre: "+nombre+" Monto: "+monto);
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + '\'' +
                ", monto=" + monto +
                '}';
    }
}
