package iki.qom.service.impl;

import iki.qom.dto.FeedbackDto;
import iki.qom.entity.Appointment;
import iki.qom.entity.Feedback;
import iki.qom.enumerator.AppointmentStatus;
import iki.qom.mapper.FeedbackMapper;
import iki.qom.repository.AppointmentRepository;
import iki.qom.repository.FeedbackRepository;
import iki.qom.service.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final AppointmentRepository appointmentRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository, AppointmentRepository appointmentRepository) {
        this.feedbackRepository = feedbackRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public FeedbackDto createFeedback(FeedbackDto feedbackDto) {
        Appointment appointment=appointmentRepository.findById(feedbackDto.getAppointmentId()).orElseThrow(
                () -> new RuntimeException("Appointment Not Found !")
        );
        if(!appointment.getStatus().equals(AppointmentStatus.COMPLETED)){
            throw new RuntimeException("Application Not Completed !");
        }
        Feedback feedback=new Feedback();
        feedback.setRate(feedbackDto.getRate());
        feedback.setComment(feedbackDto.getComment());
        feedback.setAppointment(appointment);
        Feedback savedFeedback=feedbackRepository.save(feedback);
        return FeedbackMapper.mapToFeedBackDto(savedFeedback);
    }
}
