public class Biblioteca {

    private static String[] titulos = new String[10];
    private static String[] autores = new String[10];
    private static boolean[] disponibilidad = new boolean[10];

    // Función para registrar un préstamo
    public static boolean prestamo(int index) {
        if (index >= 0 && index < titulos.length) {
            if (disponibilidad[index]) {
                disponibilidad[index] = false; // Cambia a "prestado"
                System.out.println("El libro '" + titulos[index] + "' ha sido prestado.");
                return true; // Retorna true si la operación es exitosa
            } else {
                System.out.println("El libro '" + titulos[index] + "' ya está prestado.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
        return false; // Retorna false si la operación falla
    }

    // Función para registrar una devolución
    public static boolean devolucion(int index) {
        if (index >= 0 && index < titulos.length) {
            if (!disponibilidad[index]) {
                disponibilidad[index] = true; // Cambia a "disponible"
                System.out.println("El libro '" + titulos[index] + "' ha sido retornado.");
                return true;
            } else {
                System.out.println("El libro '" + titulos[index] + "' ya está disponible.");
            }
        } else {
            System.out.println("Índice de libro inválido.");
        }
        return false;
    }

    public static void main(String[] args) {
        
        // Inicialización de los libros
        titulos[0] = "El Quijote";
        autores[0] = "Miguel de Cervantes";
        disponibilidad[0] = true;

        //Funciones
        prestamo(0);
        devolucion(0);
        devolucion(0);
    }
}