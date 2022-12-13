package com.ClubManagement.club.repository;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.generic.GenericRepository;

import java.util.List;


public interface ClubRepository extends GenericRepository<Club, Integer> {

    Club getClubByNomdeclub(String nom_club);



}
