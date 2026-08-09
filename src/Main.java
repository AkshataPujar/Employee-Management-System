import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeManager manager = new EmployeeManager();

    public static void main(String[] args) {
        loadSampleData();

        int choice;

        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> viewAllEmployees();
                case 3 -> searchEmployee();
                case 4 -> searchByDepartment();
                case 5 -> updateEmployee();
                case 6 -> deleteEmployee();
                case 7 -> System.out.println("Exiting Employee Management System...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== Employee Management System =====");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Search Employees by Department");
        System.out.println("5. Update Employee");
        System.out.println("6. Delete Employee");
        System.out.println("7. Exit");
    }

    private static void addEmployee() {
        int id = readInt("Enter employee ID: ");

        if (manager.findEmployeeById(id) != null) {
            System.out.println("Employee ID already exists.");
            return;
        }

        String name = readText("Enter employee name: ");
        String department = readText("Enter department: ");
        double salary = readPositiveDouble("Enter salary: ");

        Employee employee = new Employee(id, name, department, salary);

        if (manager.addEmployee(employee)) {
            System.out.println("Employee added successfully.");
        }
    }

    private static void viewAllEmployees() {
        List<Employee> employees = manager.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\n--- Employee List ---");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void searchEmployee() {
        int id = readInt("Enter employee ID: ");
        Employee employee = manager.findEmployeeById(id);

        if (employee == null) {
            System.out.println("Employee not found.");
        } else {
            System.out.println("Employee found:");
            System.out.println(employee);
        }
    }

    private static void searchByDepartment() {
        String department = readText("Enter department: ");
        List<Employee> employees = manager.findEmployeesByDepartment(department);

        if (employees.isEmpty()) {
            System.out.println("No employees found in this department.");
            return;
        }

        System.out.println("\n--- Employees in " + department + " ---");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void updateEmployee() {
        int id = readInt("Enter employee ID to update: ");

        if (manager.findEmployeeById(id) == null) {
            System.out.println("Employee not found.");
            return;
        }

        String name = readText("Enter new name: ");
        String department = readText("Enter new department: ");
        double salary = readPositiveDouble("Enter new salary: ");

        if (manager.updateEmployee(id, name, department, salary)) {
            System.out.println("Employee updated successfully.");
        }
    }

    private static void deleteEmployee() {
        int id = readInt("Enter employee ID to delete: ");

        if (manager.deleteEmployee(id)) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static double readPositiveDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value > 0) {
                    return value;
                }

                System.out.println("Salary must be greater than zero.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    private static void loadSampleData() {
        manager.addEmployee(new Employee(101, "Rahul", "IT", 65000));
        manager.addEmployee(new Employee(102, "Ananya", "HR", 55000));
        manager.addEmployee(new Employee(103, "Vikram", "Finance", 70000));
    }
}
