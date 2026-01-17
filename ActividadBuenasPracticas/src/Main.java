import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("----- Suma de 1 hasta n -----");
        int inputN = getInt(sc, "Introduce n: ");
        int result = sumUpToN(inputN);

        System.out.println("Suma de 1 hasta " + inputN + " es: " + result);

    }

    /**
     * Valida el input del usuario para asegurarse de que es un número entero
     * @param sc -> Scanner definido en main
     * @param message -> Mensaje a imprimir
     * @return int -> Input del usuario limpio de errores
     */
    public static int getInt(Scanner sc, String message){
        System.out.print(message);
        while (!sc.hasNextInt()){
            System.out.print("Introduce un número entero válido: ");
            sc.next();
        }
        return sc.nextInt();
    }

    /**
     * Suma los números desde 1 a n
     * @param n -> Límite de la suma
     * @return -> Resultado de la suma
     */
    public static int sumUpToN(int n){
        int sum = 0;
        for (int i = 1; i<= n; i++){
            sum += i;
        }

        return sum;
    }

}