package com.schedule.SchedulingApp.repository;

import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        // schedule 식별자 자동 생성
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
        schedule.setId(scheduleId);

        scheduleList.put(scheduleId, schedule);

        return schedule;
    }
    
    // 전체 일정 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        // init List
        List<ScheduleResponseDto> allSchedules = new ArrayList<>();

        // HashMap<Schedule> -> List<ScheduleResponseDto>
        for(Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            allSchedules.add(responseDto);
        }

        return allSchedules;
    }
    
    // 단건 일정 조회
    @Override
    public Schedule findScheduleById(Long id) {
        return scheduleList.get(id);
    }
    
    // 일정 삭제
    @Override
    public void deleteSchedule(Long id) {
        scheduleList.remove(id);
    }
}
