package org.lej.co.electronicstore;

import org.lej.co.models.Product;
import org.lej.co.models.Usuario;
import org.lej.co.models.Ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TiendaElectronica implements CrudGenerateRepSell {
    private List<Usuario> users;
    private List<Product> products;
    private List<Ventas> ventas;

    public TiendaElectronica() {
        this.users =  new ArrayList<>();
        this.products = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void crearUsuario(Usuario usuario){
        this.users.add(usuario);
    }

    public void crearVentas(Ventas ventas){
        this.ventas.add(ventas);
    }
    //Login
    public Usuario login(String nombre, String contraseña) {
        Usuario usuario = null;
        for (Usuario us : this.users) {
            if (us != null && us.getNombreUsuario().equals(nombre) && us.getContraseña().equals(contraseña)) {
                usuario = us;
                break; // Importante: salir del bucle cuando se encuentra el usuario
            }
        }
        return usuario;
    }

    @Override
    public List<Product> listarProductos() {
        return products;
    }

    @Override
    public Product findID(Integer id) {
        Product resultado = null;
        for(Product produ : products){
           if(produ.getId() != null && produ.getId().equals(id)){
               resultado = produ;
           }
        }
        return resultado;
    }

    @Override
    public void crearProducto(Product producto) {
        this.products.add(producto);
    }

    @Override
    public void editarProducto(Product producto) {
        Product p = this.findID(producto.getId());
        if(p == null){
            System.out.println("No se encontro el producto con el id dado");
        } else {
            p.setName(producto.getName());
            p.setDescription(producto.getDescription());
            p.setPrice(producto.getPrice());
            p.setStock(producto.getStock());
            System.out.println("Producto con el id " + p.getId() + "Editado Correctamente");
        }
    }

    @Override
    public void eliminarProducto(Integer id) {
        Product productoBorrar = this.findID(id);
        if(productoBorrar == null){
            System.out.println("No se encontro el producto con el id dado");
        } else {
            this.products.remove(productoBorrar);
            System.out.println("Producto con el id " + productoBorrar.getId() + "Eliminado Correctamente");
        }
    }

    @Override
    public String generarInventario() {
        if(products.isEmpty()){
            return "Aun no hay Productos registrados.";//exception
        } else {
            StringBuilder sb = new StringBuilder("\nInventario: ");
            for (Product product : products) {
                sb.append("\nID:")
                        .append(product.getId())
                        .append("\nNombre:")
                        .append(product.getName())
                        .append("\nDescripcion:")
                        .append(product.getDescription())
                        .append("\nPrecio:")
                        .append(product.getPrice())
                        .append("\nStock:")
                        .append(product.getStock())
                        .append("\n*****************");
            }
            return sb.toString();
        }
    }

    @Override
    public String generarReporteVentas() {
        if(ventas.isEmpty()){
            return "Aun no hay Ventas registradas."; //exception
        } else {
            StringBuilder sb = new StringBuilder("\nRegistro de Ventas: ");
            for (Ventas sell : ventas) {
                sb.append("\nID:")
                        .append(sell.getId())
                        .append("\nFecha y Hora de la Venta:")
                        .append(sell.getDateHourSold())
                        .append("\n***Producto Vendido*");
                for(Product sellP : sell.getProductsSold()){
                    sb.append("\nID:")
                            .append(sellP.getId())
                            .append("\nNombre:")
                            .append(sellP.getName())
                            .append("\nPrecio unidad:")
                            .append(sellP.getPrice());

                }
                sb.append("\nCantidad Vendida:")
                        .append(sell.getAmountSold())
                        .append("\nTotal del la Venta:")
                        .append(sell.getTotalSales())
                        .append("\n*****************");
            }
            return sb.toString();
        }
    }
}
