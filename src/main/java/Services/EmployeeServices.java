package Services;

import Entity.Employee;
import Entity.OvertimeRate;
import Util.Helper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeServices {
    private HashMap<Long, Employee> employeeMap;

    public void add(){
        System.out.println("Add the nessesary employee information : ");
        Employee employee = new Employee();
        employee.setId(Helper.getLongFromUser("ID"));
        employee.setName(Helper.getStringFromUser("Name"));
        employee.setEmail(Helper.getStringFromUser("Email"));
        employee.setHireDate(Helper.getLocalDateFromUser("Hire Date"));
        employee.setDepartmentId(Helper.getDepartment.DepartmentId("Department ID"));
        employee.setBaseSalary(Helper.getLongFromUser("Base Salary"));
       // employee.prin
        employee.setOvertimeRateId(OvertimeRate.valueOf(Helper.getLongFromUser("OvertimeRate")));
        System.out.println();
    }
    public void printAllDepartmentIDs(){
        employeeMap.values().forEach(employee ->
                System.out.println(employee.toString()));
    }

    public void printAll(){
        System.out.println("***Full Employee List***");
        System.out.println("ID\tName\tEmail\tHire Date\tBase Salary\tOvertimeRate");
        for (Employee employee : employeeMap.values()){
            System.out.println(
                    employee.getId()
                    + "\t" + employee.getName()
                    + "\t" + employee.getEmail()
                    + "\t" + employee.getHireDate()
                    + "\t" + employee.getBaseSalary()
                    + "\t" + employee.getDepartmentId()
                    + "\t" + employee.getBaseSalary()
                    + "\t" + employee.getOvertimeRateId());
        }
    }
}

