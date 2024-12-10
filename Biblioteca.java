
public class Biblioteca {

    public static void buscar_titulo(String[] titulos, String[] autores, boolean[] disponible) {
        System.out.println("Titulo del libro que quieres buscar");
        String titulo = ConsoleReader.readString();

        for (int i = 0; i < titulos.length; i++) {
            if (titulos[i].equalsIgnoreCase(titulo)) {
                System.out.printf("Título: %s\nAutor: %s\nDisponible: %s\n",
                                titulos[i], autores[i], disponible[i] ? "Disponible" : "Prestado");
                return;
            }
        }

        System.out.println("Título no encontrado, no está ese libro.");
    }

    public static void buscar_autor(String[] titulos, String[] autores) {
        System.out.println("Nombre del autor que quieres buscar:");
        String autor = ConsoleReader.readString();
        boolean encontrado = false;

        for (int i = 0; i < autores.length; i++) {
            if (autores[i].equalsIgnoreCase(autor)) {
                System.out.printf("Título: %s\n", titulos[i]);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron libros de ese autor.");
        }
    }

    public static void main(String[] args) {
        String[] titulos = {
                "Harry Potter y la piedra filosofal",
                "Harry Potter y el caliz de fuego",
                "Percy Jackson:  El ladron del rayo",
                "El señor de los anillos: La comunidad del anillo",
                "El señor de los anillos: El retorno del rey"
        };

        String[] autores = {
                "J.K. Rowling",
                "J.K. Rowling",
                "Rick Riordan",
                "J.R.R. Tolkien",
                "J.R.R. Tolkien"
        };

        boolean[] disponible = {
                true,
                true,
                true,
                true,
                true,
        };

        buscar_titulo(titulos, autores, disponible);
        buscar_autor(titulos, autores);
    }
}