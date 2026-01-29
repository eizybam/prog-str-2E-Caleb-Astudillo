import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 7;
        int secretNumber = random.nextInt(max) + min;
        int userGuess = min - 1;
        int[] counters = new int[2]; //counters[0] -> no enteros, counters[1] -> fuera de rango
        boolean userHasWon;

        System.out.println("-- ADIVINA EL NÚMERO SECRETO --");
        for (int i = 0; i<maxAttempts; i++){
            userGuess = getUserGuess(min, max, sc, "Intento " + (i+1) + " : ", counters);
            userHasWon = userGuess == secretNumber;

            if (!userHasWon){
                if (i == maxAttempts-1){
                    System.out.println("Has perdido :( ! el número secreto era: " + secretNumber);
                }
                else if (userGuess < secretNumber){
                    System.out.println("El número secreto es mayor");
                }
                else{
                    System.out.println("El número secreto es menor");
                }
            }
            else {
                System.out.println("Felicidades! GANASTE!");
                break;
            }
        }
        System.out.printf("Entradas no númericas introducidas -> %d %nEntradas fuera del rango introducidas -> %d", counters[0], counters[1]);
    }

    /**
     * Obtiene el intento del usuario asegurándose de que es un entero dentro del rango especificado.
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @param sc -> Scanner definido en main
     * @param message -> El mensaje a imprimir
     * @param counters ->Un array de dos enteros para contar entradas no válidas: [0] para no enteros, [1] para fuera de rango.
     * @return int -> El entero válido introducido por el usuario
     */
    public static int getUserGuess(int min, int max, Scanner sc, String message, int[] counters){
        boolean isValid = false;
        int value = 0;
        System.out.print(message);
        while (!isValid){
            if (!sc.hasNextInt() ){
                System.out.print("Tu entrada no es un entero válido, introduce otro: ");
                sc.nextLine();
                counters[0]++;
            }
            else if ((value = sc.nextInt())  < min || value > max){
                System.out.print("Tu número está fuera del rango, introduce otro del " + min + " al " + max + " : ");
                sc.nextLine();
                counters[1]++;
            }
            else {
                isValid = true;
                sc.nextLine();
            }
        }
        return value;
    }
}
