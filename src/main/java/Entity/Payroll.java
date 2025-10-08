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

    @Column(name= "Base_salary")
    private double baseSalary;

    @Column(name = "Overtime_Hours")
    private double overtimeHours;

    @Column(name = "Total_Salary")
    private double totalSalary;

    @Override
    public String toString() {
        return "Total Salary for {" +
                "id = " + Id +
                ", name: " + getEmployeeId().getName() +
                ", department: " + getEmployeeId().getDepartmentId().getName() +
                ", base salary: " + getEmployeeId().getBaseSalary() + "} is " + getTotalSalary() ;
    }

}
