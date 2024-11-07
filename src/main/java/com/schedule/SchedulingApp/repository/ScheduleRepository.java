package com.schedule.SchedulingApp.repository;

import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    // 일정 등록
    ScheduleResponseDto saveSchedule(Schedule schedule);

    // 일정 전체 목록 가져오기
    List<ScheduleResponseDto> findAllSchedules();

    // 일정 단건 목록 가져오기
    Optional<Schedule> findScheduleById(Long id);

    // 일정 단건 목록 가져오기
    Schedule findScheduleByIdOrElse(Long id);

    // 일정 수정
    int updateSchedule(Long id, String username, String title, String contents, LocalDateTime modifyScheduleDate);

    // 일정 삭제
    int deleteSchedule(Long id);

    // 단건 비밀번호 조회
    String findPasswordById(Long id);
}
