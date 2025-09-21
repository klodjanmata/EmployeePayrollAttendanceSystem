package Services;

import Entity.Attendance;
import Entity.Employee;
import Entity.LeaveRequest;
import Repository.EmployeeRepository;
import Repository.LeaveRequestRepository;
import Util.Helper;
import Util.Printer;

import java.util.HashMap;
import java.util.List;

public class LeaveRequestServices {
    private HashMap<Long, LeaveRequest> leaveRequestsMap;
    private LeaveRequestRepository leaveRequestRepository;
    private EmployeeRepository employeeRepository;

    public LeaveRequestServices(HashMap<Long, LeaveRequest> attendances) {
        this.leaveRequestsMap = leaveRequestsMap;
    }

    public void add(){
        System.out.println("Add nessesary att information: ");
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setStartDate(Helper.getLocalDateFromUser("Start Date: "));
        leaveRequest.setEndDate(Helper.getLocalDateFromUser("End Date: "));
        leaveRequest.setReason(Helper.getStringFromUser("The reason: "));
        leaveRequest.setStatus(Helper.getBooleanFromUser("Status: "));

        Printer.printEmployees((List<Employee>) employeeRepository.findAll());
        long id = Helper.getLongFromUser("Employee ID");
        if (employeeRepository.find(id) == null){
            System.out.println("Employee not found");
            return;
        }
        else {
            leaveRequest.setEmployeeId(employeeRepository.find(id));
        }
    }
    public void printAll(){
        for (LeaveRequest leaveRequest : leaveRequestsMap.values()){
            System.out.println(leaveRequest);
        }
    }
}

