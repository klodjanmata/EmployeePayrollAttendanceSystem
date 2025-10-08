package Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee employeeId;
    @Column(name = "Month")
    private String month;

    @Column(name = "Year")
    private int year;

    @Column(name= "Base salary")
    private Float baseSalary;

    @Column(name = "Overtime_Hours")
    private int overtimeHours;

    @Column(name = "Total_Salary")
    private Float totalSalary;

    @Override
    public String toString() {
        return "┌─────────────────────────────────────────┐\n" +
                "│ Payroll ID: " + String.format("%-26s", id) + "│\n" +
                "├─────────────────────────────────────────┤\n" +
                "│ Employee: " + String.format("%-28s", employeeId != null ? employeeId.getName() : "N/A") + "│\n" +
                "│ Employee ID: " + String.format("%-25s", employeeId != null ? employeeId.getId() : "N/A") + "│\n" +
                "│ Period: " + String.format("%-30s", (month != null ? month : "N/A") + " " + year) + "│\n" +
                "│ Base Salary: $" + String.format("%-23s", baseSalary != null ? String.format("%.2f", baseSalary) : "N/A") + "│\n" +
                "│ Overtime Hours: " + String.format("%-22s", overtimeHours) + "│\n" +
                "│ Total Salary: $" + String.format("%-22s", totalSalary != null ? String.format("%.2f", totalSalary) : "N/A") + "│\n" +
                "└─────────────────────────────────────────┘";

    }

}
