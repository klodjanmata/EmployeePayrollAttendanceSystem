package Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @Column (name = "hire_date")
    private Date hireDate;

    @OneToOne
    private Department departmentId;

    @Column (name = "base_salary")
    private long baseSalary;



    @Override
    public String toString() {
        return "Employee {"+
                "id = "+id+
                ", name = "+ name + '\''+
                ", email = "+ email + '\''+
                ", hire date = "+ hireDate + '\''+
                ", department id  = "+ departmentId + '\''+
                ", base salary = "+ baseSalary + '}';

    }




}
