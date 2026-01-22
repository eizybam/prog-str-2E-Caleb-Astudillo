import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int age = getAge(sc, "Introduce la edad: ");
        boolean isStudent = getIsStudent(sc, "Es estudiante? (responde 'true' o 'false'): ");
        int fare = getFare(age, isStudent);

        System.out.printf("Edad ingresada: %d %nEs estudiante? %b %nTarifa: $%d", age, isStudent, fare);

    }

    public static boolean getIsStudent(Scanner sc, String message){
        System.out.print(message);
        return sc.nextBoolean();
    }

    public static int getAge(Scanner sc, String message){
        System.out.print(message);
        int age = sc.nextInt();
        if (age < 0 || age > 120) {
            System.out.println("Edad inválida!");
            System.exit(1);
        }
        return age;
    }

    public static int getFare(int age, boolean isStudent){
        int fare;

        if (age < 12) {
            fare = 50;
        }
        else if (age < 17) {
            fare = (isStudent) ? 60 : 80;
        }
        else{
            fare = (isStudent) ? 90 : 120;
        }

        return fare;

    }
}
