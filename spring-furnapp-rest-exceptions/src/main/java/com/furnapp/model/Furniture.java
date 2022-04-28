package com.furnapp.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedQuery(
        name="CostFromCategory",
        query="select sum(f.price) from Furniture f where f.category=?1"
)
public class Furniture {
    @Column(length = 30)
    private String name; // 4 seater dining table
    @Column(length = 30)
    private String category;// chai , table , bed
    @Column(length = 30)
    private String roomType; // living, bed, kitchen
    private String material;// wood, steel ,plastic
    @Id
    @GeneratedValue(generator = "furniture_app", strategy= GenerationType.AUTO)
    @SequenceGenerator(name="furniture_gen",sequenceName = "furniture_app",initialValue = 2,allocationSize = 1)
    private Integer furnitureId;
    @Column(length = 30)
    @Enumerated
    private Style style;//modren, contempoaray

    private String brand;
    private  double price ;
    @Column(length = 30)
    private boolean storageAvailable;

    public Furniture(String name, String category, String roomType, String material, Style style, String brand, double price, boolean storageAvailable) {
        this.name = name;
        this.category = category;
        this.roomType = roomType;
        this.material = material;
        this.style = style;
        this.brand = brand;
        this.price = price;
        this.storageAvailable = storageAvailable;
    }
}
