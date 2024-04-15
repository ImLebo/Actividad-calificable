package Ejercicio_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> products = new ArrayList<>();
        ArrayList<Categoria> category = new ArrayList<>(); 
        ArrayList<Proveedor> supplier = new ArrayList<>();
        ArrayList<Venta> ventas = new ArrayList<>();
    
        RegistroInventario registro = new RegistroInventario(products, category, supplier, ventas);

        registro.registrarProducto(new Producto("Luis", null, 0, 0));
    }    
    
}
