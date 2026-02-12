import java.time.Duration;
import java.time.LocalDate;

public class Prestamo {
    private String codigoLibro;
    private String tituloLibro;
    private Usuario socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionPrevista;
    private LocalDate fechaDevolucionReal; //(null si aún no se ha devuelto el libro)

    public Prestamo(String codigoLibro,Usuario socio ,String tituloLibro,LocalDate fechaPrestamo )throws Exception{
            this.socio=socio;
            this.tituloLibro=tituloLibro;

            //formato codigo (3 letras mayúsculas + 4 dígitos)
            boolean formatoCodigo = codigoLibro.matches("[A-Z]{3}[0-9]{4}");
            //devuelve true si la fecha es posterior a la actual
            boolean condicionfecha = LocalDate.now().isAfter(fechaPrestamo);

            //Condicion codigo
            if(formatoCodigo) {
                this.codigoLibro = codigoLibro;
            }else{
                throw new PrestamoInvalidoException("El codigo esta mal escrito el formato es: 3 mayusculas y 4 digitos");
            }

            //condicion fecha
            if(condicionfecha || fechaPrestamo == null){
                throw new PrestamoInvalidoException("la fecha no puede ser posterior a la actual");
            }else{
                this.fechaPrestamo=fechaPrestamo;
                this.fechaDevolucionPrevista=fechaPrestamo.plusDays(14);
            }

    }

    public void registrarDevolucion(LocalDate fechaDevolucion){
        //devuelve true si la fecha es anterior a la actual
        boolean condicionfecha = fechaPrestamo .isBefore(fechaDevolucion);

        if(condicionfecha || fechaDevolucion == null ){
            throw new PrestamoInvalidoException("la fecha no puede ser anterior a la fecha de Prestamo");
        }else{
            this.fechaDevolucionReal=fechaDevolucion;
        }
    }


//    public int calcularDiasRetraso(){
//
//        Duration dur = Duration.between (fechaDevolucionPrevista,fechaDevolucionReal);
//
//
//    }






}
