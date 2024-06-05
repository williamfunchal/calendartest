package com.copilotiq.calendar.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.copilotiq.calendar.models.entities.Schedule;
import com.copilotiq.calendar.services.ScheduleService;

@RestController
public class ScheduleController {
    private ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    /**
     * Return a list of mocked schedules by Date
     * @return List<Schedule>
     */
    @GetMapping("/schedules")
    public List<Schedule> getSchedulesByDate(@RequestParam String date) {
        return scheduleService.getSchedulesByDate(date);
    }

    /**
     * Deletes a schedule by id
     * @param id
     * @return void
     */
    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
    }

    /**
     * Update a schedule by id
     * @param id
     * @param schedule
     * @return void
     */
    @PostMapping("/schedules/{id}")
    public void updateSchedule(@PathVariable int id, @RequestBody Schedule schedule) {
        scheduleService.updateSchedule(id, schedule);
    }

    /**
     * Create a schedule
     * @param schedule
     * @return void
     */
    @PostMapping("/schedules")
    public void createSchedule(@RequestBody Schedule schedule) {
        scheduleService.createSchedule(schedule);
    }
    
}
