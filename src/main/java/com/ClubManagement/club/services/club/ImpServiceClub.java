package com.ClubManagement.club.services.club;

import com.ClubManagement.club.entity.Club;

import com.ClubManagement.club.entity.Universite;
import com.ClubManagement.club.generic.ImplementationGeneric;
import com.ClubManagement.club.repository.ClubRepository;
import com.ClubManagement.club.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImpServiceClub extends ImplementationGeneric<Club, Integer> implements InterfaceClub {
    @Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    ClubRepository clubRepository;

    @Override
    public Set<Club> getClubsByUniversite(Integer idUniv) {
        Universite universite=universiteRepository.findById(idUniv).orElse(null);
        if(universite!=null){
            return  universite.getClubSet();
        }
        return null;
    }

    @Override
    public void assignUniversiteToClub(Integer idUniv, Integer id_club) {
        Universite universite= universiteRepository.findById(idUniv).orElse(null);
        Club club= clubRepository.findById(id_club).orElse(null);
        if(universite !=null && club!=null){
            universite.getClubSet().add(club);
            universiteRepository.save(universite);
        }
    }
}
