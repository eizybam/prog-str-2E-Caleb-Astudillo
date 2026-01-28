import java.util.Scanner;

public class Main {
    public static void main() {
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
                    System.out.print("°C " + celsius + " = °F " + fahrenheit);
                    break;
                case 2:
                    fahrenheit = getValidValue(sc,"Fahrenheit: ");
                    celsius = fahrenheitToCelsius(fahrenheit);
                    System.out.print("°F " + fahrenheit + " = °C " + celsius);
                    counterFahrenheitCv++;
                    break;
                case 3:
                    km = getValidValue(sc,"Kilómetros: ");
                    miles = kmToMiles(km);
                    System.out.print(km + " km = " + miles + " millas");
                    counterKmCv++;
                    break;
                case 4:
                    miles = getValidValue(sc,"Millas: ");
                    km = milesToKm(miles);
                    System.out.print(miles + " millas = " + km + " km");
                    counterMilesCv++;
                    break;
                case 5:
                    System.out.println("--- RESUMEN: " + (counterCelsiusCv + counterFahrenheitCv + counterKmCv + counterMilesCv) + " conversiones realizadas ---");
                    System.out.println("Celsius a Fahrenheit -> " + counterCelsiusCv);
                    System.out.println("Fahrenheit a Celsius -> " + counterFahrenheitCv);
                    System.out.println("Kilómetros a Millas -> " + counterKmCv);
                    System.out.println("Millas a Kilómetros -> " + counterMilesCv);
                    System.out.println("Saliendo...");
            }
        }
        while (choice != 5);
    }

    public static void printMenu(){
        System.out.println("\n1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    public static int getValidValue(int min, int max, Scanner sc, String message){
        int value;
        System.out.print(message);
        while (!sc.hasNextInt() || (value = sc.nextInt()) < min || value > max) {
            System.out.print("No es entero o está fuera del rango, pon uno válido: ");
            sc.nextLine();
        }
        return value;
    }

    public static double getValidValue(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            System.out.print("Introduce un número válido: ");
            sc.nextLine();
        }
        return sc.nextDouble();
    }


    public static double celsiusToFahrenheit(double celsius){
        return (celsius * 1.8) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit){
        return ((fahrenheit - 32) / 1.8);
    }

    public static double kmToMiles(double kilometers){
        return kilometers*0.62137;
    }

    public static double milesToKm(double miles){
        return miles*1.609344;
    }

}
