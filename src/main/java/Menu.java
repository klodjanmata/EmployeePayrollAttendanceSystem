public class Menu {

    public static void mainMenu(){
        System.out.println("\n");
        System.out.println("************* Welcome to Your System *************");
        System.out.println("Choose your action ");
        System.out.println("1.Employee Options");
        System.out.println("2.Department Options");
        System.out.println("0. Shut down");

    }
    public static void employeeMenu(){
        System.out.println("\n");
        System.out.println("************* Welcome to Your EmployeeSystem *************");
        System.out.println("Choose your action ");
        System.out.println("1. Add Employee");
        System.out.println("2. Remove Employee");
        System.out.println("3. Print All Employees");
        System.out.println("4. Check Attendance");
        System.out.println("5. Check your Payroll ");
        System.out.println("6. Check your Over Time Ranting ");
        System.out.println("7. Apply For Leave Request ");
        System.out.println("0. Go back");
    }
    public static void departmentMenu(){
        System.out.println("\n");
        System.out.println("************* Welcome to Your DepartmentSystem *************");
        System.out.println("Choose your action ");
        System.out.println("1. Add Department");
        System.out.println("2. Remove Department");
        System.out.println("3. Print All Departments");
        System.out.println("0. Go back");
    }
}
