package com.ani.hms.appointmentmodule.controller;
import com.ani.hms.appointmentmodule.dto.AppResponse;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;
import com.ani.hms.appointmentmodule.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.Date;

@RequestMapping("/Appointment")
@RestController

public class AppointmentController {
    @Autowired
    private AppointmentService service;
    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@RequestBody AppointmentDto dto) {

        var svObj = service.createAppointment(dto);
        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/setAppoint")
    public ResponseEntity<AppResponse<Date>> activate(@RequestBody AppointmentDto dto) {
        LocalDate stat = service.setAppointment(dto.getId(), dto.getAppointment());
        var response = new AppResponse<Date>();
        response.setMessage("Account Activated");
        response.setStatus(String.valueOf(stat));
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    @PutMapping("/cancelAppoint")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@RequestBody AppointmentDto dto) {
        String stat = service.cancelAppointment(dto.getId(), dto.getType());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
