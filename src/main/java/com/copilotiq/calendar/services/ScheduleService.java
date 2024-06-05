package com.copilotiq.calendar.services;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.copilotiq.calendar.models.entities.Schedule;
import com.copilotiq.calendar.repositories.ScheduleRepository;
import com.copilotiq.calendar.utils.DateUtils;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private DateUtils dateUtils;

    public ScheduleService(ScheduleRepository scheduleRepository, DateUtils dateUtils) {
        this.scheduleRepository = scheduleRepository;
        this.dateUtils = dateUtils;
    }

    /**
     * Return a list of mocked schedules by Date
     * @param date
     * @return List<Schedule>
     */
    public List<Schedule> getSchedulesByDate(String date) {        
        return scheduleRepository.getSchedules(
            dateUtils.stringToDate(date)
        );
    }

    /**
     * Deletes a schedule by id
     * @param id
     * @return void
     */
    public void deleteSchedule(int id) {
        scheduleRepository.deleteSchedule(id);
    }

    /**
     * Update a schedule by id
     * @param id
     * @param schedule
     * @return void
     */
    public void updateSchedule(int id, Schedule schedule) {
        scheduleRepository.updateSchedule(id, schedule);
    }

    /**
     * Create a schedule
     * @param schedule
     * @return void
     */
    public void createSchedule(Schedule schedule) {
        scheduleRepository.createSchedule(schedule);
    }
    
}
