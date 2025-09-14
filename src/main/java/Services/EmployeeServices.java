package Services;

import Entity.Employee;
import Entity.OvertimeRate;
import Repository.DepartmentRepository;
import Repository.OvertimeRateRepository;
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
    private OvertimeRateRepository overtimeRateRepository;

    public void add() {
        System.out.println("Add the nessesary employee information : ");
        Employee employee = new Employee();
        long id = Helper.getLongFromUser("DepartmentID");
        if (departmentRepository.find(id) == null) {
            System.out.println("Department does not exist");
            return;

        } else {
            employee.setDepartmentId(departmentRepository.find(id));
        }
        employee.setName(Helper.getStringFromUser("Name"));
        employee.setEmail(Helper.getStringFromUser("Email"));
        employee.setHireDate(Helper.getLocalDateFromUser("Hire Date"));
        Printer.printDepartments(departmentRepository.findAll());


        Printer.printOvertimeRate(overtimeRateRepository.findAll());
    }

}

