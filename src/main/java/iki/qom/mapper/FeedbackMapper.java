package iki.qom.mapper;

import iki.qom.dto.FeedbackDto;
import iki.qom.entity.Feedback;

public class FeedbackMapper {

    public static Feedback mapToFeedback(FeedbackDto feedbackDto){
        Feedback feedback=new Feedback();
        feedback.setId(feedbackDto.getId());
        feedback.setComment(feedbackDto.getComment());
        feedback.setRate(feedbackDto.getRate());
        return feedback;
    }

    public static FeedbackDto mapToFeedBackDto(Feedback feedback){
        FeedbackDto feedbackDto=new FeedbackDto();
        feedbackDto.setAppointmentId(feedback.getAppointment().getId());
        feedbackDto.setComment(feedback.getComment());
        feedbackDto.setId(feedback.getId());
        feedbackDto.setRate(feedback.getRate());
        return feedbackDto;
    }
}
