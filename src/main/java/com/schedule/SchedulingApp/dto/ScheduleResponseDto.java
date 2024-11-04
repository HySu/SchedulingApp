package com.schedule.SchedulingApp.dto;

import com.schedule.SchedulingApp.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime created_schedule_date;
    private LocalDateTime modify_schedule_date;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.password = schedule.getPassword();
        this.created_schedule_date = schedule.getCreated_schedule_date();
        this.modify_schedule_date = schedule.getModify_schedule_date();
    }
}
