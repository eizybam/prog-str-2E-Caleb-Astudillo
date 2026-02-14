import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Persona[] personas = new Persona[20];
        Poblacion population = new Poblacion(personas);
        PersonaService service = new PersonaService(population);
        Scanner sc = new Scanner(System.in);


        int choice = -1;
        int id;
        String name;
        do {
            printMenu();
            choice = getIntInRange(sc, "Opción: ", 1, 6);
            switch (choice){
                case 1:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20);
                    name = getValidText(sc, "Introduce el nombre: ");
                    PersonaService.AddResult addResult = service.addPersona(id, name);
                    if (addResult == PersonaService.AddResult.SUCCESS) {
                        System.out.println("ÉXITO: Persona añadida");
                    }
                    else if (addResult == PersonaService.AddResult.DUPLICATE_ID) {
                        System.out.println("ERROR: ID ya existe");
                    }
                    else {
                        System.out.println("ERROR: Imposible añadir, causa: Población llena");
                    }
                    break;
                case 2:
                    Persona persona = service.findActiveById(getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20));
                    if (persona != null){
                        persona.printInfo();
                    }
                    else {
                        System.out.println("Ese ID no existe o se encuentra desactivado.");
                    }
                    break;
                case 3:
                    if (service.deactivateById(getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20))){
                        System.out.println("ID desactivado correctamente.");
                    }
                    else {
                        System.out.println("Imposible desactivar ID, no existe o ya se encuentra desactivado.");
                    }
                    break;
                case 4:
                    Persona[] active = service.getActivePersonas();
                    if (active.length == 0) {
                        System.out.println("No hay personas activas.");
                    }
                    else {
                        System.out.println("Lista de personas activas:");
                        for (Persona activePersona : active) {
                            activePersona.printInfo();
                        }
                    }
                    break;
                case 5:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", 1, 20);
                    name = getValidText(sc, "Introduce el nuevo nombre: ");
                    if (service.renameById(id, name)){
                        System.out.println("Nombre actualizado correctamente");
                    }
                    else{
                        System.out.println("Imposible actualizar nombre, ID no existe o se encuentra desactivado");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (choice != 6);
    }

    /**
     * Imprime el menú principal
     */
    public static void printMenu(){
        System.out.println("[1] Alta");
        System.out.println("[2] Buscar por ID (solo activas)");
        System.out.println("[3] Baja lógica por ID");
        System.out.println("[4] Listar activas");
        System.out.println("[5] Actualizar nombre por ID");
        System.out.println("[0] Salir");
    }

    /**
     * Valida la entrada del usuario para asegurarse de que es un entero dentro de un rango específico
     * @param sc -> Scanner definido en Main
     * @param msg -> Mensaje a imprimir en consola
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @return int -> Entero ingresado por el usuario, limpio de errores
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
     * Valida la entrada del usuario para asegurarse de que es un texto no vacío
     * @param sc -> Scanner definido en Main
     * @param msg -> Mensaje a imprimir en consola
     * @return String -> Texto ingresado por el usuario, limpio de errores
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

}
