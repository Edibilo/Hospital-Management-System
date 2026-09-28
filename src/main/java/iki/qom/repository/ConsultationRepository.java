package iki.qom.repository;

import iki.qom.entity.Appointment;
import iki.qom.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
//    @Query("Select c from Consultation c " +
//            "join c.appointment a where a.id=:appointmentId ")
//    List<Consultation> getAllConsultationsByAppointmentId(Long appointmentId);

    List<Consultation> findConsultationByAppointmentId(Long appointmentId);

    Optional<Consultation> findConsultationByAppointmentIdAndId(Long appointmentId, Long consultationId);

}
