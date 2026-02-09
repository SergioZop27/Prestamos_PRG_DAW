import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String email; //debe contener "@" y "."
    private String numeroSocio; // formato: "SOC" + 5 dígitos, ejemplo: SOC00123
    private LocalDate fechaRegistro;
    private boolean sancionado;
    private LocalDate fechaFinSancion;



    public Usuario(String nombre, String email,String numeroSocio,LocalDate fechaRegistro){
        this.nombre=nombre;
        this.fechaRegistro=fechaRegistro;

        boolean formatoEmail = email.matches("\\w{1,}@\\w{1,}\\.\\w{1,}");
        boolean formatoSocio = numeroSocio.matches("^SOC[0-9]{5}");

        //Condicion Email
        if(formatoEmail) {
            this.email=email;
        }else{
            //incorrecto excepción de tipo UsuarioInvalidoException COMPLETAR
        }

        //Condicion Num Socio
        if(formatoSocio) {
            this.numeroSocio=numeroSocio;
        }else{
            //incorrecto excepción de tipo UsuarioInvalidoException COMPLETAR
        }

    }

//    public void sancionar(){
//        this.fechaFinSancion
//        LocalDate.now();
//
//    }


}
