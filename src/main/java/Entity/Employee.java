package Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "hire_Date")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "Department_id")
    private Department departmentId;

   @ManyToOne
    private OvertimeRate overtimeRateId;

    @Column(name = "base_Salary")
    private Float baseSalary;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return "┌─────────────────────────────────────────┐\n" +
                "│ Employee ID: " + String.format("%-25s", id) + "│\n" +
                "├─────────────────────────────────────────┤\n" +
                "│ Name: " + String.format("%-32s", name != null ? name : "N/A") + "│\n" +
                "│ Email: " + String.format("%-31s", email != null ? email : "N/A") + "│\n" +
                "│ Hire Date: " + String.format("%-27s", hireDate != null ? hireDate.format(formatter) : "N/A") + "│\n" +
                "│ Department: " + String.format("%-26s", departmentId != null ? departmentId.getName() : "N/A") + "│\n" +
                "│ Overtime Rate: " + String.format("%-23s", overtimeRateId != null ? overtimeRateId.getId() : "N/A") + "│\n" +
                "│ Base Salary: $" + String.format("%-24s", baseSalary != null ? String.format("%.2f", baseSalary) : "N/A") + "│\n" +
                "└─────────────────────────────────────────┘";

    }

}
