package skypro.employee1.service;

import org.springframework.stereotype.Service;
import skypro.employee1.exceptions.EmployeeAlreadyAddedException;
import skypro.employee1.exceptions.EmployeeNotFoundException;
import skypro.employee1.exceptions.EmployeeStorageIsFullException;
import skypro.employee1.model.Employee1;

import java.util.*;
@Service
public class Employee1ServiceImpl implements Employee1Service {
    private static final int COUNT_EMPLOYEE1 = 5;
    private List<Employee1> employee1s = new ArrayList<>(COUNT_EMPLOYEE1);

    @Override
    public Employee1 add(String firstName, String lastName) {
        if(employee1s.size() >= COUNT_EMPLOYEE1){
            throw new EmployeeStorageIsFullException("EmployeeStorageIsFullException");
        }
        Employee1 employee1 = new Employee1(firstName, lastName);
        if(employee1s.contains(employee1)){
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAddedException");
        }
        employee1s.add(employee1);
        return employee1;
    }

    @Override
    public boolean delete(String firstName, String lastName) {
        Employee1 employee2 = new Employee1(firstName, lastName);
boolean deleted = false;
        Iterator<Employee1> employee1Iterator = employee1s.iterator();
        while (employee1Iterator.hasNext()){
            Employee1 employee1 = employee1Iterator.next();
            if(employee1.equals(employee2)){
                employee1Iterator.remove();
                deleted = true;
            }
        }
//        for(Employee1 employee1 : employee1s){
//            if(employee1.equals(employee2)){
//                employee1s.remove(employee1);
//            }
//        }
        return deleted;
    }

    @Override
    public Employee1 find(String firstName, String lastName) {
        Employee1 employee2 = new Employee1(firstName, lastName);
        for(Employee1 employee1 : employee1s){
            if(employee1.equals(employee2)){
                return employee1;
            }
        }
        throw new EmployeeNotFoundException("EmployeeNotFoundException");
    }
    @Override
    public List<Employee1> findAll(){
        return Collections.unmodifiableList(employee1s);
    }
}
