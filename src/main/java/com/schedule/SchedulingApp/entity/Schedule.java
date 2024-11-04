import lombok.AllArgsConstructor;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public Schedule{
    private String username;
    private String title;
    private String contents;
    private String password;
    private Datetime created_schedule_date;
    private Datetime modify_schedule_date;
}