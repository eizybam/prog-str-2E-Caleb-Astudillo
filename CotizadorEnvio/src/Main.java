import java.util.Scanner;

public class Main {
    static final double MINKG = 0.1, MAXKG = 50.0;
    static final int MINKM = 1, MAXKM = 2000;
    static final int MINSERVICIO = 1, MAXSERVICIO = 2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double pesoKg = leerDoubleEnRango(sc, "Introduce el peso del paquete en Kilogramos: ", MINKG, MAXKG);
        int distanciaKm = leerIntEnRango(sc, "Introduce la distancia del destino en Kilómetros: ", MINKM, MAXKM);
        int tipoServicio = leerIntEnRango(sc,"Introduce el tipo de servicio\n1 Estándar\n2 Express: ", MINSERVICIO, MAXSERVICIO);
        boolean esZonaRemota = leerBoolean(sc, "Es zona remota? Introduce 'true' o 'false': ");
    }
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
        double value;
        System.out.print(msg);
        while (!sc.hasNextDouble() || (value = sc.nextDouble()) < min || value > max) {
            System.out.print("No es double válido o está fuera del rango, pon otro: ");
            sc.nextLine();
        }
        sc.nextLine();
        return value;
    }

    public static int leerIntEnRango(Scanner sc, String msg, double min, double max){
        int value;
        System.out.print(msg);
        while (!sc.hasNextInt() || (value = sc.nextInt()) < min || value > max) {
            System.out.print("No es entero válido o está fuera del rango, pon otro: ");
            sc.nextLine();
        }
        sc.nextLine();
        return value;
    }

    public static boolean leerBoolean(Scanner sc, String msg){
        System.out.print(msg);
        while (!sc.hasNextBoolean()){
            System.out.println("Ingresa solo 'true' o 'false': ");
            sc.nextLine();
        }
        return sc.nextBoolean();
    }

    public static void imprimirTicket(){
        System.out.println("---TICKET---");
    }

}
