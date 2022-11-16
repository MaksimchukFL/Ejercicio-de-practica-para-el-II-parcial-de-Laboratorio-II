import java.io.Serializable;

public class Persona implements Informe, Serializable {
    String nombre;
    String apellido;
    int dni;
    String direccion;

    public Persona(String nombre, String apellido, int dni, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
    }

    @Override
    public void listarInformacion() {
        System.out.println(nombre+","+apellido+" DNI numero: "+dni+ " DIRECCION: "+direccion);
    }

}
