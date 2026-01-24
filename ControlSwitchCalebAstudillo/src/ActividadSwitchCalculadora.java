import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        double result, a, b;
        Scanner sc = new Scanner(System.in);

        printMenu();
        int choice = sc.nextInt();
        a = getDouble(sc, "Ingresa el 1er número: ");
        b = getDouble(sc, "Ingresa el 2do número: ");

        switch (choice) {
            case 1:
                result = a + b;
                System.out.println(a + " + " + b + " = " + result);
                break;
            case 2:
                result = a - b;
                System.out.println(a + " - " + b + " = " + result);
                break;
            case 3:
                result = a * b;
                System.out.println(a + " * " + b + " = " + result);
                break;
            case 4:
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero.");
                }
                else {
                    result = a / b;
                    System.out.println(a + " / " + b + " = " + result);
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
        sc.close();
    }

    public static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.print("Ingresa la opción deseada: ");
    }

    public static double getDouble(Scanner sc, String message){
        System.out.print(message);

        return sc.nextDouble();
    }

}
