package Services;

import Entity.Employee;
import Entity.OvertimeRate;
import Entity.Payroll;
import Repository.EmployeeRepository;
import Repository.PayrollRepository;
import Util.Helper;

import java.util.HashMap;

public class PayrollServices {
    private HashMap<Long, Payroll> payrollsMap;
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private PayrollRepository payrollRepository = new PayrollRepository();

    public PayrollServices(HashMap<Long, Payroll> payrollsMap) {
        this.payrollsMap = payrollsMap;
    }

    public void add() {
        System.out.println("Add the necessary Payroll information");
        Long id = Helper.getLongFromUser("Employee Id");
        Employee employee = employeeRepository.find(id);
        if (employee == null) {
            System.out.println("Employee Id does not exist");
            return;
        }
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employee);
        payroll.setMonth(Helper.getStringFromUser("Month"));
        payroll.setYear(Helper.getIntFromUser("Year"));
        payroll.setBaseSalary(employee.getBaseSalary());


        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        payrollRepository.create(payroll);
        payrollsMap.put(payroll.getEmployeeId().getId(), payroll);
        System.out.println("Payroll added successfully");
    }
    public void printAll() {
        for (Payroll payroll : payrollsMap.values()) {
            System.out.println(payroll);
        }
    }

    public double totalSalary(Payroll payroll){
        return payroll.getEmployeeId().getBaseSalary() +
                (payroll.getOvertimeHours() *
                        payroll.getEmployeeId().getOvertimeRateId().getRateForHour());
    }
    public void totalSalary() {
        Long id = Helper.getLongFromUser("Enter Employee Id:");
        Payroll payroll = payrollsMap.get(id);

        if (payroll == null) {
            System.out.println("No payroll found for Employee Id: " + id);
            return;
        }

        double total = totalSalary(payroll);
        System.out.println("Total salary for " + payroll.getEmployeeId().getName() + " is: $" + total);

    }


}
