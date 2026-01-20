import java.util.Scanner;

public class Main {
    public static final double IVA = 0.16;
    public static final double DESCUENTO = 0.10;
    public static final double UMBRAL_DESCUENTO = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");
        double total = calcularTotalConIva(subtotal);
        total = aplicarDescuentoSiAplica(total);
        System.out.printf("Total a pagar: %.2f%n", total);
    }

    /**
     * Imprime un mensaje para pedir un double al usuario
     * @param scanner -> Scanner definido en main
     * @param mensaje -> Mensaje a imprimir
     * @return double -> El double ingresado por el usuario
     */
    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    /**
     * Le aplica el IVA al subtotal
     * @param subtotal -> Subtotal de la compra
     * @return double -> Regresa el total con IVA incluido
     */
    public static double calcularTotalConIva(double subtotal){
        return (subtotal + (subtotal * IVA));
    }

    /**
     * Aplica un descuento si el total sobre pasa el umbral
     * @param total -> El total de la compra antes del descuento
     * @return total -> El total con el descuento aplicado o no
     */
    public static double aplicarDescuentoSiAplica(double total){
        if (total > UMBRAL_DESCUENTO){
            total = total - (total * DESCUENTO);
        }
        return total;
    }
}