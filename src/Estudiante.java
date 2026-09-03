public class Estudiante {
    private String nombre, apellido, carrera;
    private int edad;
    private double promedio;

    public Estudiante(){}

    public Estudiante(String nombre, String apellido, String carrera, int edad, double promedio){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.edad = edad;
        this.promedio = promedio;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getCarrera(){
        return carrera;
    }

    public int getEdad(){
        return edad;
    }

    public double getPromedio(){
        return promedio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setPromedio(double promedio){
        this.promedio = promedio;
    }

    public boolean isAprobado(){
        return this.promedio >= 7;
    }

    @Override
    public String toString(){
        return "Nombre completo: " + apellido + " " + nombre + ",\n" + "Edad: "+ edad + ",\n" + "Carrera: "+ carrera + ",\n" + "Promedio: "+ promedio;
    }

}