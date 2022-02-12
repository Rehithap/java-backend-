package com.ani.hms.appointmentmodule.repository;
import com.ani.hms.appointmentmodule.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    List<Appointment> findByAppointmentBetween(LocalDate start, LocalDate end);

    List<Appointment> findByTypeName(String s);
}
