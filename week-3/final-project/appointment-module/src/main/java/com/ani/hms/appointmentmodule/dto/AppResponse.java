package com.ani.hms.appointmentmodule.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AppResponse<T> {

    private String status;
    private String message;
    private T body;

    public void setStatus(String success) {
    }

    public void setStatus(LocalDate stat) {
    }

}
