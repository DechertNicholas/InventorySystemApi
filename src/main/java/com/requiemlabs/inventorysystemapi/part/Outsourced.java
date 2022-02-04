package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class Outsourced extends Part {
    private String CompanyName;

    protected Outsourced(){}

    public Outsourced(String name, float price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.CompanyName = companyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    @Override
    public String toString() {
        return "Outsourced{" +
                "Id=" + this.getId() +
                ", Name='" + getName() + '\'' +
                ", Price=" + getPrice() +
                ", InStock=" + getInStock() +
                ", Min=" + getMin() +
                ", Max=" + getMax() +
                ", CompanyName=" + getCompanyName() +
                '}';
    }
}
