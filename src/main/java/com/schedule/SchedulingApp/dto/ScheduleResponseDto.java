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
    private LocalDateTime createdScheduleDate;
    private LocalDateTime modifyScheduleDate;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.createdScheduleDate = schedule.getCreatedScheduleDate();
        this.modifyScheduleDate = schedule.getModifyScheduleDate();
    }
}
