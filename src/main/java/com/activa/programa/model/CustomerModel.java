package com.activa.programa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Entity
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_code")
    private Long id;

    private Integer customerId;
    private String customerName;
    private String customerLastName;
    private String customerAddress;
    private String customerContact;
    private Integer customerPhone;

}