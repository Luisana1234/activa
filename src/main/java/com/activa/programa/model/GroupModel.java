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
@Entity(name = "group_table")
@Table
public class GroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Group_code")
    private Long id;

    @Column(name = "Group_NIT")
    private Integer groupNit;

    @Column(name = "Group_Name")
    private String groupName;

    @Column(name = "Group_Address")
    private String groupAddress;

    @Column(name = "Group_Phone")
    private Integer groupPhone;

    @Column(name = "Group_Email")
    private String groupEmail;

    @Column(name = "Group_Contact")
    private String groupContact;

    @Column(name = "Group_Type")
    private String groupType;

    @Column(name = "Group_Position")
    private String groupPosition;

}
