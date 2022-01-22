package com.ani.hms.appointmentmodule.service;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentService {
    public AppointmentDto createAppointment(AppointmentDto dto);

    LocalDate setAppointment(Long id,LocalDate appointment);

    String cancelAppointment(Long id, String type);

    List<AppointmentDto> getDaysBetweenDates(LocalDate start, LocalDate end);
}

