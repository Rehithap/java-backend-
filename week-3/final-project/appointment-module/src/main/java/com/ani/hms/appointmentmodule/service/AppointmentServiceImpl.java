package com.ani.hms.appointmentmodule.service;

import com.ani.hms.appointmentmodule.domain.Appointment;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;
import com.ani.hms.appointmentmodule.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService{
    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDto createAppointment(AppointmentDto dto) {

        var appointment=new Appointment();
        appointment.setType(dto.getType());
        appointment.setAppointment(dto.getAppointment());
        appointment.setPlaced(dto.getPlaced());
        appointment.setDoctorName(dto.getDoctorName());

        repository.save(appointment);
        return dto;
    }

    @Override

    public LocalDate setAppointment(Long id,LocalDate appointment) {
        Optional<Appointment> op = repository.findById(id);
        Appointment baOld=op.orElseThrow();

        LocalDate existingAppointment = baOld.getAppointment();
        LocalDate newAppointment = appointment;
        Appointment baNew = new Appointment();
        baNew.setAppointment(appointment);
        baNew.setId(baOld.getId());
        baNew.setType(baOld.getType());
        baNew.setPlaced(baOld.getPlaced());
        baNew.setDoctorName(baOld.getDoctorName());

        repository.save(baNew);

        return baNew.getAppointment();
    }
    @Override

    public String cancelAppointment(Long id, String type) {
        Optional<Appointment> op = repository.findById(id);
        Appointment apOld = op.orElseThrow();
        String existingType = apOld.getType();
        String newType = type;
        Appointment apNew = new Appointment();
        apNew.setAppointment(apOld.getAppointment());
        apNew.setId(apOld.getId());
        apNew.setType(newType);
        apNew.setPlaced(apOld.getPlaced());
        apNew.setDoctorName(apOld.getDoctorName());
        repository.save(apNew);
        return apNew.getType();
    }

}