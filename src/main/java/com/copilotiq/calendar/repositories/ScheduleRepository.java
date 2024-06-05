package com.copilotiq.calendar.repositories;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.copilotiq.calendar.models.entities.Schedule;

@Service
public class ScheduleRepository {
    List<Schedule> schedules;

    /*
     * Constructor 
     * Create 4 schedules based on current date
     */
    public ScheduleRepository() {
        Instant date = Instant.now();
        //transform date instant to sql date
        Date dateSQL = new Date(date.toEpochMilli());

         //Create 4 dates based on date parameter and sum 15 minutes for each one
         Date date1 = new Date(dateSQL.getTime() + 15 * 60 * 1000);
         Date date2 = new Date(dateSQL.getTime() + 30 * 60 * 1000);
         Date date3 = new Date(dateSQL.getTime() + 45 * 60 * 1000);
         Date date4 = new Date(dateSQL.getTime() + 60 * 60 * 1000);

        schedules = new ArrayList<>();
        schedules.add(new Schedule(1, date1, 1, 1));
        schedules.add(new Schedule(2, date2, 2, 2));
        schedules.add(new Schedule(3, date3, 3, 3));
        schedules.add(new Schedule(4, date4, 4, 4));
            
    }

    /**
     * Return a list of mocked schedules by Date
     * @param date
     * @return List<Schedule>
     */
    public List<Schedule> getSchedules(Date date) {
        return schedules;
    }

    /**
     * Deletes a schedule by id
     * @param id
     * @return void
     */
    public void deleteSchedule(int id) {
        schedules.removeIf(schedule -> schedule.getId() == id);
    }

    /**
     * Update a schedule by id
     * @param id
     * @param schedule
     */
    public void updateSchedule(int id, Schedule schedule) {
        for (int i = 0; i < schedules.size(); i++) {
            if (schedules.get(i).getId() == id) {
                schedules.set(i, schedule);
                break;
            }
        }
    }

    /**
     * Create a schedule
     * @param schedule
     */
    public void createSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

}
