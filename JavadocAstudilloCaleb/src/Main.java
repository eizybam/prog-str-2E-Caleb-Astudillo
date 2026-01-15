import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            printMenu();
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    IMC(sc);
                    break;
                case 2:
                    areaRectangle(sc);
                    break;
                case 3:
                    CtoF(sc);
                    break;
                case 4:
                    areaCircle(sc);
                    break;
                default:
                    System.out.println("No es un número válido");
            }

        } while (choice != 5);
    }

    /**
     *
     * @param sc
     * @param message
     * @return
     */
    public static double getDouble(Scanner sc, String message){
        System.out.print(message);
        return sc.nextDouble();
    }
    public static void printMenu(){
        System.out.println("Menu:");
        System.out.println("1. Calcular IMC");
        System.out.println("2. Calcular Área de Rectángulo");
        System.out.println("3. Convertir Farenheit a Celsius");
        System.out.println("4. Calcular Área de Círuclo");
        System.out.println("5. Salir");
        System.out.print("Introduce tu opción: ");
    }

    public static void IMC(Scanner sc){
        double weight = getDouble(sc, "Introduce el peso en Kilogramos: ");
        double height = getDouble(sc, "Introduce la altura en centímetros: ");

        System.out.println("IMC: " + (weight / ((height/100)*(height/100))));
    }

    public static void areaRectangle(Scanner sc){
        double b = getDouble(sc, "Introduce la base");
        double h = getDouble(sc, "Introduce la altura");
        System.out.println("Área: " + (b*h));
    }

    public static void CtoF(Scanner sc){
        double c = getDouble(sc, "Ingresa la temperatura en Celsius: ");
        System.out.println("Fahrenheit: " + ((c*1.8) + 32));
    }

    public static void areaCircle(Scanner sc){
        double r = getDouble(sc,"Introduce el radio: ");
        System.out.println("Área: " + (3.14159 * (r*r)));
    }

}
