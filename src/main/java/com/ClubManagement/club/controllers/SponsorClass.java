package com.ClubManagement.club.controllers;

import com.ClubManagement.club.entity.Sponsor;
import com.ClubManagement.club.services.sponsor.ImpServiceSponsor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sponsor")
@CrossOrigin(origins = {"*"})
public class SponsorClass {

    @Autowired
    private ImpServiceSponsor serviceSponsor;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Sponsor save(@RequestBody Sponsor Spon) throws Exception {
        Sponsor SponsorResponse = (Sponsor) serviceSponsor.save(Spon);
        return SponsorResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Sponsor> findAll() {
        try {
            return serviceSponsor.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteSponsor(@PathVariable int id) {
        try {
            serviceSponsor.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "sponsor supprimé";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Sponsor getContrat(@PathVariable int id) throws Exception {
        Sponsor SponsorResponse = (Sponsor) serviceSponsor.retrieve(id);
        return SponsorResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateSponsor(@RequestBody Sponsor s,@PathVariable int id) {
        try {
            Sponsor updateSponsor= serviceSponsor.retrieve(id);
            if (updateSponsor==null){
                return "Sponsor not found with id :";
            }
            updateSponsor.setLabelle(s.getLabelle());
            updateSponsor.setCategorieSponsor(s.getCategorieSponsor());
            updateSponsor.setMontant(s.getMontant());
            serviceSponsor.update(updateSponsor);


        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Sponsor modifié ";
    }

}
