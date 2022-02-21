package com.ani.hms.appointmentmodule.repository;

import com.ani.hms.appointmentmodule.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
    List<Appointment> findAllByType(String s);
}
