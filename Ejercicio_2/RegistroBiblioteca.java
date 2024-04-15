package Ejercicio_2;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIDefaults.ProxyLazyValue;

public class RegistroBiblioteca {
    
    ArrayList<Libro> libros = new ArrayList<>();
    ArrayList<Autor> autores = new ArrayList<>();
    ArrayList<Prestamo> prestamosActivos = new ArrayList<>();
    Date current_date = new Date();

    public RegistroBiblioteca(ArrayList<Libro> libros, ArrayList<Autor> autores, ArrayList<Prestamo> prestamosActivos,
            Date current_date) {
        this.libros = libros;
        this.autores = autores;
        this.prestamosActivos = prestamosActivos;
        this.current_date = current_date;
    }

    public void agregarLibro(Libro libro){
        if(libros.add(libro)==true){
            System.out.println("El libro "+libro.getTitle()+" se ha agregado correctamente.");
        } else{
            System.out.println("No se ha podido agregar el libro");
        }
    }

    public void agregarAutor(Autor autor){
        if(autores.add(autor)==true){
            System.out.println("El autor "+autor.getName()+" se ha agregado correctamente!");
        } else{
            System.out.println("No se ha podido agregar al autor");
        }
    }

    public void registrarPrestamo(Prestamo prestamo){

        int contador = 0;
        for (Prestamo prestado : prestamosActivos) {
            
            if (prestado.getUser().getNombre().equals(prestamo.getUser().getNombre())) {
                contador++;
                if (prestado.getLibro().getCopies_avaliable()>0) {
                if (prestado.getReturn_date().before(current_date)) {
                    if (prestamosActivos.add(prestamo)) {
                        System.out.println("Libro prestado correctamente");
                    }
                } else{
                    System.out.println("No cumples con las condiciones para prestar el libro");
                }
                } else{
                    System.out.println("Actualmente no hay libros disponibles");
                }
            } }

            if (contador==0) {
                    prestamosActivos.add(prestamo);
                    System.out.println("Libro prestado correctamente");
                }
            }

    public void registrarDevolucion(Prestamo prestamo){

        for (Prestamo prestado : prestamosActivos) {
            if (prestado.equals(prestamo)) {
                prestamosActivos.remove(prestamo);
            }
        }
    }

    public void listarLibros(ArrayList<Libro> libros){
        int contador = 0; 
        for (Libro libro : libros) {

            System.out.print(contador+". ");
            libro.mostrarLibro();
            contador++;
        }
    }
    public void listarAutores(){
        for (Autor autor : autores) {
            System.out.println(autor.getName());
        }
    }

    public void listarPrestamo(){
        for (Prestamo prestamo : prestamosActivos) {
            System.out.println(prestamo.mostrarPrestamo());
        }
    }

    public ArrayList<Libro> buscarLibros(String filtro){

        ArrayList<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : libros) {
            
            if (libro.getTitle().equalsIgnoreCase(filtro) || libro.getAutor().getName().equalsIgnoreCase(filtro)
                || libro.getIsbn().equalsIgnoreCase(filtro) || libro.getCategory().equalsIgnoreCase(filtro)) {
                librosEncontrados.add(libro);
            }

        }

        return librosEncontrados;
    }

    
}
