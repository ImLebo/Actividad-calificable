import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        String selector = "";
        String aux = "";
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        leer_archivo(estudiantes);

        RegistroEstudiantes registro = new RegistroEstudiantes(estudiantes);

        System.out.println("Bienvenido al registro de estudiantes de UCaldas");


        while (true) {

        System.out.println("1. Agregar estudiantes");
        System.out.println("2. Eliminar estudiante");
        System.out.println("3. Listar estudiantes");
        System.out.println("4. Buscar estudiantes");
        System.out.print("Elija una opción 1-2-3-4: ");
        
        selector = sc.nextLine(); 

        if (selector=="" || selector==null) {
        selector = sc.nextLine();
        }

        System.out.println("Has elegido la opción "+selector);

        switch (selector) {
            case "1":
                System.out.println("Indica el nombre:");
                String new_name = sc.nextLine();
                System.out.println("Indica el id:");
                String new_id = sc.nextLine();
                System.out.println("Indica la carrera:");
                String new_program = sc.nextLine();
                System.out.println("Indica el promedio:");
                double new_average = sc.nextDouble();

                Estudiante estudiante = new Estudiante(new_name, new_id, new_program, new_average);
                
                if (registro.agregarEstudiante(estudiante)==true) {
                    System.out.println("Estudiante agregado correctamente!");
                } else {
                    System.out.println("No se ha podido agregar el estudiante");
                }
            
                break;

            case "2":
                System.out.println("Indica el id del estudiante que deseas eliminar");
                aux = sc.nextLine();
                registro.eliminarEstudiante(aux);
                break;

            case "3":
                registro.listarEstudiantes(estudiantes);
                break; 

            case "4":
                System.out.println("Para buscar estudiantes, puede escribir el nombre, codigo o carrerra");
                aux = sc.nextLine();
                registro.buscarEstudiantes(aux);
                break;
        
            default:
                System.out.println("Opción invalida!");
                break;
            
        }
    }
}
    

    private static void leer_archivo(ArrayList<Estudiante> arrayList){
        try {
     
            String linea = "";
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\lebop\\Documents\\UCaldas\\Programacion_2\\Actividad Calificable\\Ejercicio 1\\estudiantes.txt"));
            while ((linea=lector.readLine())!=null) {
                String[] bloques = linea.split("    ");
                System.out.println(bloques.length);
                if (bloques.length==4) {
                    String name = bloques[0];
                    System.out.println(name);
                    String id = bloques[1];
                    System.out.println(id);
                    String program = bloques[2];
                    double average = Double.parseDouble(bloques[3]);
                    arrayList.add(new Estudiante(name, id, program, average));
                }
            }
            lector.close();  
        } catch (Exception e) {
            System.out.println("Error al leer el archivo "+ e.getMessage());
        }
    }
}