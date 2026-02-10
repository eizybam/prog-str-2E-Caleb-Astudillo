public class Persona {
    int id;
    String name;
    boolean active;

    Persona(int id, String name){
        this.id = id;
        this.name = name;
        this.active = true;
    }

    public void printInfo(){
        System.out.println("| ID: " + this.id + " | Nombre: " + this.name + " | Active: " + this.active);
    }
}
