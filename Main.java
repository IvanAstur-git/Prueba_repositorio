import java.util.Scanner;
public class Main {

    static String[] titulos = new String[10];
    static String[] autores = new String[10];
    static Boolean[] disponibilidad = new Boolean[10];
    static int listaLibros = 0;
    static String estado;

    public static void añadir_libros(){
        System.out.println("Escribe el titulo del libro: ");
        String titulo = ConsoleReader.readString();
        System.out.println("Escribe el autor del libro: ");
        String autor = ConsoleReader.readString();

        titulos[listaLibros] = titulo;
        autores[listaLibros] = autor;
        disponibilidad[listaLibros] = true;
        listaLibros++;
        System.out.println("Se ha añadido el libro correctamente");
    }

    public static void listado_libros(){
        System.out.println("Listado de libros : ");
        if (listaLibros == 0 ){
            System.out.println("No hay ningun libro. ");
        }

        for (int i=0; i < listaLibros; i++){
            if (disponibilidad[i]) {
                estado = "Disponible";
            }else {
                estado = "Prestado";
            }
            System.out.println(" - " + titulos[i] + " | " + autores[i]+ " | " + estado);
        }
    }

    public static void buscar_titulo(String[] listado_libros) {
        System.out.println("Titulo del libro que quieres buscar");
        String titulo = ConsoleReader.readString();
        for (int i = 0; i < titulos.length; i++) {
            if (titulo.equalsIgnoreCase(titulos[i])) {
                System.out.printf("Título: %s\nAutor: %s\nDisponible: %s\n",
                        titulos[i], autores[i], disponibilidad[i] ? "Disponible" : "Prestado");
                return;
            }
        }

        System.out.println("Título no encontrado, no está ese libro.");
    }

    public static void buscar_autor(String[] listado_libros) {
        System.out.println("Nombre del autor que quieres buscar:");
        String autor = ConsoleReader.readString();
        boolean encontrado = false;

        for (int i = 0; i < autores.length; i++) {
            if (autor.equalsIgnoreCase(autores[i])) {
                System.out.printf("Título: %s\n", titulos[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros de ese autor.");
        }
    }


    // Función para registrar un préstamo
    public static boolean prestamo() {
        System.out.println("Qué posición quieres prestar");
        int posicion = ConsoleReader.readInt();
        if (posicion >= 0 && posicion < titulos.length) {
            if (disponibilidad[posicion]) {
                disponibilidad[posicion] = false; // Cambia a "prestado"
                System.out.println("El libro '" + titulos[posicion] + "' ha sido prestado.");
                return true; // Retorna true si la operación es exitosa
            } else {
                System.out.println("El libro '" + titulos[posicion] + "' ya está prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
        return false; // Retorna false si la operación falla
    }

    // Función para registrar una devolución
    public static boolean devolucion() {
        System.out.println("Qué posición quieres devolver");
        int posicion = ConsoleReader.readInt();
        if (posicion >= 0 && posicion < titulos.length) {
            if (!disponibilidad[posicion]) {
                disponibilidad[posicion] = true; // Cambia a "disponible"
                System.out.println("El libro '" + titulos[posicion] + "' ha sido retornado.");
                return true;
            } else {
                System.out.println("El libro '" + titulos[posicion] + "' ya está disponible.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
        return false;
    }

    public static void main(String[] args) {

        int opcion;
        do {
            System.out.println("--- Menú Principal ---");
            System.out.println("1. Añadir libro");
            System.out.println("2. Listar libro");
            System.out.println("3. Buscar libros por título");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Registrar prestamo");
            System.out.println("6. Registrar devolución");
            System.out.println("7. Salir");
            opcion = ConsoleReader.readInt();

            switch (opcion) {
                case 1:
                    añadir_libros();
                    break;
                case 2:
                    listado_libros();
                    break;
                case 3:
                    buscar_titulo(titulos);
                    break;
                case 4:
                    buscar_autor(autores);
                    break;
                case 5:
                    prestamo();
                    break;
                case 6:
                    devolucion();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(opcion != 7);

    }
}
