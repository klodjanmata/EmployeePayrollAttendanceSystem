package Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "hireDate")
    private LocalDate hireDate;

    @ManyToOne
    private Department departmentId;

   @ManyToOne
    private OvertimeRate overtimeRateId;

    @Column(name = "baseSalary")
    private long baseSalary;

    @Override
    public String toString() {
        return "Employee {"+
                "id = "+Id+
                ", name = "+ name + '\''+
                ", email = "+ email + '\''+
                ", hire date = "+ hireDate + '\''+
                ", department id  = "+ departmentId + '\''+
                ", base salary = "+ baseSalary + '}';

    }

}
