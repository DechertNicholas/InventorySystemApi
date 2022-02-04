package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class InHouse extends Part {
    private int MachineId;

    protected InHouse(){}

    public InHouse(String name, float price, int inStock, int min, int max, int machineId) {
        super(name, price, inStock, min, max);
        this.MachineId = machineId;
    }

    public int getMachineId() {
        return MachineId;
    }

    public void setMachineId(int machineId) {
        MachineId = machineId;
    }

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
}
