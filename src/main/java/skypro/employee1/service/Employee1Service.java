package skypro.employee1.service;

import skypro.employee1.model.Employee1;

import java.util.List;

public interface Employee1Service {
    Employee1 add(String firstName, String lastName);
    boolean delete(String firstName, String lastName);
    Employee1 find(String firstName, String lastName);

    List<Employee1> findAll();
}
