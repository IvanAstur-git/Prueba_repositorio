package com.iescamp;

public class Lista_Tareas {

    /**
     * Añade las tareas nuevas que tengas. Deben de entrar con el estado de la Tarea
     * como pendiente y añadirla a la lista de tareas.
     *
     */
    public static void nuevaTarea(String[] tareas) {
        //implementar
    }

    /**
     * Almacena las tareas que se deben realizar, implementando su estado actual.
     *
     */
    public static void listaTareas(String[] tareas, Boolean[] estadoTarea) {
        //implementar
    }

    /**
     * Debe cambiar la tarea que se decida de pendiente a completada.
     *
     */
    public static void tareaCompletada(String[] tareas, Boolean[] estadoTarea) {
        //implementar
    }

    public static void main(String[] args) {

        String[] tareas = new String[100];
        Boolean[] estadoTarea = new Boolean[100];
        int opcion;

        do {

            System.out.println("--- Menú Principal ---");
            System.out.println("1. Añadir tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Terminar");
            opcion = ConsoleReader.readInt();

            switch (opcion) {
                case 1:
                    nuevaTarea(tareas);
                    break;
                case 2:
                    listaTareas(tareas, estadoTarea);
                    break;
                case 3:
                    tareaCompletada(tareas, estadoTarea);
                    break;
                case 4:
                    System.out.println("Terminando...");
                    break;
            }

        }while (opcion != 4);
    }

}