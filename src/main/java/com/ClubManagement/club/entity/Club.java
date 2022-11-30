package com.ClubManagement.club.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private String nomdeclub;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_creation;

    @ManyToOne
    Universite universite;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "club")
    private Set<Membre> membreSet;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Event> eventSet;
}
