public class App {
    public static void main(String[] args) throws Exception {

        double promedio;
        Estudiante[] estudiantes;
        Estudiante e1 = new Estudiante();
        e1.setNombre("Valentina");
        e1.setApellido("Fernandez");
        e1.setCarrera("Programacion");
        e1.setEdad(23);
        e1.setPromedio(9.5);

        Estudiante e2 = new Estudiante("Peter", "Parker", "Ingenieria en algo", 21, 9.8);
        Estudiante e3 = new Estudiante("Bruce", "Wayne", "Ingenieria en ser Batman", 40, 10);
        
        estudiantes = new Estudiante[]{e1, e2, e3};

        for(int i = 0; i < estudiantes.length; i++){
            System.out.println("Estudiante: " + estudiantes[i].getNombre()+ ", Promedio: " + estudiantes[i].getPromedio());
        }
    
        System.out.println("---------------");
        System.out.println("Using ToString override method: ");
        for (Estudiante e : estudiantes) {
            System.out.println(e.toString());
            System.out.println("---------------");
        }


    }

    
    public static double getPromedioEstudiantes(Estudiantes[] estudiantes){
        double promedio = 0;
        for (Estudiantes e : estudiantes) {
            promedio += e.getPromedio();
        }
        return promedio;
    }    

    public static Estudiante getEstudianteMayorPromedio(Estudiante[] estudiantes){
        Estudiante estMayorProm = new Estudiante();
        for(int i = 0; i < estudiantes.length; i++){
            if (estudiantes[i].getPromedio() >= estMayorProm.getPromedio()){
                estMayorProm = estudiantes[i];
            }
        }
        return estMayorProm;
    }

}
