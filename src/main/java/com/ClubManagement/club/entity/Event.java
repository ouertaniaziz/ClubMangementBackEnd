package com.ClubManagement.club.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id_E;
    private String  nomEvent;
    private String date_debut_Event;
    private String date_fin_Event;
    private String Description ;

    @ManyToMany(mappedBy = "eventSet",cascade = CascadeType.ALL)
    private Set<Club> clubSet;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "event")
    private Set<Sponsor> sponsorSet;

}
