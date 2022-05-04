package hw2_4.hw2_4;

import hw2_4.hw2_4.exceptions.EmployeeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    @GetMapping
    public String hello(){
        return "Hello";
    }
    @GetMapping ("employee/add")
        public String addEmployee (@RequestParam ("firstName")String firstName,
                                 @RequestParam("lastName") String lastName) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeException e) {
           return "500 Internal Server Error";
        }
        catch (ArrayIndexOutOfBoundsException e){
            return "404 Not Found.";
        }
    }
    @GetMapping ("employee/delete")
    public String deleteEmployee (@RequestParam ("firstName")String firstName,
                               @RequestParam("lastName") String lastName) {
            return employeeService.deleteEmployee(firstName, lastName);
        }
    @GetMapping ("employee/search")
    public String SearchEmployee (@RequestParam ("firstName")String firstName,
                                  @RequestParam("lastName") String lastName) {
        try {
            return employeeService.searchEmployee(firstName, lastName);
        } catch (ArrayIndexOutOfBoundsException | EmployeeException e) {
            return "404 Not Found";
        }
    }
}
