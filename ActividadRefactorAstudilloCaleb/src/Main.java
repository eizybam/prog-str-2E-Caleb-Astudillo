import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;

        int suma = sumNumbers(n, scanner);
        double promedio = getAverage(suma, n);

        System.out.println("Resultado de la suma = " + suma);
        System.out.printf("Promedio = %.2f", promedio);
    }

    /**
     * Limpia la entrada del usuario para asegurarse que introduzca un entero
     * @param message -> El mensaje a imprimir en pantalla
     * @param scanner -> Scanner definido en main
     * @return int -> El entero introducido por el usuario
     */
    public static int getInt(String message, Scanner scanner){
        System.out.print(message);
        while (!scanner.hasNextInt()){
            System.out.print("Introduce un número entero válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Efectúa una suma de n números introducidos por el usuario
     * @param n -> La cantidad de números a sumar
     * @param scanner -> Scanner definido en main
     * @return int sum -> Los números sumados entre sí
     */
    public static int sumNumbers(int n, Scanner scanner){
        int sum = 0;
        for (int i = 0; i<n; i++){
            sum = sum + getInt("Introduce el número entero " + (i+1) + ": ", scanner);
        }
        return sum;
    }

    /**
     * Calcula el promedio de una suma
     * @param sum -> El resultado de una suma
     * @param n -> La cantidad de números que se sumaron
     * @return double -> El promedio
     */
    public static double getAverage(int sum, int n){
        return (double) sum / n;
    }
}