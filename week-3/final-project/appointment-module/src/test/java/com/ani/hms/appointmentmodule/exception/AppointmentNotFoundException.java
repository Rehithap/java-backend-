package com.ani.hms.appointmentmodule.exception;

public class AppointmentNotFoundException extends RuntimeException  {

    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
