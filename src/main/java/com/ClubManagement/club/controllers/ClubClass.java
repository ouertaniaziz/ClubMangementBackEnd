package com.ClubManagement.club.controllers;

import com.ClubManagement.club.entity.Club;

import com.ClubManagement.club.services.club.ImpServiceClub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/club")
public class ClubClass {
    @Autowired
    private ImpServiceClub serviceClub;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Club save(@RequestBody Club club) throws Exception {
        Club ClubResponse = (Club) serviceClub.save(club);
        return ClubResponse;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Club> findAll() {
        try {
            return serviceClub.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteClub(@PathVariable int id) {
        try {
            serviceClub.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "club supprimé";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Club getContrat(@PathVariable int id) throws Exception {
        Club ClubResponse = (Club) serviceClub.retrieve(id);
        return ClubResponse;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String UpdateClub(@RequestBody Club c, @PathVariable int id) {
        try{
            Club updateClub=serviceClub.retrieve(id);
            if (updateClub==null){
                return "Club not found with id :";
            }


            updateClub .setNomdeclub(c.getNomdeclub());
            updateClub.setSpecialite(c.getSpecialite());
            updateClub.setDescription(c.getDescription());
            updateClub.setDate_creation(c.getDate_creation());
            serviceClub.update(updateClub);

        }catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Club modifié ";
    }

    @RequestMapping(value="/getClubsByUniv/{idUniv}", method = RequestMethod.GET)
    public Set<Club> retrieveDepartementByUniversity(@PathVariable Integer idUniv){
        return serviceClub.getClubsByUniversite(idUniv);
    }

    @RequestMapping(value = "/assign/{idUniv}/{id_club}", method = RequestMethod.POST)
        public void addAndAssignClub(@PathVariable int idUniv, @PathVariable int id_club) {
            serviceClub.assignUniversiteToClub(idUniv,id_club);
        }

}
