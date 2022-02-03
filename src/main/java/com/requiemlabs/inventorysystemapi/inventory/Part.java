package com.requiemlabs.inventorysystemapi.inventory;

public abstract class Part {
    public int PartId;
    public String Name;
    public float Price;
    public int InStock;
    public int Min;
    public int Max;

    public Part(String name, float price, int inStock, int min, int max) {
        this.Name = name;
        this.Price = price;
        this.InStock = inStock;
        this.Min = min;
        this.Max = max;
    }
}
