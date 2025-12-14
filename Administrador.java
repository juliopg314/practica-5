package modulos;

public class Administrador extends Usuario {


    public Administrador(String Nombre, String Correo) {
        // Se llama al constructor de Usuario(Nombre, Correo, Rol)
        // con el Rol "Administrador"
        super(Nombre, Correo, "Administrador");
    }

    @Override
    public void mostrarMenu() {
        System.out.println("Menú del Administrador"); [cite: 78]
        System.out.println("1. Registrar un nuevo Usuario"); [cite: 79]
        System.out.println("2. Eliminar un usuario"); [cite: 80]
        System.out.println("3. Ver Lista de Usuarios"); [cite: 81]
        System.out.println("4. Ver Lista de Tareas"); [cite: 82]
        System.out.println("5. Crear nueva Tarea"); [cite: 83]
        System.out.println(" 6. Salir"); [cite: 83]
    }
}