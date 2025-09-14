package Services;

import Entity.Payroll;
import Repository.EmployeeRepository;
import Util.Helper;
import Util.Printer;

import java.util.HashMap;

public class PayrollServices {

    //me ja llogarit
    private HashMap<Long, Payroll> payrollsMap;
    private EmployeeRepository employeeRepository;
    public void add(){
        System.out.println("Add the necessary payroll information");
        Payroll payroll = new Payroll();
        Printer.printEmployees(employeeRepository.findAll());
        payroll.setMonth(Helper.getStringFromUser("Payment Month"));
        payroll.setYear(Helper.getIntFromUser("Annual Payment"));
        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        payroll.setTotalSalary(Helper.getFloatFromUser("Put your total salary"));
    }
}
