import java.time.LocalDate;

public class Prestamo {
    private String codigoLibro;
    private String tituloLibro;
    private Usuario socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LocalDate fechaDevolucionReal; //(null si aún no se ha devuelto el libro)

    public Prestamo(String codigoLibro,Usuario socio ,String tituloLibro,LocalDate fechaPrestamo )throws Exception{
            this.socio=socio;
            this.tituloLibro=tituloLibro;
            this.fechaPrestamo=fechaPrestamo;

            //formato codigo (3 letras mayúsculas + 4 dígitos)
            boolean formatoCodigo = codigoLibro.matches("[A-Z]{3}[0-9]{4}");

            //Condicion codigo
            if(formatoCodigo) {
                this.codigoLibro = codigoLibro;
            }else{
                throw new Exception("El codigo esta mal escrito el formato es: 3 mayusculas y 4 digitos");
            }
    }






}
