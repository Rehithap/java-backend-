package com.ani.hms.appointmentmodule.service;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;

import java.time.LocalDate;

public interface AppointmentService {
    public AppointmentDto createAppointment(AppointmentDto dto);

    LocalDate setAppointment(Long id,LocalDate appointment);

    String cancelAppointment(Long id, String type);
}

