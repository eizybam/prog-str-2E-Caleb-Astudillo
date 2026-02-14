public class PersonaService {
    public enum AddResult {
        SUCCESS,
        DUPLICATE_ID,
        FULL
    }

    private final Poblacion poblacion;

    /**
     * Crea un nuevo servicio de personas con la población dada
     * @param poblacion -> La población que se usará para gestionar las personas
     */
    public PersonaService(Poblacion poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * Agrega una nueva persona a la población, si el ID no existe y hay espacio disponible
     * @param id -> El ID de la nueva persona (1-20)
     * @param name -> El nombre de la nueva persona
     * @return AddResult -> El resultado de intentar agregar la persona (éxito, ID duplicado o población llena)
     */
    public AddResult addPersona(int id, String name) {
        if (poblacion.findById(id) != null) {
            return AddResult.DUPLICATE_ID;
        }

        boolean added = poblacion.addPersona(new Persona(id, name));
        return added ? AddResult.SUCCESS : AddResult.FULL;
    }

    /**
     * Busca una persona por ID, pero solo si se encuentra activa
     * @param id -> El ID de la persona a buscar
     * @return Persona -> La persona encontrada si existe y está activa, o null si no existe o está desactivada
     */
    public Persona findActiveById(int id) {
        Persona persona = poblacion.findById(id);
        if (persona != null && persona.isActive()) {
            return persona;
        }
        return null;
    }

    /**
     * Desactiva una persona por ID, si existe y se encuentra activa
     * @param id -> El ID de la persona a desactivar
     * @return boolean -> true si la persona fue desactivada correctamente, false si no existe o ya está desactivada
     */
    public boolean deactivateById(int id) {
        Persona persona = poblacion.findById(id);
        if (persona != null && persona.isActive()) {
            persona.deactivate();
            return true;
        }
        return false;
    }

    /**
     * Cambia el nombre de una persona por ID, si existe y se encuentra activa
     * @param id -> El ID de la persona a renombrar
     * @param name -> El nuevo nombre de la persona
     * @return boolean -> true si la persona fue renombrada correctamente, false si no existe o ya está desactivada
     */
    public boolean renameById(int id, String name) {
        Persona persona = poblacion.findById(id);
        if (persona != null && persona.isActive()) {
            persona.rename(name);
            return true;
        }
        return false;
    }

    /**
     * Obtiene un arreglo de todas las personas que se encuentran activas en la población
     * @return Persona[] -> Un arreglo con todas las personas activas, o un arreglo vacío si no hay personas activas
     */
    public Persona[] getActivePersonas() {
        Persona[] all = poblacion.getPersonas();
        int count = 0;
        for (Persona persona : all) {
            if (persona != null && persona.isActive()) {
                count++;
            }
        }
        Persona[] active = new Persona[count];
        int index = 0;
        for (Persona persona : all) {
            if (persona != null && persona.isActive()) {
                active[index++] = persona;
            }
        }
        return active;
    }
}
