package Services;

import Entity.LeaveRequest;
import Repository.EmployeeRepository;
import Repository.LeaveRequestRepository;
import Util.Helper;
import Util.Printer;

import java.util.HashMap;

public class LeaveRequestServices {
    private HashMap<Long, LeaveRequest> attendances;
    private LeaveRequestRepository leaveRequestRepository;
    private EmployeeRepository employeeRepository;

    public void add(){
        System.out.println("Add nessesary att information : ");
        LeaveRequest leaveRequest = new LeaveRequest();
        Printer.printEmployees(employeeRepository.findAll());
        long id = Helper.getLongFromUser("Employee ID");
        if (employeeRepository.find(id) == null){
            System.out.println("Employee not found");
            return;
        }
        else {
            leaveRequest.setEmployeeId(employeeRepository.find(id));
        }
        leaveRequest.setStartDate(Helper.getLocalDateFromUser("Start Date :"));
        leaveRequest.setEndDate(Helper.getLocalDateFromUser("End Date :"));
        leaveRequest.setReason(Helper.getStringFromUser("What is the reason :"));
        leaveRequest.setStatus(Helper.getBooleanFromUser("Status :"));
    }
}

