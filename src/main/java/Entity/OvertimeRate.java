package Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "overtime_rate")
public class OvertimeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "description")
    private String description;

    @Column(name = "rate_for_hour")
    private double rateForHour;

}
