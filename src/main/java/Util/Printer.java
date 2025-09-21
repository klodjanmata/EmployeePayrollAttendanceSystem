package Util;

import Entity.*;

import java.util.HashMap;
import java.util.List;

public class Printer {

    public static void printDepartments(List<Department> departments) {
        System.out.println("The Departments List");
        System.out.println("ID\tName\tLocation");
        for (Department department : departments) {
            System.out.println(
                    department.getId() + "\t" +
                            department.getName() + "\t" +
                            department.getLocation() + "\t"
            );
        }
    }

    public static void printEmployees(List<Employee> employees) {
        System.out.println("***Full Employee List***");
        System.out.println("ID\tName\tEmail\tHire Date\tBase Salary\tOvertimeRate");
        for (Employee employee : employees) {
            System.out.println(
                    employee.getId()
                            + "\t" + employee.getName()
                            + "\t" + employee.getEmail()
                            + "\t" + employee.getHireDate()
                            + "\t" + employee.getBaseSalary()
                            + "\t" + employee.getDepartmentId()
                            + "\t" + employee.getBaseSalary()
                            + "\t" + employee.getOvertimeRateId());
        }
    }

    public static void printAttendances(List<Attendance> attendances) {
        System.out.println("***Full Employee List***");
        System.out.println("ID\tEmployeeId\tDate\tStatus\tHours Worked");
        for (Attendance attendance : attendances) {
            System.out.println(
                    attendance.getId()
                            + "\t" + attendance.getEmployeeId()
                            + "\t" + attendance.getDate()
                            + "\t" + attendance.getStatus()
                            + "\t" + attendance.getHoursWorked());
        }
    }

    public static void printLeaveRequest(List<LeaveRequest> leaveRequests) {
        System.out.println("***Full Employee List***");
        System.out.println("ID\tEmployeeId\tStart Date\tEnd Date\tReason\tStatus");
        for (LeaveRequest leaveRequest : leaveRequests) {
            System.out.println(
                    leaveRequest.getId()
                            + "\t" + leaveRequest.getEmployeeId()
                            + "\t" + leaveRequest.getStartDate()
                            + "\t" + leaveRequest.getEndDate()
                            + "\t" + leaveRequest.getReason()
                            + "\t" + leaveRequest.isStatus());
        }
    }

    public static void printOvertimeRate(List<OvertimeRate> overtimeRates) {
        System.out.println("Overtime Rates List");
        System.out.println("ID\tDescription\tRate For Hours");
        for (OvertimeRate overtimeRate : overtimeRates) {
            System.out.println(
                    overtimeRate.getId()
                            + "\t" + overtimeRate.getDescription()
                            + "\t" + overtimeRate.getRateForHour()
            );
        }
    }
}