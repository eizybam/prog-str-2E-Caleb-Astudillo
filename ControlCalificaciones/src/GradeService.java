public class GradeService {
    private double average, finalGrade;
    private final int ATTENDANCE;
    private String state, name;
    private final boolean FINAL_PROJECT_IS_APPROVED;
    double[] grades;

    /**
     * Constructor de la clase GradeService
     * @param name -> Nombre del alumno
     * @param grades -> Arreglo de calificaciones parciales
     * @param attendance -> Porcentaje de asistencia
     * @param finalProjectIsApproved -> Booleano que indica si el proyecto final fue aprobado o no
     */
    GradeService(String name, double[] grades, int attendance, boolean finalProjectIsApproved){
        this.name = name;
        this.grades = grades;
        this.ATTENDANCE = attendance;
        this.FINAL_PROJECT_IS_APPROVED = finalProjectIsApproved;
        this.finalGrade = -1;
    }

    /**
     * Calcula el promedio de las calificaciones parciales y lo asigna a la variable average
     */
    private void setAverage(){
        for (double grade : this.grades) {
            this.average += grade;
        }
        this.average /= this.grades.length;
    }

    /**
     * Calcula la calificación final basada en el promedio y la asistencia, y lo asigna a la variable finalGrade
     */
    private void setFinalGrade(){
        this.finalGrade = (this.average * 0.7) + (this.ATTENDANCE * 0.3);
    }

    /**
     * Determina el estado del alumno basado en la asistencia, el proyecto final y la calificación final, y lo asigna a la variable state
     */
    public void setState(){
        this.setAverage();
        if (this.ATTENDANCE < 80) {
            this.state = "REPROBADO por asistencia";
        }

        else if (!this.FINAL_PROJECT_IS_APPROVED){
            this.state = "REPROBADO por proyecto";
        }

        else {
            this.setFinalGrade();
            if (this.finalGrade >= 70) {
                this.state = "APROBADO";
            }
            else {
                this.state = "REPROBADO por calificación";
            }
        }

    }

    /**
     * Imprime un reporte con el nombre del alumno, sus calificaciones parciales, su promedio, su asistencia, si entregó el proyecto final, su calificación final y su estado
     */
    public void printReport(){
        System.out.println("\n-- REPORTE DE CALIFICACIONES del alumno: " + this.name + " --");
        System.out.println("Calificaciones parciales: " + this.grades[0] + ", " + this.grades[1] + ", " + this.grades[2]);
        System.out.println("- PROMEDIO: " + this.average);
        System.out.println("- ASISTENCIA: " + this.ATTENDANCE + "%");
        System.out.println("- Entregó proyecto final: " + ((this.FINAL_PROJECT_IS_APPROVED) ? "Sí": "No"));
        System.out.println(("---> CALIFICACIÓN FINAL: " + ((this.finalGrade >= 0) ? this.finalGrade: "No aplica").toString()));
        System.out.println("----> ESTADO: " + this.state);
    }

}
