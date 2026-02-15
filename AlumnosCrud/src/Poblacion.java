public class Poblacion {
    private Alumno[] alumnos;

    public Poblacion(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Agrega un alumno a la población, si el alumno es null o la población se encuentra llena, no se agrega el alumno
     * @param alumno -> El alumno a agregar
     * @return boolean -> true si el alumno fue agregado correctamente, false si el alumno no fue agregado
     */
    public boolean addAlumno(Alumno alumno) {
        if (alumno == null) {
            return false;
        }
        int indexOfNextFree = getIndexOfNextFree();
        if (indexOfNextFree < 0) {
            return false;
        }
        this.alumnos[indexOfNextFree] = alumno;
        return true;
    }

    /**
     * Busca un alumno por su ID, si el alumno no existe o se encuentra desactivado, devuelve null
     * @param id -> El ID del alumno a buscar
     * @return Alumno -> El alumno encontrado, null si el alumno no existe o se encuentra desactivado
     */
    public Alumno findById(int id) {
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getId() == id) {
                return alumno;
            }
        }
        return null;
    }


    /**
     * Devuelve un arreglo con los alumnos de la población
     * @return Alumno[] -> El arreglo con los alumnos de la población
     */
    public Alumno[] getAlumnos() {
        return alumnos;
    }

    /**
     * Busca el índice del siguiente espacio libre en el arreglo de alumnos, si no hay espacio libre devuelve -1
     * @return int -> El índice del siguiente espacio libre, -1 si no hay espacio libre
     */
    private int getIndexOfNextFree() {
        for (int i = 0; i < this.alumnos.length; i++) {
            if (this.alumnos[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
