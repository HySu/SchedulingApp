package com.schedule.SchedulingApp.service;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;
import com.schedule.SchedulingApp.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 등록
    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents(), requestDto.getPassword(), LocalDateTime.now(), LocalDateTime.now());

        Schedule savedSchedule = scheduleRepository.saveSchedule(schedule);

        return new ScheduleResponseDto(savedSchedule);
    }

    // 전체 일정 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();
        return allSchedules;
    }

    // 단건 일정 조회
    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if(schedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        return new ScheduleResponseDto(schedule);
    }

    // 일정 수정
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String username, String title, String contents, String password, LocalDateTime modifyScheduleDate) {
        // schedule 조회
        Schedule schedule = scheduleRepository.findScheduleById(id);

        //NPE 방지
        if(schedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        // 필수값 검증
        if(title == null || contents == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }

        // schedule 수정
        schedule.update(title, contents, modifyScheduleDate);

        return new ScheduleResponseDto(schedule);
    }

    // 일정 제목 수정
    @Override
    public ScheduleResponseDto updateTitle(Long id, String title, String contents, LocalDateTime modifyScheduleDate) {
        // schedule 조회
        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if (schedule == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        //필수값 검증
        if(title == null || contents != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values");
        }

        schedule.updateTitle(title, modifyScheduleDate);

        return new ScheduleResponseDto(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        // schedule 조회
        Schedule schedule = scheduleRepository.findScheduleById(id);

        // NPE 방지
        if(schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        scheduleRepository.deleteSchedule(id);

    }
}
