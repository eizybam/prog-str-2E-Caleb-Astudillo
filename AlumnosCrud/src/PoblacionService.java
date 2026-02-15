public class PoblacionService {
    public enum AddResult {
        SUCCESS,
        DUPLICATE_ID,
        FULL
    }

    private final Poblacion poblacion;

    /**
     * Crea un nuevo servicio de alumnos con la población dada
     * @param poblacion -> La población que se usará para gestionar los alumnos
     */
    public PoblacionService(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Agrega un nuevo alumno a la población, si el ID no existe y hay espacio disponible
     * @param id -> El ID de el nuevo alumno (1-20)
     * @param name -> El nombre de el nuevo alumno
     * @return AddResult -> El resultado de intentar agregar el alumno (éxito, ID duplicado o población llena)
     */
    public AddResult addAlumno(int id, String name, double average) {
        if (poblacion.findById(id) != null) {
            return AddResult.DUPLICATE_ID;
        }

        boolean added = poblacion.addAlumno(new Alumno(id, name, average));
        return added ? AddResult.SUCCESS : AddResult.FULL;
    }

    /**
     * Busca un alumno por ID, pero solo si se encuentra activo
     * @param id -> El ID de el alumno a buscar
     * @return Alumno -> el alumno encontrado si existe y está activo, o null si no existe o está desactivado
     */
    public Alumno findActiveById(int id) {
        Alumno alumno = poblacion.findById(id);
        if (alumno != null && alumno.isActive()) {
            return alumno;
        }
        return null;
    }

    /**
     * Desactiva un alumno por ID, si existe y se encuentra activo
     * @param id -> El ID de el alumno a desactivar
     * @return boolean -> true si el alumno fue desactivado correctamente, false si no existe o ya está desactivado
     */
    public boolean deactivateById(int id) {
        Alumno alumno = poblacion.findById(id);
        if (alumno != null && alumno.isActive()) {
            alumno.deactivate();
            return true;
        }
        return false;
    }

    /**
     * Cambia el nombre de un alumno por ID, si existe y se encuentra activo
     * @param id -> El ID de el alumno a renombrar
     * @param average -> El nuevo nombre de el alumno
     * @return boolean -> true si el alumno fue renombrada correctamente, false si no existe o ya está desactivado
     */
    public boolean changeAverage(int id, double average) {
        Alumno alumno = poblacion.findById(id);
        if (alumno != null && alumno.isActive()) {
            alumno.changeGrade(average);
            return true;
        }
        return false;
    }

    /**
     * Obtiene un arreglo de todas los alumnos que se encuentran activos en la población
     * @return Alumno[] -> Un arreglo con todas los alumnos activos, o un arreglo vacío si no hay alumnos activos
     */
    public Alumno[] getActiveAlumnos() {
        Alumno[] all = poblacion.getAlumnos();
        int count = 0;
        for (Alumno alumno : all) {
            if (alumno != null && alumno.isActive()) {
                count++;
            }
        }
        Alumno[] active = new Alumno[count];
        int index = 0;
        for (Alumno alumno : all) {
            if (alumno != null && alumno.isActive()) {
                active[index++] = alumno;
            }
        }
        return active;
    }

    /**
     * Calcula el promedio general de un arreglo de alumnos, asumiendo que el arreglo no es vacío
     * @param alumnos -> El arreglo de alumnos para calcular el promedio general
     * @return double -> El promedio general de los alumnos en el arreglo
     */
    public double calculateOverallAverage(Alumno[] alumnos){
        double sumAverage = 0;
        for (Alumno alumno : alumnos) {
            sumAverage += alumno.getAverage();
        }
        return sumAverage / alumnos.length;
    }

    /**
     * Obtiene el alumno con el mejor promedio de un arreglo de alumnos, asumiendo que el arreglo no es vacío
     * @param alumnos -> El arreglo de alumnos para encontrar el mejor alumno
     * @return Alumno -> El alumno con el mejor promedio en el arreglo
     */
    public Alumno getBestAlumno(Alumno[] alumnos){
        double bestAverage = 0;
        double currentAverage;
        Alumno bestAlumno = null;
        for (Alumno alumno : alumnos) {
            currentAverage = alumno.getAverage();
            if (currentAverage > bestAverage) {
                bestAverage = currentAverage;
                bestAlumno = alumno;
            }
        }
        return bestAlumno;
    }

    /**
     * Obtiene el alumno con el peor promedio de un arreglo de alumnos, asumiendo que el arreglo no es vacío
     * @param alumnos -> El arreglo de alumnos para encontrar el peor alumno
     * @return Alumno -> El alumno con el peor promedio en el arreglo
     */
    public Alumno getWorstAlumno(Alumno[] alumnos){
        double worstAverage = 10;
        double currentAverage;
        Alumno worstAlumno = null;
        for (Alumno alumno : alumnos) {
            currentAverage = alumno.getAverage();
            if (currentAverage < worstAverage) {
                worstAverage = currentAverage;
                worstAlumno = alumno;
            }
        }
        return worstAlumno;
    }

    /**
     * Obtiene un arreglo con los alumnos que tienen un promedio superior a un umbral dado, asumiendo que el arreglo de alumnos no es vacío
     * @param alumnos -> El arreglo de alumnos para filtrar por promedio
     * @param threshold -> El umbral de promedio para filtrar a los alumnos
     * @return Alumno[] -> Un arreglo con los alumnos que tienen un promedio superior al umbral
     */
    public Alumno[] getAlumnosWithAverageAbove(Alumno[] alumnos, double threshold) {
        int count = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getAverage() > threshold) {
                count++;
            }
        }
        Alumno[] alumnosAboveThreshold = new Alumno[count];

        int index = 0;
        for (Alumno alumno : alumnos) {
            if (alumno.getAverage() > threshold) {
                alumnosAboveThreshold[index++] = alumno;
            }
        }
        return alumnosAboveThreshold;
    }

    /**
     * Imprime un reporte de un arreglo de alumnos dado
     * @param alumnosToReport -> El arreglo de alumnos para generar el reporte
     */
    public void printReport(Alumno[] alumnosToReport) {
        double overallAverage = calculateOverallAverage(alumnosToReport);
        Alumno bestAlumno = getBestAlumno(alumnosToReport);
        Alumno worstAlumno = getWorstAlumno(alumnosToReport);
        Alumno[] alumnosAboveThreshold = getAlumnosWithAverageAbove(alumnosToReport, 8.0);

        System.out.println("--- REPORTE DE ALUMNOS ---");
        System.out.println("Promedio general: " + overallAverage);
        System.out.println("Mejor alumno | ID " + bestAlumno.getId() + " | " + bestAlumno.getName() + " con promedio de " + bestAlumno.getAverage());
        System.out.println("Peor alumno | ID " + worstAlumno.getId() + " | " + worstAlumno.getName() + " con promedio de " + worstAlumno.getAverage());
        System.out.println("- Alumnos con promedio superior a 8.0 -");
        for (Alumno alumno : alumnosAboveThreshold){
            if (alumno != null) {
                alumno.printInfo();
            }
        }

    }
}
