package Services;

import Entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import Util.Helper;

import java.util.HashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentServices {
    private HashMap<Long, Department> departmentsMap;


    public void add() {
        System.out.println("Add the necessary department information");
        Department department = new Department();
        department.setId(Helper.getLongFromUser("ID"));
        department.setName(Helper.getStringFromUser("Name of the Department"));
        department.setLocation(Helper.getStringFromUser("Location of your Department"));
        departmentsMap.put(department.getId(), department);
        System.out.println("Department with id: " + department.getId() + " added successfully");

    }

}



