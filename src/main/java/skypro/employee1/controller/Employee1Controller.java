package skypro.employee1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.employee1.model.Employee1;
import skypro.employee1.service.Employee1Service;

import java.util.List;

@RestController
@RequestMapping("/employees1")
public class Employee1Controller {
   private final Employee1Service employee1Service;

    public Employee1Controller(Employee1Service employee1Service) {
        this.employee1Service = employee1Service;
    }
    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName){
        Employee1 result = employee1Service.add(firstName, lastName);
        return generateMessage(result, "успех");
    }

    private String generateMessage(Employee1 result, String успех) {
        return null;
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        boolean result = employee1Service.delete(firstName, lastName);
        return generateMessage(new Employee1(firstName, lastName), "удален");
    }
    @GetMapping("/find")
    public Employee1 find(@RequestParam String firstName, @RequestParam String lastName) {
        return employee1Service.find(firstName, lastName);
    }
    @GetMapping
    public List<Employee1> findAll(){
        return employee1Service.findAll();

    }
}
