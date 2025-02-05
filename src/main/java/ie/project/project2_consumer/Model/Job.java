package ie.project.project2_consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private int id;
    private String name;
    private String description;
    private LocalDate publishedDate;
    private User user;
}
