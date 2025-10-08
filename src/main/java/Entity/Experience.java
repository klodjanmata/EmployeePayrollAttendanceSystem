package Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Table (name = "experinece")
public class Experience {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Employee employee;

    @Column(name = "hire_date")
    private LocalDate hireDate;


}
