import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        //--------------------registro de fechas--------------------
        LocalDate dia = LocalDate.of(2026,2,13); //fecha prestamo //+14 DIAS
        LocalDate fechAnte = LocalDate.of(2026,2,9);
        LocalDate fechPost = LocalDate.of(2026,2,12);//fech devolucion

        System.out.println("--------------------USUARIOS PRUEBA---------------------");
        Usuario user1 = new Usuario("pepe","pepito@gmail.com","SOC11111", dia);
//        System.out.println(user1.toString());

        System.out.println("-------------sanciones-------------");
        user1.sancionar(10);
//       System.out.println(user1.estaSancionado());
//        System.out.println(user1.toString());
        user1.levantarSancion();
//        System.out.println(user1.toString());

        //        try {
//            Usuario u = new Usuario("Jorge", "asddsds", "sdfdfssfd", LocalDate.now());
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        System.out.println("--------------------PRESTAMOS PRUEBA---------------------");
        Prestamo prestamoPepe = new Prestamo("ABC1234",user1 ,"Pepito el libro",dia);
        prestamoPepe.registrarDevolucion(fechPost);
        System.out.println(prestamoPepe.estaRetrasado());












    }
}