package iki.qom.dto;

public class ConsultationDto {
    private Long id;
    private String symptoms;
    private String diagnosis;
    private String treatmentNotes;
    private String bloodPressure;
    private double temperature;
    private double weight;
    private Long appointmentId;
    private String patientName;

    public ConsultationDto(Long id, String symptoms, String diagnosis, String treatmentNotes, String bloodPressure,
                           double temperature, double weight, Long appointmentId, String patientName) {
        this.id = id;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.treatmentNotes = treatmentNotes;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.weight = weight;
        this.appointmentId = appointmentId;
        this.patientName = patientName;
    }

    public ConsultationDto(){

    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatmentNotes() {
        return treatmentNotes;
    }

    public void setTreatmentNotes(String treatmentNotes) {
        this.treatmentNotes = treatmentNotes;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
