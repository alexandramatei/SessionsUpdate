package soa.utwente.nl.SessionsUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitSessions {
    @Autowired private SessionService service;

    @PostConstruct
    public void init(){
        service.createSession(new Session(
                1,
                LocalDate.of(2016,12,01),
                LocalTime.of(23,12,56,234),
                LocalTime.of(23,12,56,234),
                7,
                new ArrayList<Integer>(){{
                    add(1);
                    add(2);
                    add(3);
                }},
                2));

}}
