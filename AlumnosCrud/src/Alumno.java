public class Alumno {
    private int id;
    private String name;
    private double average;
    private boolean active;

    public Alumno(int id, String name, double average) {
        this.id = id;
        this.name = name;
        this.average = average;
        this.active = true;
    }

    /**
     * Obtiene el ID del alumno
     * @return int -> El ID del alumno
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del alumno
     * @return String -> El nombre del alumno
     */
    public String getName() {
        return name;
    }

    /**
     * Obtiene el promedio del alumno
     * @return double -> El promedio del alumno
     */
    public double getAverage() {
        return average;
    }

    /**
     * Indica si el alumno se encuentra activa o no
     * @return boolean -> true si el alumno se encuentra activo, false si se encuentra desactivado
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Desactiva el alumno
     */
    public void deactivate() {
        this.active = false;
    }

    /**
     * Cambia el promedio del alumno, solo si se encuentra activo
     * @param average -> El nuevo promedio del alumno
     */
    public void changeGrade(double average) {
        this.average = average;
    }

    /**
     * Imprime la información del alumno, incluyendo su ID, nombre, promedio y activo
     */
    public void printInfo() {
        System.out.println("| ID: " + this.id + " | Nombre: " + this.name + " | Promedio: " + this.average + " | Active: " + this.active);
    }
}
