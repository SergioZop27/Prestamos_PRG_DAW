import java.time.LocalDate;

    public class GestorBiblioteca {
        private static final int MAX_USUARIOS = 50;
        private static final int MAX_PRESTAMOS = 200;
        private Usuario[] usuarios;
        private Prestamo[] prestamos;
        private int numeroUsuarios;
        private int numeroPrestamos;

        public GestorBiblioteca() {
            this.usuarios = new Usuario[50];
            this.prestamos = new Prestamo[200];
            this.numeroUsuarios = 0;
            this.numeroPrestamos = 0;
        }

        public void registrarUsuario(Usuario user) throws UsuarioRepetidoException, PrestamoInvalidoException {
            for (int i = 0; i < numeroUsuarios; i++) {
                //recorre toda la array y si el usuario ya esta metido sale un error
                if (usuarios[i].equals(user)) {
                    throw new UsuarioRepetidoException("El usuario ya esta registrado");
                }
            }
            //si el numero de usuarios es el maximo salta otro error
            if (numeroUsuarios >= MAX_USUARIOS) {
                throw new PrestamoInvalidoException("No se pueden registrar más usuarios.");
            }
            /* si todo funciona bien y no se cumple ninguna condicion de error el usuario se añade
               a la cola y se suma "uno" al contador de usuarios
            */
            usuarios[numeroUsuarios] = user;
            numeroUsuarios++;

        }


        public Prestamo realizarPrestamo(String codigoLibro, Usuario socio, String tituloLibro, LocalDate fechaPrestamo)
                throws UsuarioSancionadoException, LibroNoDisponibleException, PrestamoInvalidoException {

            //Del metodo booleano de la clase Usuario, lo utilizamos aqui, si sale true se ejecuta el error de sancion
            if (socio.estaSancionado()) {
                throw new UsuarioSancionadoException("El usuario esta sancionado");
            }
            /* si el usuario no esta sancionado recorreremos todo el array (igual q en el otro metodo)
               si el codigo libro es igual nos saltara el error de que el libro esta prestado
               (necesitamos un "get" de codigo libro)
            */
            for (int i = 0; i < numeroPrestamos; i++) {
                if (prestamos[i].getCodigoLibro().equals(codigoLibro)) {
                    throw new LibroNoDisponibleException("El libro ya esta prestado");
                }
            }

            Prestamo nuevoPrestamo;
            try {
                nuevoPrestamo = new Prestamo(codigoLibro, socio, tituloLibro, fechaPrestamo);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


            prestamos[numeroPrestamos] = nuevoPrestamo;
            numeroPrestamos++;


            return nuevoPrestamo;
        }

        public boolean devolverLibro(String codigoLibro, LocalDate fechaDevolucion) {

            for (int i = 0; i < numeroPrestamos; i++) {
                if (prestamos[i].getCodigoLibro().equals(codigoLibro)) {
                    if (fechaDevolucion.isBefore(prestamos[i].getFechaPrestamo())) {
                        throw new PrestamoInvalidoException("La fecha de devolución no puede ser anterior a la de préstamo");
                    }
                    //utilizamos metodos de la clase Prestamos
                    if (prestamos[i].estaRetrasado()) {
                        prestamos[i].getSocio().sancionar(prestamos[i].calcularDiasRetraso());
                    } else {
                        prestamos[i].registrarDevolucion(fechaDevolucion);
                        return true;
                    }

                }
            }
            return false;
        }

        public Usuario buscarUsuario(String codigoSocio) {

            for (int i = 0; i < numeroUsuarios; i++) {
                if (usuarios[i].getNumeroSocio().equals(codigoSocio)) {
                    return usuarios[i];
                }
            }
            return null;
        }

        public Prestamo[] getPrestamos() {
            return prestamos;
        }

        public int getNumeroUsuarios() {
            return numeroUsuarios;
        }

        @Override
        public String toString(){
            String resultado = "";

            for (int i = 0; i < numeroPrestamos; i++) {
                Prestamo escribe = prestamos[i];
                resultado += escribe.toString() + "\n";
            }

            for (int i = 0; i < numeroUsuarios; i++) {
                Usuario escribe = usuarios[i];
                resultado += escribe.toString() + "\n";
            }
            return "";
        }

    }