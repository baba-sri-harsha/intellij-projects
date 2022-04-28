package com.cameraapp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Camera {
    @Id
    @GeneratedValue(generator="camera_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="camera_gen",sequenceName = "camera_seq",initialValue = 1,allocationSize = 1)
    private Integer cameraId;
    @Column(length =30)
    private String model;
    @Column(length =30)
    private String cameraType;
    @Column(length =30)
    private String lensType;
    @Column(length =30)
    private String brand;
    private double price;

}
