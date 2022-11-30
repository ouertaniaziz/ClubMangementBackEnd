package com.ClubManagement.club.repository;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.generic.GenericRepository;

public interface ClubRepository extends GenericRepository<Club, Integer> {

    Club getClubByNomdeclub(String nom_club);
}
