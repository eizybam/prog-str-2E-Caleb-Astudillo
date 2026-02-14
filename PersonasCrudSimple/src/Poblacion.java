public class Poblacion {
    private Persona[] personas;

    public Poblacion(Persona[] personas) {
        this.personas = personas;
    }

    public boolean addPersona(Persona persona) {
        if (persona == null) {
            return false;
        }
        int indexOfNextFree = getIndexOfNextFree();
        if (indexOfNextFree < 0) {
            return false;
        }
        this.personas[indexOfNextFree] = persona;
        return true;
    }

    public Persona findById(int id) {
        for (Persona persona : personas) {
            if (persona != null && persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    private int getIndexOfNextFree() {
        for (int i = 0; i < this.personas.length; i++) {
            if (this.personas[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
