package com.ClubManagement.club.services.membre;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.generic.ImplementationGeneric;
import com.ClubManagement.club.repository.ClubRepository;
import com.ClubManagement.club.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImpServiceMembre extends ImplementationGeneric<Membre,Integer> implements  InterfaceMembre {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Transactional
    public Membre saveit(Membre membre,String nom_club) throws Exception {
         Membre m =   membreRepository.save(membre);
         Club c=  clubRepository.getClubByNomdeclub(nom_club);
         m.setClub(c);
         return  m;

    }

    @Override
    public List<String> getclubs() {
        List<String> sets= new ArrayList<>();
            return sets=clubRepository.findAll().stream().map(club -> club.getNomdeclub())
                    .collect(Collectors.toList());
    }

}
