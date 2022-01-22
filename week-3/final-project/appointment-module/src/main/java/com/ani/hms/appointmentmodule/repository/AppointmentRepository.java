package com.ani.hms.appointmentmodule.repository;
import com.ani.hms.appointmentmodule.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
}
