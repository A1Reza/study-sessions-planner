package ir.reza.studyplanner.model;

public class StudySession {

    private Long id;
    private Long subjectId;
    private int minutes;
    private String notes;

    public StudySession() {
    }

    public StudySession(Long id, Long subjectId, int minutes, String notes) {
        this.id = id;
        this.subjectId = subjectId;
        this.minutes = minutes;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}