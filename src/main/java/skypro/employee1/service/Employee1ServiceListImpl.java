package skypro.employee1.service;

import org.springframework.stereotype.Service;
import skypro.employee1.exceptions.EmployeeAlreadyAddedException;
import skypro.employee1.exceptions.EmployeeNotFoundException;
import skypro.employee1.exceptions.EmployeeStorageIsFullException;
import skypro.employee1.model.Employee1;

import java.util.*;

@Service
public class Employee1ServiceListImpl implements Employee1Service {
    private static final int COUNT_EMPLOYEE1 = 5;
    private Map<String, Employee1> employee1s = new HashMap<>(COUNT_EMPLOYEE1);

    @Override
    public Employee1 add(String firstName, String lastName) {
        if(employee1s.size() >= COUNT_EMPLOYEE1){
            throw new EmployeeStorageIsFullException("EmployeeStorageIsFullException");
        }
        Employee1 employee1 = new Employee1(firstName, lastName);
        if(employee1s.containsKey(firstName + lastName)){
            throw new EmployeeAlreadyAddedException("EmployeeAlreadyAddedException");
        }
        employee1s.put(firstName + lastName, employee1);
        return employee1;
    }

    @Override
    public Employee1 delete(String firstName, String lastName) {
        Employee1 remove = employee1s.remove(firstName + lastName);
        if(remove != null){
            return remove;
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в списке " + firstName + lastName);
    }

    @Override
    public Employee1 find(String firstName, String lastName) {
        Employee1 employee1 = employee1s.get(firstName + lastName);
        if(employee1 != null){
            return employee1;
        }
        throw new EmployeeNotFoundException("Такого сотрудника не нашли в списке " + firstName + lastName);
    }
    @Override
    public Collections<Employee1> findAll(){
        return Collections.unmodifiableCollection(employee1s.values());
    }
}
