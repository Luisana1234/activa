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
@Entity(name = "fabric_color")
@Table
public class FabricColorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Fabric_color_code")
    private Long id;
    private String garmentDescription;
    private String garmentNotes;


    @ManyToOne
    @JoinColumn(name = "Fabric_code")
    private FabricModel fabricModel;

    @ManyToOne
    @JoinColumn(name = "Color_code")
    private ColorModel colorModel;
    
}
