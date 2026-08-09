import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private final List<Employee> employees = new ArrayList<>();

    public boolean addEmployee(Employee employee) {
        if (findEmployeeById(employee.getId()) != null) {
            return false;
        }
        employees.add(employee);
        return true;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public List<Employee> findEmployeesByDepartment(String department) {
        List<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getDepartment().equalsIgnoreCase(department)) {
                result.add(employee);
            }
        }

        return result;
    }

    public boolean updateEmployee(int id, String name, String department, double salary) {
        Employee employee = findEmployeeById(id);

        if (employee == null) {
            return false;
        }

        employee.setName(name);
        employee.setDepartment(department);
        employee.setSalary(salary);
        return true;
    }

    public boolean deleteEmployee(int id) {
        Employee employee = findEmployeeById(id);

        if (employee == null) {
            return false;
        }

        employees.remove(employee);
        return true;
    }
}
