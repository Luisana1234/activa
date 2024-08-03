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
@Entity(name = "product_reference")
public class RefProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Product_ref_code")
    private Long productRefCode;
    private String description;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "Product_code")
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "LineType_code")
    private LineTypeModel lineTypeModel;

    @ManyToOne
    @JoinColumn(name = "Measure_code")
    private MeasureModel measureModel;

    @ManyToOne
    @JoinColumn(name = "Size_code")
    private SizeModel sizeModel;

}