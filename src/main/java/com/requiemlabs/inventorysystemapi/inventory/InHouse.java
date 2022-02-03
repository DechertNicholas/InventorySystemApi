package com.requiemlabs.inventorysystemapi.inventory;

public class InHouse extends Part {
    public int MachineId;

    public InHouse(String name, float price, int inStock, int min, int max, int machineId) {
        super(name, price, inStock, min, max);
        this.MachineId = machineId;
    }
}
