import Entity.Employee;
import Entity.OvertimeRate;
import Entity.Payroll;
import Repository.*;
import Services.*;
import Util.Helper;
import jakarta.persistence.Id;

import java.util.HashMap;


public class Application {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;
    private LeaveRequestRepository leaveRequestRepository;
    private OvertimeRateRepository overtimeRateRepository;
    private PayrollRepository payrollRepository;


    private EmployeeServices employeeServices;
    private DepartmentServices departmentServices;
    private LeaveRequestServices leaveRequestServices;
    private OvertimeRateServices overtimeRateServices;
    private PayrollServices payrollServices;

    public Application() {

        employeeRepository = new EmployeeRepository();
        departmentRepository = new DepartmentRepository();
        leaveRequestRepository = new LeaveRequestRepository();
        overtimeRateRepository = new OvertimeRateRepository();
        payrollRepository = new PayrollRepository();

        employeeServices = new EmployeeServices(employeeRepository.findAll());
        departmentServices = new DepartmentServices(departmentRepository.findAll());
        leaveRequestServices = new LeaveRequestServices(leaveRequestRepository.findAll());
        overtimeRateServices = new OvertimeRateServices(overtimeRateRepository.findAll());
        payrollServices = new PayrollServices((HashMap<Long, Payroll>) payrollRepository.findAll());
    }


    public static void main(String[] args) {
        Application app = new Application();
        while (true) {
            Menu.mainMenu();
            if (manageAction(getChoice(), app)) {
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
                manageDepartmentAction(getChoice(), app);
                break;
            case 3:
                Menu.toolsMenu();
                manageToolsAction(getChoice(), app);
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
                case 3:
                    app.employeeServices.printAll();
                    break;
                case 0:
                System.out.println("Go back");
                 default:
                System.out.println("Invalid choice!");

        }
    }
    private static void manageToolsAction(int choice, Application app){
        switch(choice){
            case 1:
                app.payrollServices.add();
                break;
            case 2:
                app.payrollServices.add();
                break;
            case 3:
                app.overtimeRateServices.create();
                break;
            case 4:
                app.overtimeRateServices.printAll();
                break;
            case 5:
                app.leaveRequestServices.add();
                break;
            case 6:
                app.leaveRequestServices.printAll();
                break;
            case 0:
                System.out.println("Go back");
            default:
                System.out.println("Invalid choice!");
        }
    }
    private static void manageDepartmentAction(int choice, Application app) {
        switch (choice) {
            case 1:
                app.departmentServices.add();
                break;
            case 2:
                app.departmentServices.delete();
                break;
            case 3:
                app.departmentServices.printAll();
                break;
            case 0:
                System.out.println("Go back");
            default:
                System.out.println("Invalid choice!");
        }
    }
}





