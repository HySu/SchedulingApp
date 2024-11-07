package com.schedule.SchedulingApp.dto;

import com.schedule.SchedulingApp.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime createdScheduleDate;
    private LocalDateTime modifyScheduleDate;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.password = schedule.getPassword();
        this.createdScheduleDate = schedule.getCreatedScheduleDate();
        this.modifyScheduleDate = schedule.getModifyScheduleDate();
    }

    public ScheduleResponseDto(long id, String username, String title, String contents, String password, LocalDateTime now, LocalDateTime now1) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.createdScheduleDate = now;
        this.modifyScheduleDate = now1;
    }
}
