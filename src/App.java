public class App {
    public static void main(String[] args) throws Exception {

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

        estudiantes = new Estudiante[] { e1, e2, e3, e4, e5, e6 };

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.println(
                    "Estudiante: " + estudiantes[i].getNombre() + ", Promedio: " + estudiantes[i].getPromedio());
        }

        System.out.println("---------------");
        System.out.println("[INFORMACION COMPLETA]");
        System.out.println("---------------");
        for (Estudiante e : estudiantes) {
            // System.out.println(e.toString());
            System.out.println(e);
            System.out.println("---------------");
        }

        System.out.println("[PROMEDIO DEL CURSO] =>" + getPromedioCurso(estudiantes));
        System.out.println("---------------");

        System.out.println("[ESTUDIANTES CON MAYOR PROMEDIO] ");
        System.out.println("---------------");
        for (Estudiante estudiante : getEstudianteMayorPromedio(estudiantes)) {
            System.out.println(estudiante);
            System.out.println("---------------");
        }

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
            if (estudiantes[i].getPromedio() > promedioMayor){
                promedioMayor = estudiantes[i].getPromedio();
                contEstPromedio = 1;
            } else if (estudiantes[i].getPromedio() == promedioMayor){
                contEstPromedio++;
            }
        }

        Estudiante[] estPromedioArr = new Estudiante[contEstPromedio];
        int indexEstPromedioArr = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].getPromedio() == promedioMayor){
                estPromedioArr[indexEstPromedioArr++] = estudiantes[i];
            }
        }
        return estPromedioArr;
    }

    public static Estudiante[] getEstudiantesAprobados(Estudiante[] estudiantes, double minimoNota){
        int cantAprobados = getCountAprobados(estudiantes, minimoNota);
        Estudiante[] estudiantesAprobados = new Estudiante[cantAprobados];
        int contador = 0;
        for (int i = 0; i < estudiantes.length; i++){
            if (estudiantes[i].getPromedio() >= minimoNota){
                estudiantesAprobados[contador++] = estudiantes[i];
            }
        };
        return estudiantesAprobados;
    }

    public static int getCountAprobados(Estudiante[] estudiantes, double minimoNota){
        int count = 0;
        for(int i = 0; i < estudiantes.length; i++){
            if (estudiantes[i].getPromedio() >= minimoNota){
                count++;
            }
        };
        return count;
    }

}
