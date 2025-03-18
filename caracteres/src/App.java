import java.io.*;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java CountFileStats <nombre_archivo>");
            return;
        }

        String nombreArchivo = args[0];
        int numCaracteres = 0, numPalabras = 0, numLineas = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                numLineas++;
                numCaracteres += linea.length();
                numPalabras += linea.trim().isEmpty() ? 0 : linea.trim().split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        System.out.println("El archivo tiene:");
        System.out.println(numCaracteres + " caracteres");
        System.out.println(numPalabras + " palabras");
        System.out.println(numLineas + " líneas");
    }
}
