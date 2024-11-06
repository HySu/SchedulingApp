package com.schedule.SchedulingApp.service;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String username, String title, String contents, String password, LocalDateTime modifyScheduleDate);

    ScheduleResponseDto updateTitle(Long id, String title, String contents, LocalDateTime modifyScheduleDate);

    void deleteSchedule(Long id);
}