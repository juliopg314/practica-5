package modulos;

public class Empleado extends Usuario {


    public Empleado(String Nombre, String Correo) {
        // Se llama al constructor de Usuario(Nombre, Correo, Rol)
        // con el Rol "Empleado"
        super(Nombre, Correo, "Empleado");
    }


    @Override
    public void mostrarMenu() {
        System.out.println("Menú del Empleado"); [cite: 93]
        System.out.println(" 1. Ver lista de tareas"); [cite: 93]
        System.out.println("2. Finalizar una tarea"); [cite: 94]
        System.out.println(" 6. Salir"); [cite: 94]
    }
}