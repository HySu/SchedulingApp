package com.schedule.SchedulingApp.entity;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

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
    private LocalDateTime createdScheduleDate;
    private LocalDateTime modifyScheduleDate;

    public Schedule(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public Schedule(String username, String title, String contents, String password, LocalDateTime createdScheduleDate, LocalDateTime modifyScheduleDate) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.createdScheduleDate = createdScheduleDate;
        this.modifyScheduleDate = modifyScheduleDate;
    }

    public void update(String title, String contents, LocalDateTime modifyScheduleDate){
        this.title = title;
        this.contents = contents;
        this.modifyScheduleDate = modifyScheduleDate;
    }

    public void updateTitle(String title, LocalDateTime modifyScheduleDate) {
        this.title = title;
        this.modifyScheduleDate = modifyScheduleDate;
    }

}