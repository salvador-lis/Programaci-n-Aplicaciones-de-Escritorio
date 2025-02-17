import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.printf("Ingresa un numero: ");
        int n = input.nextInt();
        
        try {
            parImpar(n);
        } catch (NumeroImparException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Gracias, Adios");
        }
    }

    public static void parImpar(int a) throws NumeroImparException {
        if (a % 2 != 0) {
            
            throw new NumeroImparException("Error: Ingresaste un número impar");
        } else {
            
            System.out.println(a + " es un número par");
        }
    }
}


class NumeroImparException extends Exception {
    public NumeroImparException(String message) {
        super(message);
    }
}

