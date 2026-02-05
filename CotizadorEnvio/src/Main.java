import java.util.Scanner;

public class Main {
    static final double MINKG = 0.1, MAXKG = 50.0;
    static final int MINKM = 1, MAXKM = 2000;
    static final int MINSERVICIO = 1, MAXSERVICIO = 2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ShippingCalculator envio = new ShippingCalculator();

        envio.pesoKg = leerDoubleEnRango(sc, "Introduce el peso del paquete en Kilogramos: ", MINKG, MAXKG);
        envio.distanciaKm = leerIntEnRango(sc, "Introduce la distancia del destino en Kilómetros: ", MINKM, MAXKM);
        envio.tipoServicio = leerIntEnRango(sc,"Introduce el tipo de servicio\n1 Estándar\n2 Express\nQuiero un servicio (1 o 2): ", MINSERVICIO, MAXSERVICIO);
        envio.zonaRemota = leerBoolean(sc, "Es zona remota? Introduce 'true' o 'false': ");

        envio.subtotal = envio.calcularSubtotal(envio.pesoKg, envio.distanciaKm, envio.tipoServicio, envio.zonaRemota);
        envio.iva = envio.calcularIVA(envio.subtotal);
        envio.total = envio.calcularTotal(envio.subtotal, envio.iva);

        imprimirTicket(envio);


    }

    /**
     * Lee un dato double, lo limpia de errores y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @return double -> El double válido introducido por el usuario
     */
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

    /**
     * Lee un dato int, lo limpia de errores y lo regresa
     * @param sc -> Scanner definido en main
     * @param msg -> El mensaje a imprimir
     * @param min -> El valor mínimo permitido
     * @param max -> El valor máximo permitido
     * @return int -> El int válido introducido por el usuario
     */
    public static int leerIntEnRango(Scanner sc, String msg, int min, int max){
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
    public static boolean leerBoolean(Scanner sc, String msg){
        System.out.print(msg);
        while (!sc.hasNextBoolean()){
            System.out.println("Ingresa solo 'true' o 'false': ");
            sc.nextLine();
        }
        return sc.nextBoolean();
    }

    /**
     * Imprime el ticket de envío con los datos y costos calculados
     * @param envio -> El objeto ShippingCalculator
     */
    public static void imprimirTicket(ShippingCalculator envio){
        System.out.println("---TICKET DE ENVÍO---");
        System.out.println("Servicio: " + (envio.tipoServicio));
        System.out.println("Peso: " + envio.pesoKg + "kg");
        System.out.println("Distancia: " + envio.distanciaKm + "km");
        System.out.println("Zona remota? " + envio.zonaRemota);
        System.out.println("\nSubtotal --> $" + envio.subtotal);
        System.out.println("IVA 16% --> $" + envio.iva);
        System.out.println("TOTAL A PAGAR ----> $" + envio.total);
    }

}
