package com.schedule.SchedulingApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
    private LocalDateTime createdScheduleDate;
    private LocalDateTime modifyScheduleDate;
}
