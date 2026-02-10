public class Personas {
    Persona[] personas;

    Personas(Persona[] personas){
        this.personas = personas;
    }

    public void addPersona(int id, String name){
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

    private Persona searchByID(int id){
        for (Persona persona: personas){
            if (persona.id == id){
                return persona;
            }
        }
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
