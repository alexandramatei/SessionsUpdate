package soa.utwente.nl.SessionsUpdate.REST;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.utwente.nl.SessionsUpdate.Session;
import soa.utwente.nl.SessionsUpdate.SessionService;

import java.util.Collection;

@RestController
public class SessionRestController {

    @Autowired private SessionService service;

    @GetMapping(value = "/session/{id}")
    public Session getSession(@PathVariable Integer id){return service.getSession(id);}

    @GetMapping(value = "course/{courseId}/sessions")
    public Collection<Session> getAllSessions(@PathVariable Integer courseId){return service.getSessions(courseId);}

    @GetMapping(value = "session/RequiredTAs/{id}")
    public Integer getRequiredNrTAs(@PathVariable Integer id){return service.getSessionRequiredNrTAs(id);}

    @PostMapping
            (path="/addSession", consumes = "application/json", produces = "application/json")
    public Session createSession(@RequestBody Session session){return service.createSession(session);}

    @PutMapping(
            path="/updateSession", consumes = "application/json", produces = "application/json")
    public Session updateSession(@RequestBody Session session){return service.updateSession(session);}

    @DeleteMapping(value = "/deleteSession/{id}")
    public void deleteSession(@PathVariable Integer id){service.deleteSession(id);}
}
