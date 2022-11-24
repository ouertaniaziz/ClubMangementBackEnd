package com.ClubManagement.club.services.membre;

import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.generic.ImplementationGeneric;
import org.springframework.stereotype.Service;

@Service
public class ImpServiceMembre extends ImplementationGeneric<Membre,Integer> implements  InterfaceMembre {
}
