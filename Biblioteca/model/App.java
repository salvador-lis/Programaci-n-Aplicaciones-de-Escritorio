package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static int contadorPrestamos = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarDatos();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1 -> mostrarLibros();
                case 2 -> mostrarUsuarios();
                case 3 -> realizarPrestamo(scanner);
                case 4 -> devolverLibro(scanner);
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        scanner.close();
    }

    private static void inicializarDatos() {
        libros.add(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo Mágico"));
        libros.add(new Libro(2, "1984", "George Orwell", 1949, "Distopía"));

        usuarios.add(new Usuario(1, "Juan Pérez", "juan@gmail.com", "123456789"));
        usuarios.add(new Usuario(2, "Ana Gómez", "ana@gmail.com", "987654321"));
    }

    private static void mostrarMenu() {
        System.out.println("""
            \n--- MENÚ ---
            1. Mostrar libros
            2. Mostrar usuarios
            3. Realizar préstamo
            4. Devolver libro
            0. Salir
            Ingrese una opción:""");
    }

    private static void mostrarLibros() {
        System.out.println("\nLista de libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("\nLista de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void realizarPrestamo(Scanner scanner) {
        System.out.print("Ingrese ID del usuario: ");
        int idUsuario = scanner.nextInt();
        System.out.print("Ingrese ID del libro: ");
        int idLibro = scanner.nextInt();

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Libro libro = buscarLibroPorId(idLibro);

        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }

        if (!libro.isDisponible()) {
            System.out.println("El libro no está disponible.");
            return;
        }

        Prestamo prestamo = new Prestamo(contadorPrestamos++, idLibro, idUsuario, new Date(), null, false);
        prestamos.add(prestamo);
        libro.setDisponible(false);
        System.out.println("Préstamo realizado con éxito.");
    }

    private static void devolverLibro(Scanner scanner) {
        System.out.print("Ingrese ID del préstamo: ");
        int idPrestamo = scanner.nextInt();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getId() == idPrestamo && !prestamo.isDevuelto()) {
                prestamo.setDevuelto(true);
                Libro libro = buscarLibroPorId(prestamo.getIdLibro());
                if (libro != null) {
                    libro.setDisponible(true);
                }
                System.out.println("Libro devuelto con éxito.");
                return;
            }
        }
        System.out.println("Préstamo no encontrado o ya devuelto.");
    }

    private static Libro buscarLibroPorId(int id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    private static Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
