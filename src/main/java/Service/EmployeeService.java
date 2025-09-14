package Service;

import Entity.Employee;

import java.util.HashMap;

public class EmployeeService {
    private HashMap<String, Employee> employeesMap;

    public EmployeeService(){
        employeesMap = new HashMap<>();
    }
    public EmployeeService(HashMap <String, Employee> employeesMap){
        this.employeesMap = employeesMap;
    }


}

