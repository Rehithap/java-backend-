package com.ani.hms.appointmentmodule.service;
import com.ani.hms.appointmentmodule.domain.Appointment;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;
import com.ani.hms.appointmentmodule.exception.AppointmentAlreadyExisting;
import com.ani.hms.appointmentmodule.exception.DateOutOfBound;
import com.ani.hms.appointmentmodule.exception.DuplicateException;

import java.time.LocalDate;
import java.util.List;


public interface AppointmentService {
    public AppointmentDto createAppointment(AppointmentDto dto)throws DuplicateException;

    LocalDate setAppointment(Long id, LocalDate appointment, String type) throws DateOutOfBound, AppointmentAlreadyExisting;

    String cancelAppointment(Long id);

    List<Appointment> searchCanceledAppointment();

    List<Appointment> searchAppointmentsByTypeName(String s);


    //  List<AppointmentDto> getDaysBetweenDates(LocalDate start, LocalDate end);

}