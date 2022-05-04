package hw2_4.hw2_4;

import hw2_4.hw2_4.exceptions.EmployeeException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class EmployeeService implements EmployeeService1 {
    private static final Employee[] storage = new Employee[2];

    @Override
    public String addEmployee(String firstName, String lastName) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = new Employee(firstName, lastName);
                break;
            }
            if (storage[i].equals(storage)){
                throw new EmployeeException();
            }
            if (storage[i] != null)
                throw new EmployeeException();
        }
        return firstName + " " + lastName;
    }

    public String deleteEmployee(String firstName, String lastName) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].equals(storage)) {
                storage[i] = null;
            }
            else
                throw new EmployeeException();
            }
        return null;
    }

    public String searchEmployee(String firstName, String lastName) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null & storage[i] == new Employee(firstName, lastName)) {
                return storage[i].getFirstName() + " " + storage[i].getLastName();
            }
            if (storage[i] != null & storage[i] != new Employee(firstName, lastName)) {
               throw new EmployeeException();
            }
        }return "404 Not Found";
    }
}