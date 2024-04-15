package Ejercicio_3;

public class Producto {

    private String name;
    private Categoria category; 
    private double price; 
    private int stock;
    
    public Producto(String name, Categoria category, double price, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void mostrarProducto() {
        System.out.println("Producto: [Nombre=" + name + ", Categoria=" + category.getName_category() + ", Precio=" + price + ", Stock=" + stock + "]"); 
    }

    
}
