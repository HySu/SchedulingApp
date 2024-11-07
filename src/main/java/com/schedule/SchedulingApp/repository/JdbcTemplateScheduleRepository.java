package com.schedule.SchedulingApp.repository;

import com.schedule.SchedulingApp.dto.ScheduleResponseDto;
import com.schedule.SchedulingApp.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



@Repository
public class JdbcTemplateScheduleRepository implements ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 일정 등록
    @Override
    public ScheduleResponseDto saveSchedule(Schedule schedule) {
        // INSERT Query 직접 작성하지 않아도 된다
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedules").usingGeneratedKeyColumns("id");

        LocalDateTime now = LocalDateTime.now();

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", schedule.getUsername());
        parameters.put("title", schedule.getTitle());
        parameters.put("contents", schedule.getContents());
        parameters.put("password", schedule.getPassword());
        parameters.put("created_schedule_date", now);
        parameters.put("modify_schedule_date", now);

        // 저장 후 생성된 key값 Number 타입으로 변환하는 메서드
        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));

        return new ScheduleResponseDto(key.longValue(), schedule.getUsername(), schedule.getTitle(), schedule.getContents(), now, now);
    }

    // 일정 전체 조회
    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        return jdbcTemplate.query("SELECT * FROM schedules", scheduleRowMapper());
    }

    // 일정 단건 조회
    @Override
    public Optional<Schedule> findScheduleById(Long id) {
        List<Schedule> result = jdbcTemplate.query("SELECT * FROM schedules WHERE id = ?", scheduleRowMapperV2(), id);
        return result.stream().findAny();
    }

    // 일정 단건 조회
    @Override
    public Schedule findScheduleByIdOrElse(Long id) {
        List<Schedule> result = jdbcTemplate.query("SELECT * FROM schedules WHERE id = ?", scheduleRowMapperV2(), id);
        return result.stream().findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id));
    }

    // 일정 수정
    @Override
    public int updateSchedule(Long id, String username, String title, String contents, LocalDateTime modifyScheduleDate) {
        return jdbcTemplate.update("UPDATE schedules SET username = ?, title = ?, contents = ?, modify_schedule_date = ? WHERE id = ?", username, title, contents, modifyScheduleDate, id);
    }

    // 일정 삭제
    @Override
    public int deleteSchedule(Long id) {
        return jdbcTemplate.update("DELETE FROM schedules where id = ?", id);
    }

    @Override
    public String findPasswordById(Long id) {
        String result = jdbcTemplate.queryForObject("SELECT password FROM schedules WHERE id = ?", String.class, id);
        return result;
    }

    private RowMapper<ScheduleResponseDto> scheduleRowMapper(){

        return new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new ScheduleResponseDto(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getTimestamp("created_schedule_date").toLocalDateTime(),
                        rs.getTimestamp("modify_schedule_date").toLocalDateTime()
                );
            }
        };
    }

    private RowMapper<Schedule> scheduleRowMapperV2(){
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("title"),
                    rs.getString("contents"),
                    rs.getString("password"),
                    rs.getTimestamp("created_schedule_date").toLocalDateTime(),
                    rs.getTimestamp("modify_schedule_date").toLocalDateTime()
                );
            }
        };
    }

}
