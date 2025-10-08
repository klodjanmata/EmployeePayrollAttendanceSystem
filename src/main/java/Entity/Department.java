package Entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity


@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column (name = "name")
    private String name;

    @Column (name = "location")
    private String location;

    @Override
    public String toString() {
        return "┌─────────────────────────────────────────┐\n" +
                "│ Department ID: " + String.format("%-23s", Id) + "│\n" +
                "├─────────────────────────────────────────┤\n" +
                "│ Name: " + String.format("%-32s", name != null ? name : "N/A") + "│\n" +
                "│ Location: " + String.format("%-28s", location != null ? location : "N/A") + "│\n" +
                "└─────────────────────────────────────────┘";
    }

}
