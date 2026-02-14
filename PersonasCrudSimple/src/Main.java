import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[20];
        Poblacion population = new Poblacion(personas);
        Scanner sc = new Scanner(System.in);


        int choice = -1;
        int id;
        String name;
        do {
            printMenu();
            choice = getIntInRange(sc, "Opción: ", 1, 5);
            switch (choice){
                case 1:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20);
                    name = getValidText(sc, "Introduce el nombre: ");
                    population.addPersona(id, name);
                    break;
                case 2:
                    Persona persona = population.getPersonaById(getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20));
                    if (persona != null){
                        persona.printInfo();
                    }
                    else {
                        System.out.println("Ese ID no existe o se encuentra desactivado.");
                    }
                    break;
                case 3:
                    if (population.deactivatePersona(getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20))){
                        System.out.println("ID desactivado correctamente.");
                    }
                    else {
                        System.out.println("Imposible desactivar ID, no existe o ya se encuentra desactivado.");
                    }
                    break;
                case 4:
                    population.printActivePersonas();
                    break;
                case 5:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20);
                    name = getValidText(sc, "Introduce el nuevo nombre: ");
                    if (population.updatePersonaName(id, name)){
                        System.out.println("Nombre actualizado correctamente");
                    }
                    else{
                        System.out.println("Imposible actualizar nombre, ID no existe o se encuentra desactivado");
                    }
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
