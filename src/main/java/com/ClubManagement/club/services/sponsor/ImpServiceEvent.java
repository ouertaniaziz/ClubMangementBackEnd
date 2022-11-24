package com.ClubManagement.club.services.sponsor;

import com.ClubManagement.club.entity.Event;
import com.ClubManagement.club.entity.Sponsor;
import com.ClubManagement.club.generic.ImplementationGeneric;
import org.springframework.stereotype.Service;

@Service
public class ImpServiceEvent  extends ImplementationGeneric<Event, Integer> implements InterfaceEvent{
}
