package iki.qom.dto;

public class DashboardDto {
    private int totalDoctor;
    private int totalDepartment;
    private int totalPatient;
    private int totalAppointments;
    private int pendingAppointments;
    private int inProgressAppointments;
    private int completedAppointments;
    private int totalConsultations;

    public DashboardDto(){

    }

    public DashboardDto(int totalDoctor, int totalDepartment, int totalPatient, int totalAppointments,
                        int pendingAppointments, int inProgressAppointments, int completedAppointments, int totalConsultations) {
        this.totalDoctor = totalDoctor;
        this.totalDepartment = totalDepartment;
        this.totalPatient = totalPatient;
        this.totalAppointments = totalAppointments;
        this.pendingAppointments = pendingAppointments;
        this.inProgressAppointments = inProgressAppointments;
        this.completedAppointments = completedAppointments;
        this.totalConsultations = totalConsultations;
    }

    public int getTotalDoctor() {
        return totalDoctor;
    }

    public void setTotalDoctor(int totalDoctor) {
        this.totalDoctor = totalDoctor;
    }

    public int getTotalDepartment() {
        return totalDepartment;
    }

    public void setTotalDepartment(int totalDepartment) {
        this.totalDepartment = totalDepartment;
    }

    public int getTotalPatient() {
        return totalPatient;
    }

    public void setTotalPatient(int totalPatient) {
        this.totalPatient = totalPatient;
    }

    public int getTotalAppointments() {
        return totalAppointments;
    }

    public void setTotalAppointments(int totalAppointments) {
        this.totalAppointments = totalAppointments;
    }

    public int getPendingAppointments() {
        return pendingAppointments;
    }

    public void setPendingAppointments(int pendingAppointments) {
        this.pendingAppointments = pendingAppointments;
    }

    public int getInProgressAppointments() {
        return inProgressAppointments;
    }

    public void setInProgressAppointments(int inProgressAppointments) {
        this.inProgressAppointments = inProgressAppointments;
    }

    public int getCompletedAppointments() {
        return completedAppointments;
    }

    public void setCompletedAppointments(int completedAppointments) {
        this.completedAppointments = completedAppointments;
    }

    public int getTotalConsultations() {
        return totalConsultations;
    }

    public void setTotalConsultations(int totalConsultations) {
        this.totalConsultations = totalConsultations;
    }
}
