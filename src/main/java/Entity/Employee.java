package Entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;
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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "hireDate")
    private LocalDate hireDate;

    @OneToOne
    private Department departmentId;

    @Column(name = "baseSalary")
    private long baseSalary;

    @OneToOne
    private OvertimeRate overtimeRateId;


  //  public static String printAllValues() {
    //    return Arrays.toString(Employee.values());
   // }




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
