package com.schedule.SchedulingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime created_schedule_date;
    private LocalDateTime modify_schedule_date;
}
