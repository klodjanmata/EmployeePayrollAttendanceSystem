package Services;

import Entity.Attendance;
import Entity.Department;
import Entity.Employee;
import Repository.AttendanceRepository;
import Repository.EmployeeRepository;
import Util.Helper;
import Util.Printer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceServices {
    private HashMap<Long, Attendance> attendances;
    private AttendanceRepository attendanceRepository;
    private EmployeeRepository employeeRepository;

    public AttendanceServices(HashMap<Long, Attendance> attendances) {
        this.attendances = attendances;

    }

    public void addAttendance() {
        System.out.println("Add nessesary attendance information : ");
        Attendance attendance = new Attendance();
        attendance.setDate(Helper.getLocalDateFromUser("Date :"));
        //attendance.setStatus(Helper.getBooleanFromUser("Status :"));
        Boolean status = Helper.getBooleanFromUser("Enter Status true or false");
        if (status == null) {
            System.out.println("Invalid input");
            return;
        }
        attendance.setStatus(status);
        Long id = Helper.getLongFromUser("Employee ID");
        if (employeeRepository.find(id) == null) {
            System.out.println("Employee not found");
            return;
        } else {
            attendance.setEmployeeId(employeeRepository.find(id));
        }
        attendance.setHoursWorked(Helper.getIntFromUser("Worked Hours :"));

        if (attendanceRepository != null) {
            attendanceRepository.create(attendance);
        }
    }


    public void printAll() {
        HashMap<Long, Attendance> attendancesMap = this.attendances;
        for (Attendance attendance : attendancesMap.values()) {
            System.out.println(attendance);
        }
    }

    public void checkAttendance(Long employeeId){
        Attendance attendance = attendances.get(employeeId);
        if(attendance ==null) {
            System.out.println("Attendance record not found for the employee with Id" + employeeId);
            return;
        }
            if(attendance.getStatus()){
            System.out.println("Employee with Id " + employeeId + "is present");
            }else{
            System.out.println("Employee with Id" + employeeId + "is absent");
        }
    }
}//        Boolean status = Helper.getBooleanFromUser("Enter Status");
//            if (status == null) {
//                System.out.println("Invalid input");
//                return;
//            } else if (status) {
//                System.out.println("Employee with ID " + employee.getId() + " is present");
//                return;
//            } else {
//                System.out.println("Employee with ID" + employee.getId() + " is present");
//            }
