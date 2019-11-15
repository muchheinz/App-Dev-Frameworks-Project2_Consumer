package ie.project.project2_consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    int id;
    String name;
    String description;
    LocalDate publishedDate;
}
