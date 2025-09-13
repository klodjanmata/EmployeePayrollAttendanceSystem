package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employee_id;
    @Column(name = "date")
    private Date date;
    @Column(name = "status")
    private boolean status;
    @Column(name = "hours_worked")
    private int hours_worked;


}
