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
@Entity(name = "customer_group")
@Table
public class CustomerGroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_group_code")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Customer_code")
    private CustomerModel customerModel;

    @ManyToOne
    @JoinColumn(name = "Group_code")
    private GroupModel groupModel;
}
    
