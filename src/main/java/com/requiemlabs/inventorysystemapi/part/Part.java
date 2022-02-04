package com.requiemlabs.inventorysystemapi.part;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@MappedSuperclass
//@JsonAutoDetect(getterVisibility= JsonAutoDetect.Visibility.NONE)
public abstract class Part implements Comparable<Part> {
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
    private int Id;
    private String Name;
    private float Price;
    private int InStock;
    private int Min;
    private int Max;

    protected Part(){}

    public Part(String name, float price, int inStock, int min, int max) {
        this.Name = name;
        this.Price = price;
        this.InStock = inStock;
        this.Min = min;
        this.Max = max;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        InStock = inStock;
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int min) {
        Min = min;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        Max = max;
    }

    @Override
    public int compareTo(Part otherPart) {
        return Integer.compare(this.getId(), otherPart.getId());
    }

    @Override
    public String toString() {
        return "Part{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", InStock=" + InStock +
                ", Min=" + Min +
                ", Max=" + Max +
                '}';
    }
}
