package Ejercicio_2;

public class Libro {

    private String title; 
    private Autor autor;
    private String isbn;
    private String category;
    private int copies_avaliable;

    public Libro(String title, Autor autor, String isbn, String category, int copies_avaliable) {
        this.title = title;
        this.autor = autor;
        this.isbn = isbn;
        this.category = category;
        this.copies_avaliable = copies_avaliable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCopies_avaliable() {
        return copies_avaliable;
    }

    public void setCopies_avaliable(int copies_avaliable) {
        this.copies_avaliable = copies_avaliable;
    }

    public void mostrarLibro(){
        System.out.println("Titulo: "+title+" Autor: "+autor.getName()
        +" ISBN: "+ " Categoria: "+category+" Unidades disponibles: "+copies_avaliable);
    }
    
    
}

