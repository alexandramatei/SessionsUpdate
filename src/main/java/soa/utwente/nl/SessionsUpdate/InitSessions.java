package soa.utwente.nl.SessionsUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import soa.utwente.nl.SessionsUpdate.Classes.Session;
import soa.utwente.nl.SessionsUpdate.Classes.Subscription;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Component
public class InitSessions {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Autowired private SessionService service;
    @Autowired
    Environment environment;

    @PostConstruct
    public void init() throws UnknownHostException {
        service.createSession(new Session(
                1,
                LocalDate.of(2020,04,01),
                LocalTime.of(13,45,00),
                LocalTime.of(15,30,00),
                7,
                new ArrayList<Integer>(),
                2,
                "NH205"));

        service.createSession(new Session(
                2,
                LocalDate.of(2020,04,01),
                LocalTime.of(15,45,00),
                LocalTime.of(17,30,00),
                5,
                new ArrayList<Integer>(),
                2,
                "NH205"));

        String subscriptionUrl = "http://localhost:8087/subscribe";
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForObject(subscriptionUrl, new Subscription("sessions",  "http://localhost:8082/"), Subscription.class);

}}
