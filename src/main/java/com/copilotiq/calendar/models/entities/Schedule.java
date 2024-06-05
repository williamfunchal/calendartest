package com.copilotiq.calendar.models.entities;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Schedule {
    private int id;
    private Date date;
    private int staffId;
    private int patientId;
}
