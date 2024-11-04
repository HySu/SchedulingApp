package com.schedule.SchedulingApp.entity;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Schedule{
    private Long id;
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime created_schedule_date;
    private LocalDateTime modify_schedule_date;

    public Schedule(Long scheduleId, String username, String title, String contents, String password) {
        this.id = scheduleId;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
    }

    public void update(ScheduleRequestDto dto) {
        this.username = dto.getUsername();
        this.title = dto.getTitle();
        this.contents = dto.getContents();
        this.password = dto.getPassword();
    }
}