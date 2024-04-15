public class Estudiante {
    
    private String name;
    private String id;
    private String program;
    private double average;

    public Estudiante(String name, String id, String program, double average) {
        this.name = name;
        this.id = id;
        this.program = program;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void mostrarEstudiante(){
        System.out.println("Nombre: "+name+" Código: "+id+" Carrera: "+program+" Promedio: "+average);
    }

}
