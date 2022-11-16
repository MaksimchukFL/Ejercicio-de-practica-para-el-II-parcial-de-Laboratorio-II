import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main implements Serializable{

    public static void main(String[] args) {
	// write your code here
    LinkedList<Cliente> listaClientes=new LinkedList<Cliente>();
    int seleccion=0;
    Scanner entradaseleccion=new Scanner(System.in);
    //Interfaz del programa:
        while (seleccion!=8) {
            System.out.println("Hola! Ingrese la opcion que corresponda a la operacion que quiera realizar:\n1.Crear cliente\n2.Agregar activos a un cliente\n3.Listar todos los clientes\n4.Listar un cliente y sus activos\n5.Eliminar cliente\n6.Guardar progreso\n7.Cargar progreso\n8.Salir.");
            Scanner entrada=new Scanner(System.in);
            seleccion=entradaseleccion.nextInt();

            switch (seleccion){
                case 1:
                    //Cargar cliente
                    try{
                    System.out.println("Ingrese nombre:");
                    String nombre=entrada.nextLine();
                    System.out.println("Ingrese apellido:");
                    String apellido=entrada.nextLine();
                    System.out.println("Ingrese DNI:");
                    int dni=entrada.nextInt();
                    /*
                    Siempre debemos agregar un nextLine(); despues de leer un tipo de dato distinto en este caso.
                    Por en funcionamiento propio del scanner, esto causa que la proxima lectura se salte. Gracias StackOverflow una vez mas.
                     */
                    entrada.nextLine();
                    System.out.println("Ingrese direccion:");
                    String direccion=entrada.nextLine();
                    Cliente cliente=new Cliente(nombre,apellido,dni,direccion);
                    listaClientes.add(cliente);
                    }
                    catch (InputMismatchException exception){
                        System.out.println("Error en el ingreso de datos, intente otra vez.");
                    }
                    break;
                case 2:
                    //Cargar activo
                    if (listaClientes.isEmpty()){
                        System.out.println("No hay clientes cargados. Intente de nuevo agregando un cliente.");
                    } else{ try{
                        System.out.println("Ingrese el nombre del cliente al cual quiere asignarle un activo: ");
                        String clientebuscado=entrada.nextLine();
                        for (Cliente cliente:listaClientes
                             ) {

                            if (clientebuscado.equals(cliente.nombre)){
                            System.out.println("Ingrese el nombre del activo:");
                            String nombreactivo=entrada.nextLine();
                            System.out.println("Ingrese el monto del activo:");
                            double montoactivo=entrada.nextDouble();
                            entrada.nextLine();
                            Activo activo=new Activo(nombreactivo,montoactivo);
                            cliente.getListaActivos().add(activo);
                            System.out.println("Activo agregado con exito.");
                        }

                        }} catch (InputMismatchException exception){
                        System.out.println("Error en el ingreso de datos, intente de nuevo.");
                    }
                    }
                    break;
                case 3:
                    //Listar clientes
                    for (Cliente cliente:listaClientes
                         ) {
                        System.out.println("["+cliente.nombre+","+cliente.apellido+" dni nro: "+cliente.dni+" direccion: "+cliente.direccion+"]");
                    }
                    break;
                case 4:
                    //Listar un cliente y sus activos
                    System.out.println("Ingrese el nombre del cliente a buscar: ");
                    String nombreabuscar=entrada.nextLine();
                    for (Cliente cliente:listaClientes
                         ) {
                        if (nombreabuscar.equals(cliente.nombre)){
                            cliente.listarInformacion();
                        }
                    }
                    break;
                case 5:
                    //Buscar y eliminar un cliente
                    System.out.println("Ingrese el nombre del cliente a eliminar: ");
                    String nombreaeliminar=entrada.nextLine();
                    for (Cliente cliente:listaClientes
                    ) {
                        if (nombreaeliminar.equals(cliente.nombre)){
                            listaClientes.remove(cliente);
                            System.out.println("Cliente eliminado con exito");
                        }
                    }
                    break;
                case 6:
                    //Escritura del archivo que contiene los clientes creados
                    try{
                        ObjectOutputStream archivoclientessalida=new ObjectOutputStream(new FileOutputStream("clientes.cli"));
                        archivoclientessalida.writeObject(listaClientes);
                        System.out.println("Progreso guardado con exito.");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    //Lectura del archivo que contiene los clientes creados
                    try {
                        ObjectInputStream archivoclientesentrada=new ObjectInputStream(new FileInputStream("clientes.cli"));
                        listaClientes = (LinkedList<Cliente>) archivoclientesentrada.readObject();
                        System.out.println("Progreso cargado con exito");
                    }catch (IOException e) {
                        // catch para capturar los errores al intentar leer el archivo
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        // catch para capturar los errores producto de la lecuta del archivo
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
