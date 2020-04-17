package soa.utwente.nl.SessionsUpdate;

import org.springframework.stereotype.Service;
import soa.utwente.nl.SessionsUpdate.Classes.Session;
import soa.utwente.nl.SessionsUpdate.Exceptions.NotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SessionService {
    private static final List<Session> sessions = new ArrayList<>();

    public Session createSession(Session session){
        sessions.add(session);
        return session;
    }

    public Session updateSession(Session session){
        sessions.set(session.getSessionId(), session);
        return session;
    }

    public Session getSession(Integer id){
        return sessions.stream().filter(session -> session.getSessionId() == id).findFirst().orElseThrow(NotFoundException::new);
    }

    public void deleteSession(Integer id){
        sessions.remove(getSession(id));
    }

    public Integer getSessionRequiredNrTAs(Integer id){
        return getSession(id).getRequiredNrTAs();
    }

    public List<Session> getSessionsCourse(Integer courseId){
        return sessions.stream().filter(session -> session.getCourseId() == courseId).collect(Collectors.toList());
    }

    public boolean updateTAs(int id, List<Integer> assignedTAs){
        getSession(id).setAssignedTAs(assignedTAs);
        return true;
    }
}
