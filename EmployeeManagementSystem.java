package baimoi1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private String name;
    private int id;
    private String contact;
    // Add more employee details as needed

    public Employee(String name, int id, String contact) {
        this.name = name;
        this.id = id;
        this.contact = contact;
    }

    // Getters and Setters for employee details
    // ...

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", Contact: " + contact;
    }
}

public class EmployeeManagementSystem {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("**Welcome to the Employee Management System**");
            System.out.println("1). Add Employee to the Database");
            System.out.println("2). Search for Employee");
            System.out.println("3). Edit Employee Details");
            System.out.println("4). Delete Employee Details");
            System.out.println("5). Display all Employees working in this company");
            System.out.println("6). EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ems.addEmployee(scanner);
                    break;
                case 2:
                    ems.searchEmployee(scanner);
                    break;
                case 3:
                    ems.editEmployee(scanner);
                    break;
                case 4:
                    ems.deleteEmployee(scanner);
                    break;
                case 5:
                    ems.displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Thank you for using Employee Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter employee contact: ");
        String contact = scanner.nextLine();

        Employee employee = new Employee(name, id, contact);
        employeeList.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void searchEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to search: ");
        int id = scanner.nextInt();

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Employee found: " + employee.toString());
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    public void editEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to edit: ");
        int id = scanner.nextInt();

        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                System.out.println("Enter new details for employee ID " + id + ":");
                System.out.print("Enter employee name: ");
                String name = scanner.next();
                System.out.print("Enter employee contact: ");
                String contact = scanner.next();

                // Update employee details
                employee.setName(name);
                employee.setContact(contact);
                System.out.println("Employee details updated successfully.");
                return;
            }
        }
    }
    public void deleteEmployee(Scanner scanner){
        System.out.println("Enter employee ID to delete");
        int id = scanner.nextInt();
        for(Employee employee : employeeList){
            if (employee.getId() == id){
                employeeList.remove(employee);
                System.out.printf("Employee delete successfull");
                return;
            }
        }
    }
    public void displayAllEmployees(){
        for( Employee employee : employeeList){
            System.out.println(((Employee) employee).getId() + " " + ((Employee) employee).getName() + " " + ((Employee) employee).getContact());
        }
    }
}
