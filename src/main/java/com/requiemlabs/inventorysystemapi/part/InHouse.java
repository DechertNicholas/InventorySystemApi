package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class InHouse extends Part {
    // region Private variables
    private int MachineId;
    // endregion

    // region Constructors

    /**
     * Satisfy the no param constructor requirement. Not meant to be used.
     */
    protected InHouse(){}

    public InHouse(String name, float price, int inStock, int min, int max, int machineId) {
        super(name, price, inStock, min, max);
        this.MachineId = machineId;
    }
    // endregion

    // region Getters and setters
    public int getMachineId() {
        return MachineId;
    }

    public void setMachineId(int machineId) {
        if(machineId > 0) {MachineId = machineId;}
    }
    // endregion

    // region Overrides
    @Override
    public String toString() {
        return "InHouse{" +
                "Id=" + this.getId() +
                ", Name='" + getName() + '\'' +
                ", Price=" + getPrice() +
                ", InStock=" + getInStock() +
                ", Min=" + getMin() +
                ", Max=" + getMax() +
                ", MachineId=" + getMachineId() +
                '}';
    }
    // endregion
}
