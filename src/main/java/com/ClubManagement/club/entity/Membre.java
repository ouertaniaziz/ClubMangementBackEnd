package com.ClubManagement.club.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id_M;
    private String Nom_M;
    private String Prenom_M;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String num_M;

    @ManyToOne
    @JsonIgnoreProperties("membreSet")
    Club club;

}
