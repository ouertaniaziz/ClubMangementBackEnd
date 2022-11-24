package com.ClubManagement.club.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_club;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private String nom_club;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;
}
