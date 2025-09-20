package Services;

import Entity.Department;
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
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeServices {
    private HashMap<Long, Employee> employeeMap;
    private DepartmentRepository departmentRepository;
    private OvertimeRateRepository overtimeRateRepository;

    public EmployeeServices(HashMap<Long, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void add() {
        System.out.println("Add the nessesary employee information : ");
        Employee employee = new Employee();
        Printer.printDepartments((List<Department>) departmentRepository.findAll());
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


        Printer.printOvertimeRate((List<OvertimeRate>) overtimeRateRepository.findAll());
        long idOvertime = Helper.getLongFromUser("Overtime Rate Id");
                if(overtimeRateRepository.find(idOvertime) == null){
                    System.out.println("Overtime Rate does not exist");
                    return;
                }
                else  {
                    employee.setOvertimeRateId(overtimeRateRepository.find(idOvertime));
                }
         }

    }

