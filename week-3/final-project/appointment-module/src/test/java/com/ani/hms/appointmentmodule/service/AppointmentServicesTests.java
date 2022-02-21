package com.ani.hms.appointmentmodule.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class AppointmentServicesTests {
    @Test
    void contextLoads() {

    }

}

/*
public class AppointmentServiceTests {
    private TestRestTemplate template;
    private String port;

    @DisplayName("Put - Appointment - updating a appointment")
    @Test
    public void testUpdateAppointMethod() {
        String url = "http://" + "localhost" + ":" + port + "/appointment";
        Appointment appointment = template.getForObject(url, Appointment.class);
        Assertions.assertNotNull(appointment);
    }

    @DisplayName("Put - Appointment - cancel a  appointment")
    @Test
    public void testCancelAppointmentMethod() {
        String url="http://"+"localhost"+":"+port+"/cancelAppointment";
        Appointment appointment=template.getForObject(url,Appointment.class);
        Assertions.assertNotNull(appointment);
    }

}

 */