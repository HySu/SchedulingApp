package com.schedule.SchedulingApp.repository;

import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    Optional<Schedule> findScheduleById(Long id);

    Schedule findScheduleByIdOrElse(Long id);

    int updateSchedule(Long id, String username, String title, String contents, String password, LocalDateTime modifyScheduleDate);

    int deleteSchedule(Long id);
}
