package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@MappedSuperclass
public abstract class Part {
    @Id
    @SequenceGenerator(
            name = "Part_Sequence",
            sequenceName = "Part_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Part_Sequence"
    )
    public long Id;
    public String Name;
    public float Price;
    public int InStock;
    public int Min;
    public int Max;

    protected Part(){}

    public Part(String name, float price, int inStock, int min, int max) {
        this.Name = name;
        this.Price = price;
        this.InStock = inStock;
        this.Min = min;
        this.Max = max;
    }
}
