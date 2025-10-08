package Services;

import Entity.Employee;
import Entity.LeaveRequest;
import Repository.EmployeeRepository;
import Repository.LeaveRequestRepository;
import Util.Helper;

import java.util.HashMap;

public class LeaveRequestServices {
    private final HashMap<Long, LeaveRequest> leaveRequestsMap;
    private final LeaveRequestRepository leaveRequestRepository;
    private final EmployeeRepository employeeRepository;

    public LeaveRequestServices(HashMap<Long, LeaveRequest> leaveRequestsMap) {
        this.leaveRequestsMap = leaveRequestsMap;
        this.leaveRequestRepository = new LeaveRequestRepository();
        this.employeeRepository = new EmployeeRepository();
    }

    public void add() {
        System.out.println("Apply for leave request: ");

        Long id = Helper.getLongFromUser("Enter your Id");
        Employee employee = employeeRepository.find(id);

        if (employee == null) {
            System.out.println("Employee Id does not exist");
            return;
        }

        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployeeId(employee);
        leaveRequest.setStartDate(Helper.getLocalDateFromUser("Start Date (dd.MM.yyyy): "));
        leaveRequest.setEndDate(Helper.getLocalDateFromUser("End Date (dd.MM.yyyy): "));
        leaveRequest.setReason(Helper.getStringFromUser("The reason: "));

        Boolean status = Helper.getBooleanFromUser("Checking (true/false): ");
        leaveRequest.setStatus(status != null ? status : false);

        leaveRequest = leaveRequestRepository.create(leaveRequest);
        leaveRequestsMap.put(leaveRequest.getId(), leaveRequest);
        if (leaveRequest.isStatus()) {
            System.out.println("Leave request APPROVED for employee with ID: " + leaveRequest.getId());
        } else {
            System.out.println("Leave request NOT APPROVED for employee with ID: " + leaveRequest.getId());
        }
    }

    public void printAll(){
        if (leaveRequestsMap.isEmpty()) {
            System.out.println("No leave requests found.");
            return;
        }

        System.out.println("\n========== Leave Requests ==========");
        for (LeaveRequest leaveRequest : leaveRequestsMap.values()){
            System.out.println(leaveRequest);
        }
        System.out.println("====================================\n");
    }
}

