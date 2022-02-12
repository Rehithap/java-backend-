package com.ani.hms.appointmentmodule.exceptions;

public class AppointmentNotFoundException extends AppointmentException {

    public AppointmentNotFoundException(String message) {
        super(message);
    }

    public AppointmentNotFoundException(String message, Throwable cause) {
        super(message);
    }
}
