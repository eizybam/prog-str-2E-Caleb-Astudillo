import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[20];
        Personas population = new Personas(personas);
        Scanner sc = new Scanner(System.in);

        printMenu();
        int choice = -1;
        do {
            choice = getIntInRange(sc, "Opción: ", 1, 5);
            switch (choice){
                case 1:
                    int id = getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20);
                    String name = getValidText(sc, "Introduce el nombre: ");
                    population.addPersona(id, name);
                    break;
                case 4:
                    population.printActivePersonas();
                    break;
            }
        } while (choice != 0);
    }

    public static void printMenu(){
        System.out.println("[1] Alta");
        System.out.println("[2] Buscar por ID (solo activas)");
        System.out.println("[3] Baja lógica por ID");
        System.out.println("[4] Listar activas");
        System.out.println("[5] Actualizar nombre por ID");
        System.out.println("[0] Salir");
    }

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
    public static String getValidText(Scanner sc, String msg){
        System.out.print(msg);
        String input = sc.nextLine();
        while (input.trim().isEmpty()){
            System.out.print("Introduce un texto válido: ");
            input = sc.nextLine();
        }
        return input;
    }

}
