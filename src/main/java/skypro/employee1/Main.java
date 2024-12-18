package skypro.employee1;

import skypro.employee1.model.Employee1;
import skypro.employee1.service.Employee1ServiceImpl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee1 employee1 = new Employee1("Andrey", "Aivazov");
        Employee1 employee11 = new Employee1("Victor", "Belozerov");
        Employee1 employee12 = new Employee1("Yura", "Volkov");
        HashMap<String, Employee1> objectObjectHashMap = new LinkedHashMap<>();
        objectObjectHashMap.put("123", employee1);
        objectObjectHashMap.put("1234", employee11);
        System.out.println(objectObjectHashMap);

        Employee1ServiceImpl employee1Service = new Employee1ServiceImpl();
        employee1Service.add("Andrey", "Aivazov");
        employee1Service.add("Victor", "Belozer");
        employee1Service.add("Yu", "Volkov");

        employee1Service.delete("Victor", "Belozer");

        employee1Service.add("Victor", "Belozer");
        List<Employee1> employee1ServiceAll = employee1Service.findAll();
        System.out.println(employee1Service.findAll());
    }
}
