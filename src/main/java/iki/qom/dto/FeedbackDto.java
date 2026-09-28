package iki.qom.dto;

public class FeedbackDto {
    private Long id;
    private String comment;
    private int rate;
    private Long appointmentId;

    public FeedbackDto(Long id, String comment, int rate, Long appointmentId) {
        this.id = id;
        this.comment = comment;
        this.rate = rate;
        this.appointmentId = appointmentId;
    }

    public FeedbackDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
