package Services;

import Entity.Employee;
import Entity.OvertimeRate;
import Repository.DepartmentRepository;
import Util.Helper;
import Util.Printer;
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
    private DepartmentRepository departmentRepository;

    public void add(){
        System.out.println("Add the nessesary employee information : ");
        Employee employee = new Employee();
        employee.setName(Helper.getStringFromUser("Name"));
        employee.setEmail(Helper.getStringFromUser("Email"));
        employee.setHireDate(Helper.getLocalDateFromUser("Hire Date"));
        Printer.printDepartments(departmentRepository.findAll());
        employee.setDepartmentId(departmentRepository.find(Helper.getLongFromUser("Department ID")) == null ?
                departmentRepository.find(1L) :
                departmentRepository.find(Helper.getLongFromUser("Department ID")));
        employee.setBaseSalary(Helper.getLongFromUser("Base Salary"));
       // TODO print all overtime rates than chose id
        employee.setOvertimeRateId(OvertimeRate.valueOf(Helper.getLongFromUser("OvertimeRate")));
        System.out.println();
    }
    public void printAllDepartmentIDs(){
        employeeMap.values().forEach(employee ->
                System.out.println(employee.toString()));
    }


}

