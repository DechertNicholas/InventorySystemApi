package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@Entity
@Table
public class InHouse extends Part {
    public int MachineId;

    protected InHouse(){}

    public InHouse(String name, float price, int inStock, int min, int max, int machineId) {
        super(name, price, inStock, min, max);
        this.MachineId = machineId;
    }
}
