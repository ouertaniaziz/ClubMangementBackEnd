package com.ClubManagement.club.controllers;

import com.ClubManagement.club.entity.Event;

import com.ClubManagement.club.services.sponsor.ImpServiceEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = {"*"})
public class EventClass {

    @Autowired
    private ImpServiceEvent serviceEvent;
    @RequestMapping(value = "/save",method=RequestMethod.POST)
    public Event save (@RequestBody Event event)throws  Exception{
        Event EventResponse=(Event) serviceEvent.save(event);
        return EventResponse;
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List <Event> findAll(){
        try {
            return serviceEvent.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
       public String  deleteEvent (@PathVariable int id ){
        try{
            serviceEvent.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return "event annulé ";
}

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      public Event getEvent (@PathVariable int id )throws Exception{
         Event EventResponse =(Event)  serviceEvent.retrieve(id);
         return EventResponse;
}
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
      public String UpdateEvent (@RequestBody Event event,@PathVariable int id ){
        try{
            Event updateEvent=serviceEvent.retrieve(id);
            if (updateEvent==null){
                return "event not founf with id ";
            }

            updateEvent .setDate_debut_Event(event.getDate_debut_Event());
            updateEvent .setDate_fin_Event(event.getDate_fin_Event());
            updateEvent.setNomEvent(event.getNomEvent());
            updateEvent.setDescription(event.getDescription());
            serviceEvent.update(updateEvent);

        }catch (Exception err) {
            throw new RuntimeException(err);
        }
        return "Event modifié ";
    }
}

