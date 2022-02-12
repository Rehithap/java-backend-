package com.ani.hms.appointmentmodule.dto;


import com.ani.hms.appointmentmodule.domain.Appointment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse<T> {
    private String status;
    private String message;
    private T body;

    public void setList(List<Appointment> list) {
    }

}
