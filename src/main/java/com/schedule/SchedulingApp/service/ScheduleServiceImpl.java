package com.schedule.SchedulingApp.service;

import com.schedule.SchedulingApp.dto.ScheduleRequestDto;
import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;
import com.schedule.SchedulingApp.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 일정 등록
    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getUsername(), dto.getTitle(), dto.getContents(), dto.getPassword(), dto.getCreatedScheduleDate(), dto.getModifyScheduleDate());
        return scheduleRepository.saveSchedule(schedule);
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
        Schedule schedule = scheduleRepository.findScheduleByIdOrElse(id);
        return new ScheduleResponseDto(schedule);
    }

    // 일정 수정
    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String username, String title, String contents, String password, LocalDateTime modifyScheduleDate) {
        // 필수값 검증
        if(username == null || title == null || contents == null || password == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The username, title, contents, password, and modifyScheduleDate are required values.");
        }

        int updatedRow = scheduleRepository.updateSchedule(id, username, title, contents, password, LocalDateTime.now());

        //NPE 방지
        if(updatedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Schedule schedule = scheduleRepository.findScheduleByIdOrElse(id);

        return new ScheduleResponseDto(schedule);
    }

    // 일정 삭제
    @Override
    public void deleteSchedule(Long id) {
        int deletedRow = scheduleRepository.deleteSchedule(id);

        // NPE 방지
        if(deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
    }
}
