package com.ani.hms.appointmentmodule.repository;

import com.ani.hms.appointmentmodule.domain.Appointment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTests {
    @Autowired
    private AppointmentRepository repository;

    @DisplayName("Appointment repo : creating ")
    @Test
    public void testCreateAppointment() {
        var appointment = new Appointment();
        appointment.setId(49L);
        appointment.setType("cancer");
        appointment.setAppointment(LocalDate.now());
        appointment.setDoctorName("sandeep");
        appointment.setPlaced(LocalDate.now());

        repository.save(appointment);

    }
}