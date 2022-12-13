package com.ClubManagement.club.services.club;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.generic.InterfaceGeneric;

import java.util.List;
import java.util.Set;

public interface InterfaceClub extends InterfaceGeneric<Club,Integer> {

    Set<Club> getClubsByUniversite(Integer idUniv);
    void assignUniversiteToClub(Integer idUniv, Integer id_club);
}
