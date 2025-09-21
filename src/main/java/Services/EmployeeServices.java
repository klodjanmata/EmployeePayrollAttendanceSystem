package Services;

import Entity.Attendance;
import Entity.Department;
import Entity.Employee;
import Entity.OvertimeRate;
import Repository.AttendanceRepository;
import Repository.DepartmentRepository;
import Repository.OvertimeRateRepository;
import Repository.PayrollRepository;
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
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private OvertimeRateRepository overtimeRateRepository = new OvertimeRateRepository();
    private AttendanceRepository attendanceRepository = new AttendanceRepository();
    private PayrollRepository payrollRepository = new PayrollRepository();

    public EmployeeServices(HashMap<Long, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void add() {
        System.out.println("Add the nessesary employee information : ");
        Employee employee = new Employee();
        employee.setName(Helper.getStringFromUser("Name of the employee"));
        employee.setEmail(Helper.getStringFromUser("Email of the employee"));
        employee.setHireDate(Helper.getLocalDateFromUser("Hire Date"));
        Long id = Helper.getLongFromUser("DepartmentID");
        if (departmentRepository.find(id) == null) {
            System.out.println("Department does not exist");
            return;
        } else {
            employee.setDepartmentId(departmentRepository.find(id));
        }
        Printer.printOvertimeRate((List<OvertimeRate>) overtimeRateRepository.findAll());
        Long idOvertime = Helper.getLongFromUser("Overtime Rate Id");
        if (overtimeRateRepository.find(idOvertime) == null) {
            System.out.println("Overtime Rate does not exist");
            return;
        } else {
            employee.setOvertimeRateId(overtimeRateRepository.find(idOvertime));
        }
        employee.setBaseSalary(Helper.getLongFromUser("Put your Salary"));
    }

    public void totalSalary(){
        System.out.println();
    }

    public void delete() {
             System.out.println("Delete Employee");
             Long employeeId = Helper.getLongFromUser("Enter employee id to delete");
             if (employeeMap.containsKey(employeeId)) {
                 employeeMap.remove(employeeId);
                 System.out.println("Employee with Id: " + employeeId + " is deleted");
             } else {
                 System.out.println("Employee not found!");
             }

         }
         public void printAll() {
             for (Employee employee : employeeMap.values()) {
                 System.out.println(employee);
             }

         }

}

