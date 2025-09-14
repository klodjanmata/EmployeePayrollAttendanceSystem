package Services;

import Entity.Attendance;
import Repository.AttendanceRepository;
import Repository.EmployeeRepository;
import Util.Helper;
import Util.Printer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttendanceServices {
    private HashMap<Long, Attendance> attendances;
    private AttendanceRepository attendanceRepository;
    private EmployeeRepository employeeRepository;

    public void add(){
        System.out.println("Add nessesary att information : ");
        Attendance attendance = new Attendance();
        Printer.printEmployees(employeeRepository.findAll());
        long id = Helper.getLongFromUser("Employee ID");
        if (employeeRepository.find(id) == null){
            System.out.println("Employee not found");
            return;
        }
        else {
            attendance.setEmployeeId(employeeRepository.find(id));
        }
        attendance.setDate(Helper.getLocalDateFromUser("Date :"));
        attendance.setStatus(Helper.getBooleanFromUser("Status :"));
        attendance.setHoursWorked(Helper.getIntFromUser("Worked Hours :"));
    }
}
