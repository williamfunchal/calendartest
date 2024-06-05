package com.copilotiq.calendar.models.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Patient {
    private int id;
    private String name;
    private String email;
}
