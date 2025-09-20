import Repository.*;
import Services.*;
import Util.Helper;


public class Application {
    private AttendanceRepository attendanceRepository;
    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private LeaveRequestRepository leaveRequestRepository;
    private OvertimeRateRepository overtimeRateRepository;
    private PayrollRepository payrollRepository;

    private AttendanceServices attendanceServices;
    private EmployeeServices employeeServices;
    private DepartmentServices departmentServices;
    private LeaveRequestServices leaveRequestServices;
    private OvertimeRateServices overtimeRateServices;
    private PayrollServices payrollServices;

    public Application() {
        attendanceRepository = new AttendanceRepository();
        employeeRepository = new EmployeeRepository();
        departmentRepository = new DepartmentRepository();
        leaveRequestRepository = new LeaveRequestRepository();
        overtimeRateRepository = new OvertimeRateRepository();
        payrollRepository = new PayrollRepository();

        attendanceServices = new AttendanceServices(attendanceRepository.findAll());
        employeeServices = new EmployeeServices(employeeRepository.findAll());
        departmentServices = new DepartmentServices(departmentRepository.findAll());
        leaveRequestServices = new LeaveRequestServices(leaveRequestRepository.findAll());
        overtimeRateServices = new OvertimeRateServices(overtimeRateRepository.findAll());
        payrollServices = new PayrollServices(payrollRepository.findAll());


    }

    public static void main(String[] args) {
        Application app = new Application();
        while (true) {
            Menu.mainMenu();
            if(manageAction(getChoice(), app)){
                return;
            }
        }
    }
    private static int getChoice() {
        while(true){
            try{

                int choice = Helper.getIntFromUser("Please enter the number of the choice: ");
                return choice;
            }catch(Exception e){
                System.out.println("Invalid input!TryAgain!");
            }
        }
    }
    private static boolean manageAction(int choice, Application app){
        switch (choice){
            case 1:
                Menu.employeeMenu();
                manageEmployeAction(getChoice(), app);
                break;
            case 2:
                Menu.departmentMenu();
                break;
            case 0:
                System.out.println("Shut Down");
                return true;
            default:
                System.out.println("Invalid choice!");
        }
        return false;
    }

    private static void manageEmployeAction(int choice, Application app){
        switch (choice){
            case 1:
                app.employeeServices.add();
                break;
            case 2:
                app.employeeServices.delete();
                break;


        }
    }

    public void openMenu(){

    }

}





