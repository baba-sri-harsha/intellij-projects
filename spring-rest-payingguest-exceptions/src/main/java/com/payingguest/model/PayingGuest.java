package com.payingguest.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PayingGuest {
    @Id
    @GeneratedValue(generator="payingguest_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="payingguest_gen",sequenceName ="payingguest_seq",initialValue = 1,allocationSize = 1)
    private Integer id;
    @Column(length=40)
    private String name;
    @Column(length=60)
    private String address;
    @Column(length=30)
    private String city;
    @Column(length=30)
    private String type;
    @Column(length=30)
    private int rating;
    private int totalRooms;
    private double price;
    @Column(length=40)
    private String roomShare;// double, triple
    @Column(length=40)
    private String facilities;// - hotwater, wifi laundry
    @Column(length=40)
    private String category;// working or proffessinal
}
