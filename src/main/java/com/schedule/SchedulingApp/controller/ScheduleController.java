package com.schedule.SchedulingApp.controller;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 일정 등록
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
        // 식별자가 1씩 증가하도록 만듦
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // Schedule 객체 생성
        Schedule schedule = new Schedule(scheduleId, dto.getUsername(), dto.getTitle(), dto.getContents(), dto.getPassword(), LocalDateTime.now(), LocalDateTime.now());

        //Inmemory DB에 Schedule 스케줄
        scheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    // 전체 일정 조회
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules(){
        // init List
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        // HashMap<Schedule> -> List<ScheduleResponseDto>
        for (Schedule schedule : scheduleList.values()){
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }
        return responseList;
    }

    // 선택 일정 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
        Schedule schedule = scheduleList.get(id);

        if(schedule == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }
    
    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        Schedule schedule = scheduleList.get(id);

        if(schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if(dto.getUsername() == null ||
                dto.getTitle() == null ||
                dto.getContents() == null ||
                dto.getPassword() == null ||
                dto.getCreated_schedule_date() == null ||
                dto.getModify_schedule_date() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        schedule.update(dto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        // scheduleList 의 Key 값에 id 를 포함하고 있다면
        if(scheduleList.containsKey(id)){
            scheduleList.remove(id);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
