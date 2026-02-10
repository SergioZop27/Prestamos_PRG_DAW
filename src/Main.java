import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
/*
        //--------------------registro de fechas--------------------
        LocalDate reg1 = LocalDate.of(2026,2,10);

        System.out.println("--------------------USUARIOS PRUEBA---------------------");
        Usuario user1 = new Usuario("pepe","pepito@gmail.com","SOC11111", reg1);
        System.out.println(user1.toString());

        System.out.println("-------------sanciones-------------");
//        user1.sancionar();
        user1.estaSancionado();
        user1.levantarSancion();
        user1.estaSancionado();
        System.out.println("--------------------PRESTAMOS PRUEBA---------------------");
*/
        try {
            Usuario u = new Usuario("Jorge", "asddsds", "sdfdfssfd", LocalDate.now());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}