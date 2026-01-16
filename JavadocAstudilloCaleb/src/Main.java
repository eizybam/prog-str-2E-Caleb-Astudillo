import java.util.Scanner;

public class Main {
    static final double PI  = 3.14159;
    public static void main (String[] args){
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            printMenu();
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    double imc = calculateIMC(sc);
                    printResult("El IMC es:", imc);
                    break;
                case 2:
                    double rectangleArea = calculateRectangleArea(sc);
                    printResult("El área del rectángulo es: ", rectangleArea);
                    break;
                case 3:
                    double fahrenheit = celsiusToFahrenheit(sc);
                    printResult("Equivalente en Fahrenheit: ", fahrenheit);
                    break;
                case 4:
                    double circleArea = calculateCircleArea(sc);
                    printResult("El área del círculo es: ", circleArea);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("No es un número válido");
            }

        } while (choice != 5);
        sc.close();
    }

    /**
     * Valida la entrada del usuario para asegurarse de que es un double
     * @param sc -> Scanner definido en Main
     * @param message -> Mensaje a imprimir en consola
     * @return double -> Double ingresado por el usuario, limpio de errores
     */
    public static double getDouble(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextDouble()){
            System.out.print("Introduce un número válido: ");
            sc.next();
        }

        return sc.nextDouble();
    }

    /**
     * Imprime el menú principal
     */
    public static void printMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. Calcular IMC");
        System.out.println("2. Calcular Área de Rectángulo");
        System.out.println("3. Convertir Celsius a Fahrenheit");
        System.out.println("4. Calcular Área de Círculo");
        System.out.println("5. Salir");
        System.out.print("Introduce tu opción: ");
    }

    /**
     * Imprime el mensaje y resultado formateados para mejor legibilidad
     * @param message -> Mensaje a imprimir antes del resultado
     * @param result -> Double formateado a 2 decimales
     */
    public static void printResult(String message, double result) {
        System.out.printf("%s %.2f%n", message, result);
    }

    /**
     * Calcula el IMC
     * @param sc -> Scanner definido en Main
     * @return double -> IMC calculado
     */
    public static double calculateIMC(Scanner sc){
        double weight = getDouble(sc, "Introduce el peso en Kilogramos: ");
        double height = getDouble(sc, "Introduce la altura en centímetros: ");

        return (weight / ((height/100)*(height/100)));
    }

    /**
     * Calcula el área de un rectángulo
     * @param sc -> Scanner definido en Main
     * @return double -> Área calculada con la fórmula: b*h
     */
    public static double calculateRectangleArea(Scanner sc){
        double b = getDouble(sc, "Introduce la base: ");
        double h = getDouble(sc, "Introduce la altura: ");
        return b*h;
    }

    /**
     * Convierte Celsius a Fahrenheit
     * @param sc -> Scanner definido en Main
     * @return double -> Temperatura en Fahrenheit calculada con la fórmula: (C*1.8) + 32
     */
    public static double celsiusToFahrenheit(Scanner sc){
        double celsius = getDouble(sc, "Ingresa la temperatura en Celsius: ");
        return ((celsius*1.8) + 32);
    }

    /**
     * Calcula el área de un círculo
     * @param sc -> Scanner definido en Main
     * @return double -> Área calculada con la fórmula: π*r^2
     */
    public static double calculateCircleArea(Scanner sc){
        double r = getDouble(sc,"Introduce el radio: ");
        return (PI * (r*r));
    }

}
