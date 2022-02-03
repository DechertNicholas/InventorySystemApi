package com.requiemlabs.inventorysystemapi.inventory;

public class Outsourced extends Part {
    public String CompanyName;

    public Outsourced(String name, float price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.CompanyName = companyName;
    }
}
