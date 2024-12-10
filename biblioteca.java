public class biblioteca {

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
            if (disponibilidad[i] = true) {
                estado = "Disponible";
            }else {
                estado = "Prestado";
            }
            System.out.println(" - " + titulos[i] + " | " + autores[i]+ " | " + estado);
        }
    }
    public static void main (String[] args){
        añadir_libros();
        listado_libros();
    }
}
