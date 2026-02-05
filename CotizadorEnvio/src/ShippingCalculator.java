public class ShippingCalculator {
    double subtotal, total, iva, pesoKg;
    int distanciaKm, tipoServicio;
    boolean zonaRemota;

    /**
     * Calcula el subtotal del envío basado en parametros dados
     * @param pesoKg -> El peso del paquete en kg
     * @param distanciaKm -> La distancia a recorrer en km
     * @param tipoServicio -> El tipo de servicio (1 para estándar, 2 para express)
     * @param zonaRemota -> Si es zona remota o no (true o false)
     * @return double -> El subtotal calculado
     */
    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        double subtotal = (tipoServicio == 1) ? 50.0 : 90.0;
        subtotal += 12 * pesoKg;
        if (distanciaKm <= 50) {
            subtotal += 20;
        }
        else if (distanciaKm <= 200) {
            subtotal += 60;
        }
        else {
            subtotal += 120;
        }

        subtotal += (zonaRemota) ? subtotal * 0.10 : 0;

        return subtotal;
    }

    /**
     * Calcula el IVA basado en el subtotal dado
     * @param subtotal -> El subtotal del envío
     * @return double -> El IVA calculado
     */
    public double calcularIVA(double subtotal){
        return subtotal * 0.16;
    }

    /**
     * Calcula el total del envío sumando el subtotal y el IVA
     * @param subtotal -> El subtotal del envío
     * @param iva -> El IVA del envío
     * @return double -> El total calculado
     */
    public double calcularTotal(double subtotal, double iva){
        return subtotal + iva;
    }
}
