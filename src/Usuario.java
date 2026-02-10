import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String email; //debe contener "@" y "."
    private String numeroSocio; // formato: "SOC" + 5 dígitos, ejemplo: SOC00123
    private LocalDate fechaRegistro;
    private boolean sancionado;
    private LocalDate fechaFinSancion;



    public Usuario(String nombre, String email,String numeroSocio,LocalDate fechaRegistro) throws Exception{
        try {
            this.nombre = nombre;
            this.fechaRegistro = fechaRegistro;

            boolean formatoEmail = email.matches("\\w{1,}@\\w{1,}\\.\\w{1,}");
            boolean formatoSocio = numeroSocio.matches("^SOC[0-9]{5}");

            //Condicion Email
            if (formatoEmail) {
                this.email = email;
            } else {
                throw new Exception("Email incorrecto tiene que ser este formato: *@*.*");
            }

            //Condicion Num Socio
            if (formatoSocio) {
                this.numeroSocio = numeroSocio;
            } else {
                throw new Exception("Numero de socio incorrecto tiene que ser este formato: SOC00000");
            }
        } catch (Exception UsuarioInvalidoException) {
            System.out.println("Error usuario invalido, el nombre solo puede tener letras");
       }




    }

    public void sancionar(){



    }
   public void levantarSancion(){
        this.sancionado=false;
        this.fechaFinSancion = null;
   }
   public boolean estaSancionado(){
        return sancionado;
   }

   @Override
   public String toString(){
        return "Nombre: "+nombre+
                "Email: " +email+
                "Num Socio: " +numeroSocio+
                "fech Registro: "+fechaRegistro+
                "sancionado: "+sancionado+
                "fech fin sancion: "+ fechaFinSancion;
    }

}
