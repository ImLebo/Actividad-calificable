package Ejercicio_2;

import java.util.Date;

public class Prestamo {
    
    private Libro libro;
    private Usuario user;
    private Date loan_date; 
    private Date return_date;

    public Prestamo(Libro libro, Usuario user, Date loan_date, Date return_date) {
        this.libro = libro;
        this.user = user;
        this.loan_date = loan_date;
        this.return_date = return_date;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Date getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String mostrarPrestamo() {
        return "Libro=" + libro.getTitle() + ", Usuario=" + user.getNombre() + ", Fecha prestamo=" +
         loan_date.toString() + ", Fecha devolucion="+ return_date.toString();
    }

}