package Services;

import Entity.Department;
import Entity.Employee;
import Entity.OvertimeRate;
import Entity.Payroll;
import Repository.EmployeeRepository;
import Util.Helper;

import java.util.HashMap;

public class PayrollServices {
    private HashMap<Long, Payroll> payrollsMap;
    private EmployeeRepository employeeRepository;
    Payroll payroll = new Payroll();
    private OvertimeRate overtimeRate = new OvertimeRate();
    private float baseSalary;

    public PayrollServices(HashMap<Long, Payroll> payrollsMap) {
        this.payrollsMap = payrollsMap;
    }
    public void add() {
        System.out.println("Add the necessary Payroll information");
        Long id = Helper.getLongFromUser("Employee Id");
        if (employeeRepository.find(id) == null) {
            System.out.println("Employee Id does not exist");
            return;
        } else {
            payroll.setEmployeeId(employeeRepository.find(id));
        }
        payroll.setMonth(Helper.getStringFromUser("Month"));
        payroll.setYear(Helper.getIntFromUser("Year"));
        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        System.out.println("Payroll with employee Id: " + employeeRepository.find(id) + " added successfully");
    }
    public void printAll() {
        for (Payroll payroll : payrollsMap.values()) {
            System.out.println(payroll);
        }
    }
    public void salary() {
        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        overtimeRate.setRateForHour(Helper.getIntFromUser("Put your overtime rate"));

    }
    public float baseSalary(){
        return baseSalary;
    }

    public int overtime() {
        return (int) (payroll.getOvertimeHours() * overtimeRate.getRateForHour());
    }

    public double totalSalary() {
        return payroll.getBaseSalary() + overtime();
    }

    @Override
    public String toString() {
        return "Your total salary is: " + totalSalary();

    }

}