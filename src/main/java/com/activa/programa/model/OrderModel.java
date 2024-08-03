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
@Entity(name = "order_table")
@Table
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_code")
    private Long id;
    private Integer requestCode;
    private Integer orderNumber;
    private String orderAdvisor;
    private String orderApproved;
    private String orderProductionDate;
    private String orderArrivalDate;

}
