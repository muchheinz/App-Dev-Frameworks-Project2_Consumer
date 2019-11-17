package ie.project.project2_consumer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bid {
    private int id;
    private double amount;
    private User user;
    private Job job;
}
