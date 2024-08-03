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
@Entity(name = "size")
public class SizeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Size_code")
    private Long sizeCode;
    private Integer sizeValue;
    private String sizeNotes;
    private String sizeSpecifications;

}