import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String email;
    private String numeroSocio; // formato: "SOC" + 5 dígitos, ejemplo: SOC00123
    private LocalDate fechaRegistro;
    private boolean sancionado;
    private LocalDate fechaFinSancion;



    public Usuario(String nombre, String email,String numeroSocio,LocalDate fechaRegistro) throws UsuarioInvalidoException{

            this.nombre = nombre;
            this.fechaRegistro = fechaRegistro;

            //formatos de email(debe contener "@" y ".") y socio ("SOC" + 5 dígitos)
            boolean formatoEmail = email.matches("\\w{1,}@\\w{1,}\\.\\w{1,}");
            boolean formatoSocio = numeroSocio.matches("^SOC[0-9]{5}");

            //Condicion Email
            if (formatoEmail) {
                this.email = email;
            } else {
                throw new UsuarioInvalidoException (" Email incorrecto tiene que ser este formato: *@*.*");
            }

            //Condicion Num Socio
            if (formatoSocio) {
                this.numeroSocio = numeroSocio;
            } else {
                throw new UsuarioInvalidoException("Numero de socio incorrecto tiene que ser este formato: SOC00000");
            }
    }
    public void sancionar(int diasSancion){
        this.fechaFinSancion=LocalDate.now().plusDays(diasSancion);
        this.sancionado=true;
    }
   public void levantarSancion(){
        this.sancionado=false;
        this.fechaFinSancion=null;
   }
   public boolean estaSancionado(){
        return sancionado;
   }

   @Override
   public String toString(){
        return "Nombre: "+nombre+"\n"+
                "Email: " +email+"\n"+
                "Num Socio: " +numeroSocio+"\n"+
                "fech Registro: "+fechaRegistro+"\n"+
                "sancionado: "+sancionado+"\n"+
                "fech fin sancion: "+ fechaFinSancion+"\n";
    }

}
