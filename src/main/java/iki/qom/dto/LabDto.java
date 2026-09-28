package iki.qom.dto;

import iki.qom.enumerator.LabStatus;
import iki.qom.enumerator.LabTest;

public class LabDto {
    private Long id;
    private LabTest labTest;
    private String result;
    private LabStatus labStatus;
    private Long consultationId;

    public LabDto(Long id, LabTest labTest, String result, LabStatus labStatus, Long consultationId) {
        this.id = id;
        this.labTest = labTest;
        this.result = result;
        this.labStatus = labStatus;
        this.consultationId = consultationId;
    }

    public LabDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LabStatus getLabStatus() {
        return labStatus;
    }

    public void setLabStatus(LabStatus labStatus) {
        this.labStatus = labStatus;
    }

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }
}
