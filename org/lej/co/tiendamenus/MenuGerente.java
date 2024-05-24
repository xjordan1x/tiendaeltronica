package org.lej.co.tiendamenus;

import org.lej.co.electronicstore.TiendaElectronica;
import org.lej.co.models.Product;

import java.util.List;
import java.util.Scanner;

public class MenuGerente {
    public static Scanner sc = new Scanner(System.in);
    public static int option;
    public static void menuGerente(TiendaElectronica tienda){
        List<Product> products = tienda.listarProductos();
        do {
            System.out.println("1. Generar informe de Inventarios");
            System.out.println("2. Generar informe de Ventas");
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
                    String salesReport = tienda.generarReporteVentas();
                    System.out.println(salesReport);
                    break;
            }

        }while(option != 3);
    }
}
