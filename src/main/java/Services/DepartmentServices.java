package Services;

import Entity.Department;
import Entity.Employee;
import Repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Util.Helper;

import java.util.HashMap;


@NoArgsConstructor
@Getter
@Setter
public class DepartmentServices {
    private HashMap<Long, Department> departmentsMap;

    public DepartmentServices(HashMap<Long, Department> departmentsMap) {
        this.departmentsMap = departmentsMap;
    }

    public void add() {
        System.out.println("Add the necessary department information");
        Department department = new Department();
        department.setName(Helper.getStringFromUser("Name of the Department"));
        department.setLocation(Helper.getStringFromUser("Location of your Department"));
        DepartmentRepository repository = new DepartmentRepository();
        department = repository.create(department);
        departmentsMap.put(department.getId(), department);
        System.out.println("Department with id: " + department.getId() + " added successfully");
    }

    public void delete() {
        System.out.println("Delete Department");
        Long departmentId = Helper.getLongFromUser("Enter department id to delete");
        if (departmentsMap.containsKey(departmentId)) {
            departmentsMap.remove(departmentId);
            System.out.println("Department with Id: " + departmentId + " is deleted");
        } else {
            System.out.println("Department not found!");
        }
    }
    public void printAll() {
        for (Department department : departmentsMap.values()) {
            System.out.println(department);
        }
    }
}









