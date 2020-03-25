package soa.utwente.nl.SessionsUpdate;

import org.springframework.stereotype.Service;
import soa.utwente.nl.SessionsUpdate.Exceptions.NotFoundException;

import java.util.*;

@Service
public class SessionService {
    private static final Map<Integer, Session> sessions = Collections.synchronizedMap(new HashMap<>());
    private static int idCounter = 1;

    public Session createSession(Session session){
        session.setSessionId(idCounter++);
        sessions.put(session.getSessionId(), session);
        return session;
    }

    public Session updateSession(Session session){
        sessions.put(session.getSessionId(), session);
        return session;
    }

    public void deleteSession(Integer id){
        if(!sessions.containsKey(id)) throw new NotFoundException("Could not find user with id " + id);
        sessions.entrySet().removeIf(x-> x.getKey().equals(id));
    }

    public Session getSession(Integer id){
        if(!sessions.containsKey(id)) throw new NotFoundException("Could not find user with id " + id);
        return sessions.get(id);
    }

    public Integer getSessionRequiredNrTAs(Integer id){
        if(!sessions.containsKey(id)) throw new NotFoundException("Could not find user with id " + id);
        return sessions.get(id).getRequiredNrTAs();
    }

    public Collection<Session> getSessions(Integer courseId){
        return (Collection<Session>) sessions.values().stream().filter(x->courseId.equals(x.getCourseId()));
    }

}
