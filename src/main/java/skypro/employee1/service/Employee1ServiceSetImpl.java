package skypro.employee1.service;

import org.springframework.stereotype.Service;
import skypro.employee1.exceptions.EmployeeAlreadyAddedException;
import skypro.employee1.exceptions.EmployeeNotFoundException;
import skypro.employee1.exceptions.EmployeeStorageIsFullException;
import skypro.employee1.model.Employee1;

import java.util.*;

@Service
public class Employee1ServiceSetImpl implements Employee1Service {
    private static final int COUNT_EMPLOYEE1 = 5;
    private final Set<Employee1> employee1s = new HashSet<>(COUNT_EMPLOYEE1);

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
    public Employee1 delete(String firstName, String lastName) {
        Employee1 employee1 = new Employee1(firstName, lastName);
        Employee1 findEmployee1 = findEmployee1(employee1);
        if(findEmployee1 != null){
            employee1s.remove(employee1);
            return findEmployee1;
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке " + firstName + lastName);
    }

    private Employee1 findEmployee1(Employee1 employee1) {
        Employee1 findEmployee1 = null;
        for (Employee1 emp : employee1s){
            if(emp.equals(employee1)){
                findEmployee1 = emp;
                break;
            }
        }
        return findEmployee1;
    }

    @Override
    public Employee1 find(String firstName, String lastName) {
        Employee1 employee1 = findEmployee1(new Employee1(firstName, lastName));
        if(employee1 != null){
            return employee1;
        }
        throw new EmployeeNotFoundException("Такого сотрудника не нашли в списке " + firstName + lastName);
    }
    @Override
    public Collection<Employee1> findAll(){

        return Collections.unmodifiableCollection(employee1s);
    }
}
