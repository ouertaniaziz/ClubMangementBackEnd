package com.ClubManagement.club.controllers;

import com.ClubManagement.club.entity.Sponsor;
import com.ClubManagement.club.entity.Universite;
import com.ClubManagement.club.serviceUniv.ImpServiceUniversite;
import com.ClubManagement.club.services.sponsor.ImpServiceSponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Universite")
public class UniversiteController {
    @Autowired
    private ImpServiceUniversite serviceUniversite;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Universite save(@RequestBody Universite universite) throws Exception {
        Universite UniversiteResponse = (Universite) serviceUniversite.save(universite);
        return UniversiteResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Universite> findAll() {
        try {
            return serviceUniversite.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUniversite(@PathVariable int id) {
        try {
            serviceUniversite.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Universite supprimé!";
    }

    @RequestMapping(value = "/{idUniv}", method = RequestMethod.GET)
    public Universite getidUniv(@PathVariable int idUniv) throws Exception {
        Universite UniversiteResponse = (Universite) serviceUniversite.retrieve(idUniv);
        return UniversiteResponse;
    }

    @RequestMapping(value = "/edit/{idUniv}", method = RequestMethod.PUT)
    public String UpdateUniv(@RequestBody Universite u ,@PathVariable int idUniv) {
        try {
            Universite updateUniv= serviceUniversite.retrieve(idUniv);
            if (updateUniv==null){
                return "Universite not found with idUniv :";
            }
            updateUniv.setIdUniv(u.getIdUniv());
            updateUniv.setNomUniv(u.getNomUniv());
            updateUniv.setAdresseUniv(u.getAdresseUniv());
            updateUniv.setNbrEtudiants(u.getNbrEtudiants());
            serviceUniversite.update(updateUniv);


        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Universite modifié ";
    }

}

