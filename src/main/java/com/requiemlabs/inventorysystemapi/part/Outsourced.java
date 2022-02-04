package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class Outsourced extends Part {
    public String CompanyName;

    protected Outsourced(){}

    public Outsourced(String name, float price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.CompanyName = companyName;
    }
}
