import java.io.Serializable;
import java.util.LinkedList;

public class Cliente extends Persona implements Informe, Serializable {
    private LinkedList <Activo> listaActivos=new LinkedList<Activo>();

    public Cliente(String nombre, String apellido, int dni, String direccion) {
        super(nombre,apellido,dni,direccion);
    }


    //Metodos


    public LinkedList<Activo> getListaActivos() {
        return listaActivos;
    }

    @Override
    public void listarInformacion() {
        System.out.println(nombre+","+apellido+" DNI numero: "+dni+ " DIRECCION: "+direccion+" Activos: "+listaActivos.toString());

    }
}
