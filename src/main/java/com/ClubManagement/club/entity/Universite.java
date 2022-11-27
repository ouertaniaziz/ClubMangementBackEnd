package com.ClubManagement.club.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUniv;
    private String NomUniv;
    private String AdresseUniv;
    private Integer NbrEtudiants;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universite")
    private Set<Club> clubSet;
}
