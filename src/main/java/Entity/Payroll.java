package Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToOne
    private Employee employee_id;
    @Column(name = "month")
    private String month;
    @Column(name = "year")
    private int year;
    @Column(name= "base_salary")
    private int base_salary;
    @Column(name = "overtime_hours")
    private int overtime_hours;
    @Column(name = "total salary")
    private int total_salary;


}
