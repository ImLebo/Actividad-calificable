package Ejercicio_2;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Libro> libroprestar = new ArrayList<>();
        ArrayList<Libro> libros = new ArrayList<>();
        ArrayList<Autor> autores = new ArrayList<>();

        ArrayList<Prestamo> prestamosActivos = new ArrayList<>();
        Date current_date = new Date();
  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean salir = false;

        RegistroBiblioteca registro = new RegistroBiblioteca(libros, autores, prestamosActivos, current_date);
        leer_archivo(registro);

        while (!salir) {
            System.out.println("Sistema de Gestión de Biblioteca:");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar autor");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Registrar devolución");
            System.out.println("5. Listar libros");
            System.out.println("6. Listar autores");
            System.out.println("7. Listar préstamos");
            System.out.println("8. Buscar libros");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // Implementación de la lógica para registrar un libro
                    int disponibles; 
                    String title, name_autor, isbn, category, aux = "";
                    Autor autor_registro = null;
                    System.out.println("Indica el titulo del libro que deseas registrar:");
                    title = scanner.nextLine();
                    System.out.println("Indica el nombre del autor del libro");
                    name_autor = scanner.nextLine(); 
                    for (Autor autor : autores) {
                        if (name_autor.equalsIgnoreCase(autor.getName())) {
                            autor_registro=autor;
                            break;
                        } 
                    } 
                    if(autor_registro==null){
                        System.out.println("No se ha podido encontrar");
                        System.out.println("Deseas crear un autor Y(Sí)/N(No)");
                        aux = scanner.nextLine();
                        if (aux.equalsIgnoreCase("y")) {
                            String name_new_autor, naciotality;
                            System.out.println("Indique el nombre del Autor");
                            name_new_autor = scanner.nextLine();
                            System.out.println("Indique la nacionalidad");
                            naciotality = scanner.nextLine();
                            autor_registro = new Autor(name_new_autor, naciotality);
                            autores.add(autor_registro);
                        } else {
                            System.out.println("No pondremos autor al libro");
                        }
                    }
                    System.out.println("Indique el ISBN del libro:");
                    isbn = scanner.nextLine();
                    System.out.println("Indica la categoria del libro:");
                    category = scanner.nextLine();
                    System.out.println("Indica las copias disponibles");
                    disponibles = Integer.parseInt(scanner.nextLine());

                    registro.agregarLibro(new Libro(title, autor_registro, isbn, category, disponibles));

                    break;
                case 2:

                    String autor_name, nationality; 
                    System.out.println("Indica el nombre del autor que deseas registrar");
                    autor_name = scanner.nextLine();
                    System.out.println("Indique la nacionalidad del autor");
                    nationality = scanner.nextLine(); 
                    registro.agregarAutor(new Autor(autor_name, nationality));     

                    break;
                case 3:
                    int selector_libro;
                    String name_libro, name_user, cc_user;
                    System.out.println("Indique el nombre del libro que desea prestar");
                    name_libro = scanner.nextLine();
                    libroprestar = registro.buscarLibros(name_libro);
                    registro.listarLibros(libroprestar);
                    System.out.println("¿Cual desea prestar de la lista anterior?");
                    selector_libro = Integer.parseInt(scanner.nextLine());
                    Libro libroAux = libroprestar.get(selector_libro);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(current_date);
                    calendar.add(Calendar.DATE, 3);
                    Date return_date = calendar.getTime();
                    System.out.println("Indique el nombre del usuario");
                    name_user = scanner.nextLine();
                    System.out.println("Indique la cedula del usuario");
                    cc_user = scanner.nextLine();
                    libroAux.setCopies_avaliable(libroAux.getCopies_avaliable()-1);
                    registro.registrarPrestamo(new Prestamo(libroAux, new Usuario(name_user, cc_user), current_date, return_date));

                    break;
                case 4:
                    System.out.println("Que Libro desea devolver?");
                    registro.listarPrestamo();
                    System.out.println("Indique el numero del prestamo que desea devolver");
                    int selector_prestamo = Integer.parseInt(scanner.nextLine());
                    Prestamo prestamo = prestamosActivos.get(selector_prestamo);
                    registro.registrarDevolucion(prestamo);
                    break;
                case 5:
                    registro.listarLibros(libros);
                    break;
                case 6:
                    registro.listarAutores();
                    break;
                case 7:
                    registro.listarPrestamo();
                    break;
                case 8:
                    System.out.print("Introduce el filtro para buscar libros: ");
                    String filtro = scanner.nextLine();
                    registro.buscarLibros(filtro);
                    break;
                case 9:
                    System.out.println("Gracias por utilizar el sistema. ¡Adiós!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
        scanner.close();
    }

    private static void leer_archivo(RegistroBiblioteca registro){
        try {
     
            String linea = "";
            int contador = 0; 
            Autor new_autor = null;
            BufferedReader lector = new BufferedReader(new FileReader("C:\\Users\\lebop\\Documents\\UCaldas\\Programacion_2\\Actividad Calificable\\Ejercicio_2\\libros.txt"));
            while ((linea=lector.readLine())!=null) {
                String[] bloques = linea.split(",");
                if (contador==0) {
                    if (bloques.length==2) {
                        String name_autor = bloques[0];
                        String nationality = bloques[1];
                        new_autor = new Autor(name_autor, nationality);
                        registro.agregarAutor(new_autor);
                        contador++;
                    }
                }
                if (contador==1) {
                    if (bloques.length==4) {
                        String title = bloques[0];
                        String isbn = bloques[1];
                        String category = bloques[2];
                        int copies_avaliable = Integer.parseInt(bloques[3]);
                        registro.agregarLibro(new Libro(title, new_autor, isbn, category, copies_avaliable));
                        contador=0;
                    }
                }
            }
            lector.close();  
        } catch (Exception e) {
            System.out.println("Error al leer el archivo "+ e.getMessage());
        }
    }

}
