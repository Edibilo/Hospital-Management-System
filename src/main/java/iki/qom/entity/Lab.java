package iki.qom.entity;

import iki.qom.enumerator.LabStatus;
import iki.qom.enumerator.LabTest;
import jakarta.persistence.*;

@Entity
@Table(name = "labs")
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LabTest labTest;
    private String result;
    @Enumerated(EnumType.STRING)
    private LabStatus labStatus;
    @ManyToOne
    private Consultation consultation;
    @PrePersist
    void prePersist(){
        if(labStatus==null){
            labStatus=LabStatus.PENDING;
        }
    }

    public Lab(Long id, LabTest labTest, String result, LabStatus labStatus, Consultation consultation) {
        this.id = id;
        this.labTest = labTest;
        this.result = result;
        this.labStatus = labStatus;
        this.consultation = consultation;
    }
    public Lab(){

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

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
