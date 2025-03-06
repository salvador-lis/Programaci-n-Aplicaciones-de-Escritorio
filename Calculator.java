public class Calculator {
    public static void main(String[] args) {
        try {
            // Verificar que el usuario ingrese 3 argumentos
            if (args.length != 3) {
                System.out.println("Uso: java Calculator operando1 operador operando2");
                System.exit(1);
            }

            // Convertir los operandos a enteros
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[2]);
            char operator = args[1].charAt(0);

            int result = 0;

            // Determinar la operación a realizar
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: No se puede dividir entre 0.");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Error: Operador no válido. Usa +, -, * o /.");
                    return;
            }

            // Mostrar el resultado
            System.out.println(num1 + " " + operator + " " + num2 + " = " + result);

        } catch (NumberFormatException ex) {
            System.out.println("Error: Los operandos deben ser números enteros válidos.");
        }
    }
}




