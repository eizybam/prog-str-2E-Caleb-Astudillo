import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[25];
        Poblacion population = new Poblacion(alumnos);
        PoblacionService service = new PoblacionService(population);
        Scanner sc = new Scanner(System.in);
        final int MIN_ID = 1;
        final int MAX_ID = alumnos.length;
        final int MIN_AVERAGE = 0;
        final int MAX_AVERAGE = 10;


        int choice;
        int id;
        double average;
        String name;
        Alumno[] active;
        do {
            printMenu();
            choice = getIntInRange(sc, "Opción: ", 0, 6);
            switch (choice){
                case 1:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", MIN_ID, MAX_ID);
                    name = getValidText(sc, "Introduce el nombre: ");
                    average = getDoubleInRange(sc, "Introduce el promedio (0-10): ", MIN_AVERAGE, MAX_AVERAGE);
                    PoblacionService.AddResult addResult = service.addAlumno(id, name, average);
                    if (addResult == PoblacionService.AddResult.SUCCESS) {
                        System.out.println("ÉXITO: Alumno añadido");
                    }
                    else if (addResult == PoblacionService.AddResult.DUPLICATE_ID) {
                        System.out.println("ERROR: ID ya existe");
                    }
                    else {
                        System.out.println("ERROR: Imposible añadir, causa: Población llena");
                    }
                    break;
                case 2:
                    Alumno alumno = service.findActiveById(getIntInRange(sc, "Introduce el ID (1-20): ", MIN_ID, MAX_ID));
                    if (alumno != null){
                        alumno.printInfo();
                    }
                    else {
                        System.out.println("Ese ID no existe o se encuentra desactivado.");
                    }
                    break;
                case 3:
                    id = getIntInRange(sc, "Introduce el ID (1-20): ", MIN_ID, MAX_ID);
                    average = getDoubleInRange(sc, "Introduce el nuevo promedio: ", MIN_AVERAGE, MAX_AVERAGE);
                    if (service.changeAverage(id, average)){
                        System.out.println("Promedio actualizado correctamente");
                    }
                    else{
                        System.out.println("Imposible actualizar promedio, ID no existe o se encuentra desactivado");
                    }
                    break;
                case 4:
                    if (service.deactivateById(getIntInRange(sc, "Introduce el ID (1-20): ", MIN_ID, MAX_ID))){
                        System.out.println("ID desactivado correctamente.");
                    }
                    else {
                        System.out.println("Imposible desactivar ID, no existe o ya se encuentra desactivado.");
                    }
                    break;
                case 5:
                    active = service.getActiveAlumnos();
                    if (active.length == 0) {
                        System.out.println("No hay alumnos activos.");
                    }
                    else {
                        System.out.println("Lista de alumnos activos:");
                        for (Alumno activeAlumno : active) {
                            activeAlumno.printInfo();
                        }
                    }
                    break;
                case 6:
                    active = service.getActiveAlumnos();
                    service.printReport(active);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (choice != 0);
    }

    /**
     * Imprime el menú principal
     */
    public static void printMenu(){
        System.out.println("[1] Alta alumno");
        System.out.println("[2] Buscar por ID (solo activos)");
        System.out.println("[3] Actualizar promedio por ID");
        System.out.println("[4] Baja lógica por ID");
        System.out.println("[5] Listar alumnos activos");
        System.out.println("[6] Reportes");
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

    public static double getDoubleInRange(Scanner sc, String msg, double min, double max){
        double value;
        System.out.print(msg);
        while (!sc.hasNextDouble() || (value = sc.nextDouble()) < min || value > max){
            System.out.print("No es un número válido o está fuera del rango, pon otro (0-10): ");
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
