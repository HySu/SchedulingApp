package com.schedule.SchedulingApp.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Schedule{
    private Long id;
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime createdScheduleDate;
    private LocalDateTime modifyScheduleDate;

    public Schedule(Long id, String username, String title, String contents, LocalDateTime createdScheduleDate, LocalDateTime modifyScheduleDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.createdScheduleDate = createdScheduleDate;
        this.modifyScheduleDate = modifyScheduleDate;
    }

    public Schedule(String username, String title, String contents, String password, LocalDateTime createdScheduleDate, LocalDateTime modifyScheduleDate) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.createdScheduleDate = createdScheduleDate;
        this.modifyScheduleDate = modifyScheduleDate;
    }

    public Schedule(long id, String username, String title, String contents, String password, LocalDateTime createdScheduleDate, LocalDateTime modifyScheduleDate) {
        this.id = id;
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