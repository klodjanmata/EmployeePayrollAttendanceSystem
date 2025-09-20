package Services;

import Entity.Department;
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
        departmentsMap.put(department.getId(), department);
        System.out.println("Department with id: " + department.getId() + " added successfully");

    }

}



