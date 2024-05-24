package org.lej.co.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ventas extends BaseSell {
    private List<Product> productsSold;
    private double totalSales;
    private Date date;
    private SimpleDateFormat dateFormat;
    private String dateHourSold;
    private int amountSold;

    public Ventas() {
        this.productsSold = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = new Date();
        this.dateHourSold = dateFormat.format(date);
    }
    public List<Product> getProductsSold() {
        return productsSold;
    }

    public String getDateHourSold() {
        return dateHourSold;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void addProduct(Product product, int mount){
        if(product.getStock() == 0){
            System.out.println("No se puede Generar venta por que el producto se agoto");
        } else {
            this.productsSold.add(product);//add producto to the productsSold List
            this.amountSold = mount;//amount sold
            int productMount = product.getStock();//get the current amount of the Product
            product.setStock(productMount - amountSold);//less amount to the Product
            System.out.println("Venta realizada con exito!, Total a pagar " + this.totalSell(amountSold, product));
        }
    }

    public double totalSell(int mount, Product product){
        this.totalSales = mount* product.getPrice();
        return totalSales;
    }
}
