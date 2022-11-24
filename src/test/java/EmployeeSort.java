import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee{
    @Getter
       String name;
       Employee(String name){
           this.name=name;
       }

}

public class EmployeeSort {
    String name;

    public static void main(String[] args) {
        //List<String> nameList=defaultSortingDemo();
        List<Employee> employeeList=costomisedSortingDemo();
        for(Employee e:employeeList){
            System.out.println(e.getName());
        }
//        for(String name:nameList){
//            System.out.println(name);
//        }
    }

    private static List<Employee> costomisedSortingDemo() {
        List<Employee> employeeList=new ArrayList();
        employeeList.add(new Employee("Anu"));
        employeeList.add(new Employee("Minu"));
        employeeList.add(new Employee("Cinoj"));
        employeeList.add(new Employee("Jinesh"));
        employeeList.add(new Employee("Advay"));
        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int k=e1.getName().compareTo(e2.getName());
                System.out.println("K :"+k);
                return k;
            }
        });
     return employeeList;
    }


    private static List<String> defaultSortingDemo() {
        List<String>nameList=new ArrayList();
        nameList.add("Sana");
        nameList.add("Aadhya");
        nameList.add("Yana");
        nameList.add("Advay");
        Collections.sort(nameList);
        return nameList;
    }
}
