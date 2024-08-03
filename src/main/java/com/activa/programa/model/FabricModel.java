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
@Entity(name = "fabric")
@Table
public class FabricModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fabric_code")
    private Long id;
    private String fabricType;
    private String fabricComposition;
    private String fabricNotes;
}
