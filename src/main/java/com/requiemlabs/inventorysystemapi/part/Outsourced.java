package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class Outsourced extends Part {
    // region Private variables
    private String CompanyName;
    // endregion

    // region Constructors

    /**
     * Satisfy the no param constructor requirement. Not meant to be used.
     */
    protected Outsourced(){}

    public Outsourced(String name, float price, int inStock, int min, int max, String companyName) {
        super(name, price, inStock, min, max);
        this.CompanyName = companyName;
    }
    // endregion

    // region Getters and setters
    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        if(companyName != null) {CompanyName = companyName;}
    }
    // endregion

    // region Overrides
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
    // endregion
}
