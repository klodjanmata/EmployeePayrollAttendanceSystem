package Services;

import Entity.OvertimeRate;
import Entity.Payroll;
import Repository.EmployeeRepository;
import Util.Helper;

import java.util.HashMap;

public class PayrollServices {
    private HashMap<Long, Payroll> payrollsMap;
    private EmployeeRepository employeeRepository;
    private Payroll payroll = new Payroll();
    private OvertimeRate overtimeRate = new OvertimeRate();
    private float baseSalary;

    public PayrollServices(HashMap<Long, Payroll> payrollsMap) {
        this.payrollsMap = payrollsMap;
    }


    public void salary() {
        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        overtimeRate.setRateForHour(Helper.getIntFromUser("Put your overtime rate"));

    }

//    public void overtimeRate() {
//        overtimeRate.setRateForHour(Helper.getIntFromUser("Put your overtime rate"));
//    }
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



//    public void add(){
//        System.out.println("Add the necessary payroll information");
//        Payroll payroll = new Payroll();
//        Printer.printEmployees(employeeRepository.findAll());
//        payroll.setMonth(Helper.getStringFromUser("Payment Month"));
//        payroll.setYear(Helper.getIntFromUser("Annual Payment"));
//        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
//        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
//        payroll.setTotalSalary(Helper.getFloatFromUser("Put your total salary"));
//    }

