package com.ClubManagement.club.services.membre;

import com.ClubManagement.club.entity.Club;
import com.ClubManagement.club.entity.Mailingcontent;
import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.generic.ImplementationGeneric;
import com.ClubManagement.club.repository.ClubRepository;
import com.ClubManagement.club.repository.MailingRepo;
import com.ClubManagement.club.repository.MembreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImpServiceMembre extends ImplementationGeneric<Membre,Integer> implements  InterfaceMembre {
    @Autowired
    private MembreRepository membreRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private MailingRepo mailingRepo;
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

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail,
                          String Subject,
                          String body
                          ){

        log.info("sending mail to {} ,subject is :{}",toEmail,Subject);
        SimpleMailMessage message =  new SimpleMailMessage();
        message.setFrom("andy.houssem@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(Subject);

        javaMailSender.send(message);

        Mailingcontent mailingcontent= new Mailingcontent();
        mailingcontent.setBody(body);
        mailingcontent.setSubject(Subject);
        mailingcontent.setToEmail(toEmail);
        mailingRepo.save(mailingcontent);
    }

    @Override
    public  List<Mailingcontent> gethistory(int a) {
        Membre m = membreRepository.findById(a).orElse(null);

        List<Mailingcontent> mailingcontents = mailingRepo.getAllByToEmail(m.getEmail());
        return mailingcontents;

    }

}
