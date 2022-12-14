package com.ClubManagement.club.services.membre;
import com.ClubManagement.club.entity.Mailingcontent;
import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.generic.InterfaceGeneric;

import java.util.List;

public interface InterfaceMembre  extends InterfaceGeneric<Membre,Integer> {

    public Membre saveit(Membre membre,String nom_club) throws Exception;

    public List<String> getclubs();
    public void sendEmail(String toEmail,
                          String Subject,
                          String body);

    public  List<Mailingcontent> gethistory(int  a);
}
