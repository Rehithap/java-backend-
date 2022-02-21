package com.ani.hms.appointmentmodule.controller;
import com.ani.hms.appointmentmodule.domain.Appointment;
import com.ani.hms.appointmentmodule.dto.AppResponse;
import com.ani.hms.appointmentmodule.dto.AppointmentBetweenDto;
import com.ani.hms.appointmentmodule.dto.AppointmentDto;
import com.ani.hms.appointmentmodule.exception.AppointmentAlreadyExisting;
import com.ani.hms.appointmentmodule.exception.DateOutOfBound;
import com.ani.hms.appointmentmodule.exception.DuplicateException;
import com.ani.hms.appointmentmodule.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequestMapping("/Appointment")
@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<AppResponse<AppointmentDto>> createAppointment(@Valid @RequestBody AppointmentDto dto) throws DuplicateException {

        var svObj = service.createAppointment(dto);
        var response = new AppResponse<AppointmentDto>();
        response.setStatus("success");
        response.setMessage("Appointment saved successfully");
        response.setBody(svObj);
        return ResponseEntity.ok(response);
    }


    @PutMapping("/SetAppoint")
    public ResponseEntity<AppResponse<LocalDate>> setAppointment(@Valid @RequestBody AppointmentDto dto) throws DateOutOfBound, AppointmentAlreadyExisting {
        try {
            LocalDate stat = service.setAppointment(dto.getId(), dto.getAppointment(), dto.getType());
            var response = new AppResponse<LocalDate>();
            response.setMessage("Appointment is set");
            response.setStatus("success");
            response.setBody(stat);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (DateOutOfBound e) {
            var response = new AppResponse<LocalDate>();
            response.setMessage(e.getMessage());
            response.setStatus("fail");
            // response.setBody("");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (AppointmentAlreadyExisting e) {
            e.printStackTrace();
        }
        return null;
    }


    @PutMapping("/cancelAppoint")
    public ResponseEntity<AppResponse<String>> cancelAppointment(@Valid @RequestBody AppointmentDto dto) throws DateOutOfBound {
        String stat = service.cancelAppointment(dto.getId());
        var response = new AppResponse<String>();
        response.setMessage("Appointment is removed");
        response.setStatus("success");
        response.setBody(stat);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
/*
   @GetMapping("/between")
    public ResponseEntity<AppResponse<List<AppointmentDto>>> findbetween(@RequestBody AppointmentBetweenDto dto){
       var response=new AppResponse<List<AppointmentDto>>();
       response.setStatus("success");
       response.setMessage("List of appointments ");
       response.setBody(service.getDaysBetweenDates(dto.getStart(),dto.getEnd()));
       return  ResponseEntity.ok(response);
    }

 */


    @GetMapping("/searchByType")
    public ResponseEntity<AppResponse<String>> searchAppointmentByTypeName(@RequestParam String type) {
        System.out.println(type);
        List<Appointment> list = service.searchAppointmentsByTypeName(type);
        System.out.println(list.toString());
        var response = new AppResponse<String>();
        response.setStatus("success");
        response.setStatus("Appointment by Type Name");
        response.setList(list);
        //response.setBody(service.get);
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

}