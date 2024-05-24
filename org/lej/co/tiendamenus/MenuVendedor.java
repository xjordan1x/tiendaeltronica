package org.lej.co.tiendamenus;

import org.lej.co.electronicstore.TiendaElectronica;
import org.lej.co.models.Product;
import org.lej.co.models.Ventas;

import java.util.List;
import java.util.Scanner;

public class MenuVendedor {
    public static Scanner sc = new Scanner(System.in);
    public static int option;

    public static void menuVendedor(TiendaElectronica tienda){
        List<Product> products = tienda.listarProductos();
        do {
            System.out.println("1. Generar informe de Inventarios");
            System.out.println("2. Realizar Venta");
            System.out.println("3. Cerrar Sesion.");
            System.out.print("Ingrese su opción: ");
            option = sc.nextInt();
            switch (option){
                case 1:
                    System.out.println("Inventario de Productos");
                    String productsI = tienda.generarInventario();
                    System.out.println(productsI);
                    break;
                case 2:
                    if(products.isEmpty()){
                        System.out.println("Aun no hay Productos registrados Para la Venta");
                    }else {
                        Ventas venta = new Ventas();
                        System.out.print("Digita el ID del producto a vender: ");
                        int IDP = sc.nextInt();
                        Product product = tienda.findID(IDP);

                        if(product == null){
                            System.out.println("No existe ningun Producto con ese ID.");
                        }else {
                            System.out.println("En el Stock hay una cantidad de" + product.getStock() +  " del producto");
                            System.out.print("Cuantos deseas llevar?: ");
                            int mount = sc.nextInt();
                            venta.addProduct(product, mount);
                            tienda.crearVentas(venta);
                        }
                    }
                    break;
            }
        }while(option != 3);
    }
}
