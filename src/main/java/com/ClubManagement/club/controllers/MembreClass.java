package com.ClubManagement.club.controllers;

import com.ClubManagement.club.entity.Membre;
import com.ClubManagement.club.services.membre.InterfaceMembre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membre")
@CrossOrigin(origins = {"*"})
public class MembreClass {
    @Autowired
    private InterfaceMembre interfaceMembre;

    @RequestMapping(value = "/save/{nom}", method = RequestMethod.POST)
    public Membre save(@RequestBody Membre membre,@PathVariable(value = "nom")String nom_club) throws Exception {
        Membre membre1 =  interfaceMembre.saveit(membre,nom_club);
        return membre1;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Membre> findAll() {
        try {
            return interfaceMembre.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletemembre(@PathVariable int id) {
        try {
            interfaceMembre.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Membre supprimé";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getmembre(@PathVariable int id) throws Exception {
        Membre membre =  interfaceMembre.retrieve(id);
        if (membre==null){
            return  ResponseEntity.notFound().build();
        }
        return     ResponseEntity.ok(membre);
    }
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public String updatemembre(@RequestBody Membre membre,@PathVariable int id) {
        try {
            Membre updatemembre= interfaceMembre.retrieve(id);
            if (updatemembre==null){
                return "Membre not found with id :";
            }
                updatemembre.setNom_M(membre.getNom_M());
            updatemembre.setPrenom_M(membre.getPrenom_M());
            updatemembre.setEmail(membre.getEmail());
            updatemembre.setNum_M(membre.getNum_M());
            interfaceMembre.update(updatemembre);


        } catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Membre modifié ";
    }
}
