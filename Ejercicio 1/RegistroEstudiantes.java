import java.util.ArrayList;

public class RegistroEstudiantes {
    
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    //Debe pasar un array vacio
    public RegistroEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public boolean agregarEstudiante(Estudiante estudiante){
        return estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(String id){

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId().equalsIgnoreCase(id)) {
                estudiantes.remove(estudiante);
                System.out.println("Estudiante eliminado correctamente!");
                break;
            } else{
                System.out.println("No se encontró ese código en el registro academico");
            }
        }
    }

    public void listarEstudiantes(ArrayList<Estudiante> estudiantesEncontrados){
        for (Estudiante estudiante : estudiantesEncontrados) {
            estudiante.mostrarEstudiante();
        }
    }

    public void buscarEstudiantes(String filtro){

        ArrayList<Estudiante> estudiantesEncontrados = new ArrayList<>();

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getName().equalsIgnoreCase(filtro) || estudiante.getId().equalsIgnoreCase(filtro) || 
            estudiante.getProgram().equalsIgnoreCase(filtro)) {
                estudiantesEncontrados.add(estudiante);
            }
        }
        System.out.println("Estudiantes encontrados:");
        listarEstudiantes(estudiantesEncontrados);
    }
}
