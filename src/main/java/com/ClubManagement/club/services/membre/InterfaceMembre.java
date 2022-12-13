package com.ClubManagement.club.services.membre;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.generic.InterfaceGeneric;

import java.util.List;
import java.util.Set;

public interface InterfaceMembre  extends InterfaceGeneric<Membre,Integer> {

    public Membre saveit(Membre membre,String nom_club) throws Exception;

    public List<String> getclubs();
}
