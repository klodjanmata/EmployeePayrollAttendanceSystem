package Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "overtime_rate")
public class OvertimeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "rate_for_hour")
    private Float rateForHour;

    @Override
    public String toString() {
        return "┌─────────────────────────────────────────┐\n" +
                "│ Overtime Rate ID: " + String.format("%-20s", id) + "│\n" +
                "├─────────────────────────────────────────┤\n" +
                "│ Description: " + String.format("%-25s", description != null ? description : "N/A") + "│\n" +
                "│ Rate per Hour: " + String.format("%-21s", rateForHour != null ? String.format("%.2f", rateForHour) : "N/A") + "│\n" +
                "└─────────────────────────────────────────┘";
    }
}
