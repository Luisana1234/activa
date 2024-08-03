package com.activa.programa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "detail")
@Table
public class DetailModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Detail_code")
    private Long id;
    private String opalDetail;
    private String combinedDetail;
    private String garmentDetail;
    private String embroideryDetail;
    private String embroideryLocation;


    @ManyToOne
    @JoinColumn(name = "Customer_group_code")
    private CustomerGroupModel customerGroupModel;

    @ManyToOne
    @JoinColumn(name = "Product_ref_code")
    private RefProductModel refProductModel;

    @ManyToOne
    @JoinColumn(name = "Color_code")
    private ColorModel colorModel;

    @ManyToOne
    @JoinColumn(name = "Order_code")
    private OrderModel orderModel;
}
