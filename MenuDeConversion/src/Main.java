import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int minMenuOption = 1;
        int maxMenuOption = 5;
        int choice;
        int counterCelsiusCv = 0, counterFahrenheitCv = 0, counterKmCv = 0, counterMilesCv = 0;

        Scanner sc = new Scanner(System.in);
        do {
            printMenu();
            choice = getValidValue(minMenuOption, maxMenuOption, sc, "Introduce tu opción: ");

            double celsius, fahrenheit, km, miles;
            switch (choice){
                case 1:
                    celsius = getValidValue(sc,"Celsius: ");
                    fahrenheit = celsiusToFahrenheit(celsius);
                    counterCelsiusCv++;
                    System.out.println("°C " + celsius + " = °F " + fahrenheit);
                    break;
                case 2:
                    fahrenheit = getValidValue(sc,"Fahrenheit: ");
                    celsius = fahrenheitToCelsius(fahrenheit);
                    System.out.println("°F " + fahrenheit + " = °C " + celsius);
                    counterFahrenheitCv++;
                    break;
                case 3:
                    km = getValidValue(sc,"Kilómetros: ");
                    miles = kmToMiles(km);
                    System.out.println(km + " km = " + miles + " millas");
                    counterKmCv++;
                    break;
                case 4:
                    miles = getValidValue(sc,"Millas: ");
                    km = milesToKm(miles);
                    System.out.println(miles + " millas = " + km + " km");
                    counterMilesCv++;
                    break;
                case 5:
                    System.out.println("--- RESUMEN: " + (counterCelsiusCv + counterFahrenheitCv + counterKmCv + counterMilesCv) + " conversiones realizadas ---");
                    System.out.println("Celsius a Fahrenheit -> " + counterCelsiusCv);
                    System.out.println("Fahrenheit a Celsius -> " + counterFahrenheitCv);
                    System.out.println("Kilómetros a Millas -> " + counterKmCv);
                    System.out.println("Millas a Kilómetros -> " + counterMilesCv);
                    System.out.println("Saliendo...");
                    break;
            }
        }
        while (choice != 5);
    }

    /**
     * Imprime el menú principal
     */
    public static void printMenu(){
        System.out.println("\n1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    /**
     * Valida la entrada del usuario para asegurarse de que es un entero dentro de un rango específico
     * @param min -> Primera opción disponible
     * @param max -> Última opción disponible
     * @param sc -> Scanner definido en Main
     * @param message -> Mensaje a imprimir
     * @return int -> Entero ingresado por el usuario, limpio de errores
     */
    public static int getValidValue(int min, int max, Scanner sc, String message){
        int value;
        System.out.print(message);
        while (!sc.hasNextInt() || (value = sc.nextInt()) < min || value > max) {
            System.out.print("No es entero o está fuera del rango, pon uno válido: ");
            sc.nextLine();
        }
        sc.nextLine();
        return value;
    }

    /**
     * Valida la entrada del usuario para asegurarse de que es un double
     * @param sc -> Scanner definido en Main
     * @param message -> Mensaje a imprimir en consola
     * @return double -> Double ingresado por el usuario, limpio de errores
     */
    public static double getValidValue(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.print("Introduce un número válido: ");
            sc.nextLine();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

    /**
     * Convierte Celsius a Fahrenheit
     * @param celsius -> Temperatura en Celsius
     * @return double -> Temperatura en Fahrenheit
     */
    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 1.8) + 32;
    }

    /**
     * Convierte Fahrenheit a Celsius
     * @param fahrenheit -> Temperatura en Fahrenheit
     * @return double -> Temperatura en Celsius
     */
    public static double fahrenheitToCelsius(double fahrenheit){
        return ((fahrenheit - 32) / 1.8);
    }

    /**
     * Convierte Kilómetros a Millas
     * @param kilometers -> Distancia en Kilómetros
     * @return double -> Distancia en Millas
     */
    public static double kmToMiles(double kilometers){
        return kilometers*0.62137;
    }

    /**
     * Convierte Millas a Kilómetros
     * @param miles -> Distancia en Millas
     * @return double -> Distancia en Kilómetros
     */
    public static double milesToKm(double miles){
        return miles*1.609344;
    }

}
