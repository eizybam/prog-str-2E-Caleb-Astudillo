import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] grades = new double[3];

        String name = getValidText(sc, "Introduce el nombre: ");

        int counter = 0;
        while (counter < 3){
            grades[counter] = getDoubleInRange(sc, "Introduce la calificación " + (counter + 1) + " (0 - 100): ", 0, 100);
            counter++;
        }
        int attendance = getIntInRange(sc, "Introduce el porcentaje de asistencia (0-100): ", 0, 100);
        boolean finalProjectIsApproved = readBoolean(sc, "¿Entregó el proyecto final? (true/false): ");

        GradeService gradeservice = new GradeService(name, grades, attendance, finalProjectIsApproved);
        gradeservice.setState();
        gradeservice.printReport();
    }

    /**
     * Lee un texto, se asegura que no esté vacío y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @return String -> El texto válido introducido por el usuario
     */
    public static String getValidText(Scanner sc, String msg){
        System.out.print(msg);
        String input = sc.nextLine();
        while (input.trim().isEmpty()){
            System.out.print("Introduce un texto válido: ");
            input = sc.nextLine();
        }
        return input;
    }

    /**
     * Lee un dato double, lo limpia de errores y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @return double -> El double válido introducido por el usuario
     */
    public static double getDoubleInRange(Scanner sc, String msg, double min, double max){
        double value;
        System.out.print(msg);
        while (!sc.hasNextDouble() || (value = sc.nextDouble()) < min || value > max) {
            System.out.print("No es double válido o está fuera del rango, pon otro: ");
            sc.nextLine();
        }
        sc.nextLine();
        return value;
    }

    /**
     * Lee un dato int, lo limpia de errores y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @return int -> El int válido introducido por el usuario
     */
    public static int getIntInRange(Scanner sc, String msg, int min, int max){
        int value;
        System.out.print(msg);
        while (!sc.hasNextInt() || (value = sc.nextInt()) < min || value > max) {
            System.out.print("No es entero válido o está fuera del rango, pon otro: ");
            sc.nextLine();
        }
        sc.nextLine();
        return value;
    }

    /**
     * Lee un dato boolean, lo limpia de errores y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @return boolean -> El boolean válido introducido por el usuario
     */
    public static boolean readBoolean(Scanner sc, String msg){
        System.out.print(msg);
        while (!sc.hasNextBoolean()){
            System.out.println("Ingresa solo 'true' o 'false': ");
            sc.nextLine();
        }
        return sc.nextBoolean();
    }

}
