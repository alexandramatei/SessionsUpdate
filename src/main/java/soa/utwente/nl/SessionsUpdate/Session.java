package soa.utwente.nl.SessionsUpdate;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Session {
    private Integer sessionId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer requiredNrTAs;
    private List<Integer> assignedTAs;
    private Integer courseId;


    @java.beans.ConstructorProperties({"sessionId", "date", "startTime", "endTime", "requiredNrTAs", "assignedTAs", "courseId"})
    public Session(Integer sessionId, LocalDate date, LocalTime startTime, LocalTime endTime, Integer requiredNrTAs, ArrayList<Integer> assignedTAs, Integer courseId) {
        this.sessionId = sessionId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredNrTAs = requiredNrTAs;
        this.assignedTAs = assignedTAs;
        this.courseId = courseId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getRequiredNrTAs() {
        return requiredNrTAs;
    }

    public void setRequiredNrTAs(Integer requiredNrTAs) {
        this.requiredNrTAs = requiredNrTAs;
    }

    public List<Integer> getAssignedTAs() {
        return assignedTAs;
    }

    public void setAssignedTAs(List<Integer> assignedTAs) {
        this.assignedTAs = assignedTAs;
    }
}
