package com.schedule.SchedulingApp.service;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ScheduleService {
    // 일정 등록
    ScheduleResponseDto saveSchedule(ScheduleRequestDto dto);

    // 일정 전체 목록 가져오기
    List<ScheduleResponseDto> findAllSchedules();

    // 일정 단건 목록 가져오기
    ScheduleResponseDto findScheduleById(Long id);

    // 일정 수정
    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto dto);

    // 일정 삭제
    void deleteSchedule(Long id);
}
