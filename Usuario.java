package modulos;

public abstract class Usuario {


    protected String Nombre;
    protected String Correo;
    protected String Rol;


    public Usuario() {

    }


    public Usuario(String Nombre, String Correo, String Rol) throws IllegalArgumentException {


        if (Nombre == null || Nombre.trim().isEmpty()) {

            throw new IllegalArgumentException("El nombre no debe estar vacío.");
        }
        if (Nombre.length() < 5) {

            throw new IllegalArgumentException("El nombre debe contener al menos 5 caracteres.");
        }


        if (Correo == null || !Correo.contains("@") || !Correo.endsWith(".com")) {

            throw new IllegalArgumentException("Formato de correo inválido. Debe contener '@' y terminar en '.com'.");
        }


        this.Nombre = Nombre;
        this.Correo = Correo;
        this.Rol = Rol;
    }


    public abstract void mostrarMenu();



    @Override
    public String toString() {
        // Formato: Nombre, Correo, Rol
        // Ejemplo: "Elena, elena@empresa.com, Administrador"
        return this.Nombre + ", " + this.Correo + ", " + this.Rol;
    }
}
