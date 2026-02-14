public class Persona {
    private int id;
    private String name;
    private boolean active;

    public Persona(int id, String name) {
        this.id = id;
        this.name = name;
        this.active = true;
    }

    /**
     * Obtiene el ID de la persona
     * @return int -> El ID de la persona
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre de la persona
     * @return String -> El nombre de la persona
     */
    public String getName() {
        return name;
    }

    /**
     * Indica si la persona se encuentra activa o no
     * @return boolean -> true si la persona se encuentra activa, false si se encuentra desactivada
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Desactiva la persona
     */
    public void deactivate() {
        this.active = false;
    }

    /**
     * Cambia el nombre de la persona, solo si se encuentra activa
     * @param name -> El nuevo nombre de la persona
     */
    public void rename(String name) {
        this.name = name;
    }

    /**
     * Imprime la información de la persona en formato: | ID: id | Nombre: name | Active: active |
     */
    public void printInfo() {
        System.out.println("| ID: " + this.id + " | Nombre: " + this.name + " | Active: " + this.active);
    }
}
