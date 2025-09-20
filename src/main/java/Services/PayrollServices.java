package Services;

import Entity.Employee;
import Entity.Payroll;
import Repository.EmployeeRepository;
import Util.Helper;
import Util.Printer;

import java.util.HashMap;
import java.util.List;

public class PayrollServices {

    //me ja llogarit
    private HashMap<Long, Payroll> payrollsMap;
    private EmployeeRepository employeeRepository;

    public PayrollServices(HashMap<Long, Payroll> payrollsMap) {
        this.payrollsMap = payrollsMap;
    }

    public void add(){
        System.out.println("Add the necessary payroll information");
        Payroll payroll = new Payroll();
        Printer.printEmployees((List<Employee>) employeeRepository.findAll());
        payroll.setMonth(Helper.getStringFromUser("Payment Month"));
        payroll.setYear(Helper.getIntFromUser("Annual Payment"));
        payroll.setBaseSalary(Helper.getFloatFromUser("Put your base salary"));
        payroll.setOvertimeHours(Helper.getIntFromUser("Put your overtime hours"));
        payroll.setTotalSalary(Helper.getFloatFromUser("Put your total salary"));
    }
}
