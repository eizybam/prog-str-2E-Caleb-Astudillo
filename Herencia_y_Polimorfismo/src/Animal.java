public class Animal {

    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }


    public void comer(){
        System.out.println(nombre+ " Esta comiendo");
    }

    public void hacerSonido(){
        System.out.println(nombre+ " Esta haciendo un sonido");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}