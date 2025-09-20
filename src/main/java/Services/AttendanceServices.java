package Services;

import Entity.Attendance;
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

    public void add(){
        System.out.println("Add nessesary att information : ");
        Attendance attendance = new Attendance();
        Printer.printEmployees((List<Employee>) employeeRepository.findAll());
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
