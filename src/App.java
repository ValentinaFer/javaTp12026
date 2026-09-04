import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Estudiante[] estudiantes;
        // uso de constructor sin parametro
        Estudiante e1 = new Estudiante();
        e1.setNombre("Valentina");
        e1.setApellido("Fernandez");
        e1.setCarrera("Programacion");
        e1.setEdad(23);
        e1.setPromedio(10);
        Estudiante e2 = new Estudiante();
        e2.setNombre("Tony");
        e2.setApellido("Stark");
        e2.setCarrera("Ingenieria en electromecanica nuclear");
        e2.setEdad(46);
        e2.setPromedio(9.5);
        Estudiante e3 = new Estudiante();
        e3.setNombre("James");
        e3.setApellido("Howlett");
        e3.setCarrera("Ingenieria en ser Wolverine");
        e3.setEdad(190);
        e3.setPromedio(10);

        // uso de constructor parametrizado
        Estudiante e4 = new Estudiante("Peter", "Parker", "Ingenieria en algo", 21, 9.8);
        Estudiante e5 = new Estudiante("Bruce", "Wayne", "Ingenieria en ser Batman", 40, 10);
        Estudiante e6 = new Estudiante("Anna", "LeBeau", "Ingenieria en ser Rogue", 24, 9);
        Estudiante e7 = new Estudiante("Anna", "Gomez", "No se", 24, 5);


        estudiantes = new Estudiante[] { e1, e2, e3, e4, e5, e6 , e7};

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(
                    "Estudiante: " + estudiantes[i].getNombre() + ", Promedio: " + estudiantes[i].getPromedio());
        }

        //Ejercicio 1
        System.out.println("---------------");
        System.out.println("[INFORMACION COMPLETA]");
        System.out.println("---------------");
        for (Estudiante e : estudiantes) {
            // System.out.println(e.toString());
            System.out.println(e);
            System.out.println("---------------");
        }

        //Ejercicio 2
        System.out.println("[PROMEDIO DEL CURSO] =>" + getPromedioCurso(estudiantes));
        System.out.println("---------------");

        //Ejercicion 3, permite mostrar más de un estudiante, en case de promedios iguales
        System.out.println("[ESTUDIANTES CON MAYOR PROMEDIO] ");
        System.out.println("---------------");
        for (Estudiante estudiante : getEstudianteMayorPromedio(estudiantes)) {
            System.out.println(estudiante);
            System.out.println("---------------");
        }

        //Ejercicio 4, permite ingresar la nota minima
        System.out.println("[ESTUDIANTES APROBADOS EN BASE A NOTA MINIMA]");
        System.out.println("Ingrese el minimo de nota que se considera aprobado: ");
        double minNota = Double.parseDouble(scanner.nextLine()); //might obviously thrown an exception..

        Estudiante[] estudiantesAprob = getEstudiantesAprobados(estudiantes, minNota);
        System.out.println("[ESTUDIANTES APROBADOS]");
        System.out.println("---------------");
        for (int i = 0; i < estudiantesAprob.length; i++) {
            System.out.println(estudiantesAprob[i]);
            System.out.println("---------------");
        };
        //hay tecnicamente uso de contador dentro de la function getEstudiantesAprobados(), no lo considere necesario aca
        //ya que cont == arrayConResultados.length
        System.out.println("[CANT.] => " + estudiantesAprob.length + " estudiantes aprobados.");
        System.out.println("---------------");

        //Ejercicio 5, permite encontrar más de una coincidencia
        System.out.println("[BUSCAR ESTUDIANTE POR NOMBRE]");
        System.out.println("Ingrese el nombre de un estudiante a buscar: ");
        String nombre = scanner.next();
        Estudiante[] estNombreCoinciden = getEstudiantesPorNombre(estudiantes, nombre);
        if (estNombreCoinciden.length > 0) {
            for (int i = 0; i < estNombreCoinciden.length; i++) {
                System.out.println(estNombreCoinciden[i]);
                System.out.println("---------------");
            };
        } else {
            System.out.println("No hubieron coincidencias para la busqueda: " + nombre + ".");
            System.out.println("---------------");
        }

        //Ejercicio 6, nota mayor o igual a 7 es aprobado, menor a 7 desaprobado
        System.out.println("[ALUMNOS QUE APRUEBAN O DESAPRUEBAN EN BASE A RANGO(0-6 desaprueba, 7-10 aprueba)]");
        showEstudiantesClasificacion(estudiantes);
        System.out.println("---------------");

        //Ejercicio 7
        System.out.println("[ALUMNOS QUE CUMPLEN CONDICION(con metodo en clase Estudiante)]");
        showEstudiantesCondicion(estudiantes);
        scanner.close();

    }

    public static double getPromedioCurso(Estudiante[] estudiantes) {
        double promedio = 0;
        for (Estudiante e : estudiantes) {
            promedio += e.getPromedio();
        }
        return promedio / estudiantes.length;
    }

    public static Estudiante[] getEstudianteMayorPromedio(Estudiante[] estudiantes) {
        double promedioMayor = 0;
        int contEstPromedio = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() > promedioMayor) {
                promedioMayor = estudiantes[i].getPromedio();
                contEstPromedio = 1;
            } else if (estudiantes[i].getPromedio() == promedioMayor) {
                contEstPromedio++;
            }
        }

        Estudiante[] estPromedioArr = new Estudiante[contEstPromedio];
        int indexEstPromedioArr = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() == promedioMayor) {
                estPromedioArr[indexEstPromedioArr++] = estudiantes[i];
            }
        }
        return estPromedioArr;
    }

    public static Estudiante[] getEstudiantesAprobados(Estudiante[] estudiantes, double minimoNota) {
        int cantAprobados = getCountAprobados(estudiantes, minimoNota);
        Estudiante[] estudiantesAprobados = new Estudiante[cantAprobados];
        int contador = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() >= minimoNota) {
                estudiantesAprobados[contador++] = estudiantes[i];
            }
        }
        ;
        return estudiantesAprobados;
    }

    public static int getCountAprobados(Estudiante[] estudiantes, double minimoNota) {
        int count = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() >= minimoNota) {
                count++;
            }
        }
        ;
        return count;
    }

    public static Estudiante[] getEstudiantesPorNombre(Estudiante[] estudiantes, String nombre) {

        int cont = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                cont++;
            }
        }
        ;
        Estudiante[] estCoinciden = new Estudiante[cont];
        cont = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getNombre().equalsIgnoreCase(nombre)) {
                estCoinciden[cont++] = estudiantes[i];
            }
        }
        ;
        return estCoinciden;
    };

    public static void showEstudiantesClasificacion(Estudiante[] estudiantes){
        double promedio;
        for(int i = 0; i < estudiantes.length; i++){
            promedio = estudiantes[i].getPromedio();
            if (promedio >= 0 && promedio <= 6){
                System.out.println(estudiantes[i] + " Promedio menor a 7 DESAPRUEBA");
            } else if (promedio >= 7 && promedio <= 10){
                System.out.println(estudiantes[i] + " promedio mayor o igual a 7 APRUEBA");
            } else {
                System.out.println("Promedio fuera de rango?!! WHAT!");
            }
        };
    }

    public static void showEstudiantesCondicion(Estudiante[] estudiantes){
        for (int i = 0; i < estudiantes.length; i++){
            if (estudiantes[i].isAprobado()){
                System.out.println(estudiantes[i]);
            }
        }
    }

}
