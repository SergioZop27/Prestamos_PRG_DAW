import jdk.swing.interop.SwingInterOpUtils;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int resul;
        String aux; //auxiliar que se utilizara en casi todos los String
        GestorBiblioteca registro = new GestorBiblioteca();
        //-------------Usuario----------
        String nombreUser;
        String email;
        String numSocio;
        LocalDate fechaRegistro;
        //---------Prestamo------------------
        String codigoLibro;
        Usuario socio;
        String tituloLibro;
        LocalDate fechaPrestamo;
        //------------devolver libro----------
        LocalDate fechaDevolucion;
        LocalDate fechaActual = LocalDate.now();
        do{
            System.out.println("=== SISTEMA GESTIÓN BIBLIOTECA ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Realizar préstamo de libro");
            System.out.println("3. Devolver libro");
            System.out.println("4. Consultar estado de usuario");
            System.out.println("5. Mostrar préstamos activos");
            System.out.println("6. Mostrar usuarios sancionados ");
            System.out.println("7. Actualizar sanciones ");

            System.out.println("8. Salir");
            resul = in.nextInt();//insertar dato de tipo entero
            in.nextLine(); //limplia el salto de linea
            if(resul>9){
                //ERROR
            }
            else if(resul==1){
                System.out.println("Nombre: ");
                nombreUser = in.nextLine();
                in.nextLine(); //limplia el salto de linea
                System.out.println("Email: ");
                email = in.nextLine();
                System.out.println("NºSocio: ");
                numSocio = in.nextLine();
                System.out.println("Fecha Registro (aaaa/mm/dd): ");
                aux = in.nextLine();//la fecha tiene que ser de este formato: (dd/mm/aaaa)
                fechaRegistro = LocalDate.parse(aux);

                Usuario nuevoUsuario = new Usuario (nombreUser,email,numSocio,fechaRegistro);
                registro.registrarUsuario(nuevoUsuario);

                System.out.println("Usuario creado correctamente");

            }else if(resul==2){
                System.out.println("codigo del libro: ");
                codigoLibro = in.nextLine();
                System.out.println("titulo del Libro: ");
                tituloLibro = in.nextLine();

                System.out.println("Numero_Socio: ");
                aux = in.nextLine();
                socio = registro.buscarUsuario(aux);
                System.out.println("Fecha Prestamo (aaaa-mm-dd): ");
                aux = in.nextLine();//la fecha tiene que ser de este formato: (dd/mm/aaaa)
                fechaPrestamo = LocalDate.parse(aux);

                registro.realizarPrestamo(codigoLibro,socio,tituloLibro,fechaPrestamo);
                System.out.println("Prestamos creado correctamente");
            }else if(resul==3){
                System.out.println("Codigo libro: ");
                codigoLibro = in.nextLine();
                fechaDevolucion = fechaActual;
                //se puede poner directamente la fecha actual pero me parecio mas ordenado así

               registro.devolverLibro(codigoLibro,fechaDevolucion);
            }else if(resul==4){
                System.out.println("Inserta Codigo de Usuario: ");
                aux = in.nextLine();
                socio = registro.buscarUsuario(aux);

                System.out.println(socio.toString());
            }else if(resul==5){
                System.out.println(registro.toString());

            }else if(resul==6){
                System.out.println("Inserta Codigo de Usuario: ");
                aux = in.nextLine();
                socio = registro.buscarUsuario(aux);
                if(socio.estaSancionado()){
                    System.out.println("Esta sancionado");
                }else{
                    System.out.println("No esta sancionado");
                }

            }else if(resul==7){
                System.out.println("Inserta Codigo de Usuario: ");
                aux = in.nextLine();
                socio = registro.buscarUsuario(aux);

                if(LocalDate.now().isAfter(socio.getFechaFinSancion())){
                    socio.levantarSancion();
                }else{
                    System.out.println("Error"); //error
                }

            }

        }while(resul==8);

    }

}
