package Services;

import Entity.Employee;
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
        payroll = payrollRepository.create(payroll);
        payrollsMap.put(payroll.getId(), payroll);
        System.out.println("Payroll added successfully");
    }
    public void printAll() {
        for (Payroll payroll : payrollsMap.values()) {
            System.out.println(payroll);
        }
    }

    public double totalSalary(Payroll payroll){
        if (payroll == null) {
            throw new IllegalArgumentException("Payroll cannot be null");
        }
        
        Float baseSalaryFloat = payroll.getBaseSalary();
        if (baseSalaryFloat == null || baseSalaryFloat <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than 0");
        }
        double baseSalary = baseSalaryFloat;
        
        double overtimeHours = payroll.getOvertimeHours();
        if (overtimeHours == 0){
            return baseSalary;
        }
        
        // Check for null employee or overtime rate
        if (payroll.getEmployeeId() == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (payroll.getEmployeeId().getOvertimeRateId() == null) {
            throw new IllegalArgumentException("Overtime rate is not set for this employee");
        }
        
        // Calculate Regular Hourly Rate (assuming monthly base salary and 160 standard hours per month)
        final double STANDARD_MONTHLY_HOURS = 160.0;
        double regularHourlyRate = baseSalary / STANDARD_MONTHLY_HOURS;
        
        // Overtime Rate = Regular Hourly Rate × multiplier (from OvertimeRate entity)
        Float multiplierFloat = payroll.getEmployeeId().getOvertimeRateId().getRateForHour();
        if (multiplierFloat == null || multiplierFloat <= 0) {
            throw new IllegalArgumentException("Overtime rate multiplier must be greater than 0");
        }
        double multiplier = multiplierFloat;
        double overtimeRate = regularHourlyRate * multiplier;
        
        // Total salary = base salary + (overtime hours × overtime rate)
        return baseSalary + (overtimeHours * overtimeRate);
    }
    public void totalSalary() {
        Long employeeId = Helper.getLongFromUser("Enter Employee Id:");
        Payroll payroll = null;
        
        // Find payroll for the given employee ID
        for (Payroll p : payrollsMap.values()) {
            if (p.getEmployeeId() != null && p.getEmployeeId().getId().equals(employeeId)) {
                payroll = p;
                break;
            }
        }

        if (payroll == null) {
            System.out.println("No payroll found for Employee Id: " + employeeId);
            return;
        }

        try {
            double total = totalSalary(payroll);
            payroll.setTotalSalary((float) total);
            payrollRepository.update(payroll);
            String employeeName = payroll.getEmployeeId() != null && payroll.getEmployeeId().getName() != null 
                ? payroll.getEmployeeId().getName() 
                : "Unknown";
            System.out.println("Total salary for " + employeeName + " is: $" + String.format("%.2f", total));
        } catch (IllegalArgumentException e) {
            System.out.println("Error calculating salary: " + e.getMessage());
        }

    }


}
