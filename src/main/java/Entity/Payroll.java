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
    private Employee employeeId;
    @Column(name = "Month")
    private String month;
    @Column(name = "Year")
    private int year;
    @Column(name= "Base salary")
    private float baseSalary;
    @Column(name = "OvertimeHours")
    private int overtimeHours;
    @Column(name = "Total Salary")
    private float totalSalary;


}
