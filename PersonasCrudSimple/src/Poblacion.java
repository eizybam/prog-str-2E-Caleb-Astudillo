public class Poblacion {
    Persona[] personas;

    Poblacion(Persona[] personas){
        this.personas = personas;
    }

    public void addPersona(int id, String name){
        if (searchById(id) != null){
            System.out.println("ERROR: ID ya existe");
            return;
        }

        int indexOfNextFree = getIndexOfNextFree();

        if (indexOfNextFree >= 0){
            this.personas[indexOfNextFree] = new Persona(id, name);
            System.out.println("ÉXITO: Persona añadida");
        }
        else {
            System.out.print("ERROR: Imposible añadir, causa: Población llena");
        }
    }

    public void printActivePersonas(){
        System.out.println("Lista de personas activas:");
        for (Persona persona: personas){
            if (persona != null && persona.active) {
                persona.printInfo();
            }
        }
    }

    public boolean deactivatePersona(int id){
        Persona persona = searchById(id);
        if (persona != null && persona.active){
            persona.active = false;
            return true;
        }
        return false;
    }

    public Persona getPersonaById(int id){
        Persona persona = searchById(id);
        if (persona != null && persona.active ){
            return persona;
        }
        return null;
    }

    public boolean updatePersonaName(int id, String name){
        Persona persona = searchById(id);
        if (persona != null && persona.active){
            persona.name = name;
            return true;
        }
        return false;
    }

    private Persona searchById(int id){
        for (Persona persona: personas){
            if (persona != null && persona.id == id){
                return persona;
            }
        }
        return null;
    }

    private int getIndexOfNextFree(){
        int indexOfNextFree = -1;
        for (int i = 0; i<this.personas.length; i++){
            if (this.personas[i] == null){
                indexOfNextFree = i;
            }
        }
        return indexOfNextFree;
    }

}
