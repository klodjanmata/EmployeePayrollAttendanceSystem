package Services;

import Entity.*;
import Repository.*;
import Util.Helper;
import Util.Printer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeServices {
    private HashMap<Long, Employee> employeeMap;
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private OvertimeRateRepository overtimeRateRepository = new OvertimeRateRepository();

    private PayrollRepository payrollRepository = new PayrollRepository();

    public EmployeeServices(HashMap<Long, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void add() {
        System.out.println("Add the necessary employee information : ");
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
        employee.setBaseSalary(Helper.getFloatFromUser("Put your Salary"));


        Printer.printOvertimeRate((new ArrayList<>(overtimeRateRepository.findAll().values())));
        Long overtimeRateID = Helper.getLongFromUser("OvertimeRateID");
        if (overtimeRateRepository.find(overtimeRateID) == null) {
            System.out.println("Overtime rate does not exist");
            return;
        } else {
            employee.setOvertimeRateId(overtimeRateRepository.find(overtimeRateID));
        }

        EmployeeRepository repository = new EmployeeRepository();
        employee = repository.create(employee);
        employeeMap.put(employee.getId(), employee);
        System.out.println("Employee added successfully");


    }

    public void totalSalary(){
        System.out.println();
    }

    public void delete() {
             System.out.println("Delete Employee");
             Long employeeId = Helper.getLongFromUser("Enter employee id to delete");
             if (employeeMap.containsKey(employeeId)) {
                 Employee employee = employeeMap.get(employeeId);
                 EmployeeRepository repository = new EmployeeRepository();
                 repository.delete(employee);
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

