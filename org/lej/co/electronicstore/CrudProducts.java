package org.lej.co.electronicstore;

import org.lej.co.models.Product;

import java.util.List;

public interface CrudProducts {
    List<Product> listarProductos();
    Product findID(Integer id);
    void crearProducto(Product producto);
    void editarProducto(Product producto);
    void eliminarProducto(Integer id);
}
