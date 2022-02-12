package com.ani.hms.appointmentmodule.domain;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDate;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false, nullable = false)
    private String type;

    @Column(unique = false, nullable = true)
    private LocalDate placed;

    @Column(unique = false, nullable = false)
    private LocalDate appointment;


    @Column(unique = false, nullable = false)
    private String doctorName;

    @Column(unique = false, nullable = false)
    private String typeName;



}