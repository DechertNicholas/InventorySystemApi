package com.requiemlabs.inventorysystemapi.part;

import javax.persistence.*;

@MappedSuperclass
public abstract class Part implements Comparable<Part> {
    // region Private variables
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
    private Long Id;
    private String Name;
    private float Price;
    private int InStock;
    private int Min;
    private int Max;
    // endregion

    // region Constructors
    /**
     * Satisfy the no param constructor requirement. Not meant to be used.
     */
    protected Part(){}

    public Part(String name, float price, int inStock, int min, int max) {
        this.Name = name;
        this.Price = price;
        this.InStock = inStock;
        this.Min = min;
        this.Max = max;
    }
    // endregion

    // region Getters and setters
    public Long getId() {
        return Id;
    }

    /**
     * This should never be called intentionally, it is to be set by the database.
     * @param id The automatically set id of the part.
     */
    public void setId(Long id) {
        if (id != null) {Id = id;}
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        if(Name != null) {Name = name;}
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        if(price > 0.0f) {Price = price;}
    }

    public int getInStock() {
        return InStock;
    }

    public void setInStock(int inStock) {
        if(inStock >= 0) {InStock = inStock;}
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int min) {
        if(min >= 0) {Min = min;}
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int max) {
        if(max >= 0) {Max = max;}
    }
    // endregion

    // region Overrides
    @Override
    public int compareTo(Part otherPart) {
        return Long.compare(this.getId(), otherPart.getId());
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
    // endregion
}
