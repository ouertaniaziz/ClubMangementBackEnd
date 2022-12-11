package com.ClubManagement.club.repository;

import com.ClubManagement.club.entity.Mailingcontent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MailingRepo extends JpaRepository<Mailingcontent,Integer> {

    List<Mailingcontent> getAllByToEmail(String email);
}
