package com.schedule.SchedulingApp.service;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules();

    ScheduleResponseDto findScheduleById(Long id);

    // 일정 수정
    ScheduleResponseDto updateSchedule(Long id, String username, String title, String contents, String password, LocalDateTime modifyScheduleDate);

    // 일정 삭제
    void deleteSchedule(Long id);
}
