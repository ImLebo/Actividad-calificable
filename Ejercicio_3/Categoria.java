package Ejercicio_3;

public class Categoria {

    private String name_category; 
    private String description_category;

    public Categoria(String name_category, String description_category) {
        this.name_category = name_category;
        this.description_category = description_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getDescription_category() {
        return description_category;
    }

    public void setDescription_category(String description_category) {
        this.description_category = description_category;
    }

    public void mostrarCategoria() {
        System.out.println("Categoria [Nombre Categoria=" + name_category + ", Descripcion=" + description_category + "]");
    }

    
}
