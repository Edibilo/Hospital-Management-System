package iki.qom.service.impl;

import iki.qom.dto.AppointmentDto;
import iki.qom.dto.AppointmentProjectionDto;
import iki.qom.entity.Appointment;
import iki.qom.entity.User;
import iki.qom.mapper.AppointmentMapper;
import iki.qom.repository.AppointmentRepository;
import iki.qom.repository.UserRepository;
import iki.qom.service.AppointmentService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(UserRepository userRepository, AppointmentRepository appointmentRepository) {
        this.userRepository = userRepository;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void createAppointment(AppointmentDto appointmentDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email = authentication.getName();
        User patient = userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        User doctor = userRepository.findById(appointmentDto.getDoctorId()).orElseThrow(
                () -> new RuntimeException("Doctor Not Found !")
        );
        if (appointmentRepository.existsByDateStartTimeEndTimeAndDoctorId(
                appointmentDto.getAppointmentDate(), appointmentDto.getStartTime(),
                appointmentDto.getEndTime(), doctor.getId())) {
            throw new RuntimeException("That time Already Booked !");
        }
        Appointment appointment = new Appointment();
        appointment.setAppointmentDate(appointmentDto.getAppointmentDate());
        appointment.setStartTime(appointmentDto.getStartTime());
        appointment.setEndTime(appointmentDto.getEndTime());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
        AppointmentMapper.mapToAppointmentDto(appointment);
    }

    @Override
    public List<AppointmentProjectionDto> getAllPatientAppointments() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email = authentication.getName();
        User patient = userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return appointmentRepository.getAllPatientAppointments(patient);
    }

    @Override
    public List<AppointmentProjectionDto> getAllDoctorAppointments() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email = authentication.getName();
        User doctor = userRepository.findUserByEmail(email).orElseThrow(
                () -> new RuntimeException("User Not Found !")
        );
        return appointmentRepository.getAllDoctorAppointments(doctor);
    }


}
