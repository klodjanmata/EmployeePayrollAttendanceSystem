package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "leave_request")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Employee employeeId;

    @Column(name = "start_Date")
    private LocalDate startDate;

    @Column(name = "end_Date")
    private LocalDate endDate;

    @Column(name = "reason")
    private String reason;

    @Column(name = "status")
    private boolean status;

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        return "┌─────────────────────────────────────────┐\n" +
                "│ Leave Request ID: " + String.format("%-20s", id) + "│\n" +
                "├─────────────────────────────────────────┤\n" +
                "│ Employee: " + String.format("%-28s", employeeId != null ? employeeId.getName() : "N/A") + "│\n" +
                "│ Employee ID: " + String.format("%-25s", employeeId != null ? employeeId.getId() : "N/A") + "│\n" +
                "│ Start Date: " + String.format("%-26s", startDate != null ? startDate.format(formatter) : "N/A") + "│\n" +
                "│ End Date: " + String.format("%-28s", endDate != null ? endDate.format(formatter) : "N/A") + "│\n" +
                "│ Reason: " + String.format("%-30s", reason != null ? reason : "N/A") + "│\n" +
                "│ Status: " + String.format("%-30s", status ? "APPROVED ✓" : "NOT APPROVED ✗") + "│\n" +
                "└─────────────────────────────────────────┘";

    }
}