package Ejercicio_3;

import java.util.ArrayList;

public class RegistroInventario {

    ArrayList<Producto> products = new ArrayList<>();
    ArrayList<Categoria> category = new ArrayList<>(); 
    ArrayList<Proveedor> supplier = new ArrayList<>();
    ArrayList<Venta> ventas = new ArrayList<>();

    public RegistroInventario(ArrayList<Producto> products, ArrayList<Categoria> category, ArrayList<Proveedor> supplier,
            ArrayList<Venta> ventas) {
        this.products = products;
        this.category = category;
        this.supplier = supplier;
        this.ventas = ventas;
    }

    public void registrarProducto(Producto producto){
        if (products.add(producto)) {
            System.out.println("Producto: " +producto.getName()+", agregado correctamente");
        }        
    }

    public void registrarCategoria(Categoria categoria){
        if (category.add(categoria)) {
            System.out.println("Categoria: "+categoria.getName_category()+", agregado correctamente");
        }
    }

    public void registrarProveedor(Proveedor proveedor){
        if (supplier.add(proveedor)) {
            System.out.println("Proveedor: "+proveedor.getName()+", agregado correctamente");
        }
    }

    public void registrarVenta(Venta venta){
        if (ventas.add(venta)) {
            System.out.println("La venta de: "+venta.getProducto().getName()+", registrada correctamente");
        }
    }

    public void listarProductos(ArrayList<Producto> productos){
        for (int i = 0; i < productos.size(); i++) {
            System.out.print("("+i+")");
            productos.get(i).mostrarProducto();
        }
    }

    public void listarCategorias(){
        for (int i = 0; i < category.size(); i++) {
            System.out.print("("+i+")");
            category.get(i).mostrarCategoria();
        }
    }

    public void listarProveedores(){
        for (int i = 0; i < supplier.size(); i++) {
            System.out.print("("+i+")");
            supplier.get(i).mostrarProveedor(); 
        }
    }
    public void listarVentas(){
        for (int i = 0; i < ventas.size(); i++) {
            System.out.print("("+i+")");
            supplier.get(i).mostrarProveedor(); 
        }
    }

    public ArrayList<Producto> buscarProductos(String filtro){

        ArrayList<Producto> productosEncontrados = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equalsIgnoreCase(filtro) || 
            products.get(i).getCategory().getName_category().equalsIgnoreCase(filtro) ||
            String.valueOf(products.get(i).getPrice()).equalsIgnoreCase(filtro)) {
            productosEncontrados.add(products.get(i));
            }
        }

        return productosEncontrados;
    }

    
}
