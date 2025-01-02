package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.SearchEmployee;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.infrastructure.file.enums.MenuEnum;
import br.com.rhribeiro25.shared.enums.DepartmentEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.util.Scanner;

public class PromptController {

    private Scanner scanner;
    private final SearchEmployee searchService;
    private final String userHome = System.getProperty("user.home").replace("\\", "/");

    public PromptController(SearchEmployee searchService) {
        this.searchService = searchService;
        scanner = new Scanner(System.in);
    }

    public String getPathInput(String msg) {
        System.out.print(msg);
        String path = scanner.nextLine();
        return userHome + "/" + path;
    }

    public String getNameInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int getDepartmentInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getRoleInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getMenuInput(String msg) {
        System.out.print(msg);
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public int getSearchInput(String msg) {
        System.out.print(msg);
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public void printFirstTwenty(Employee[] employeeList) {

        if (employeeList == null || employeeList.length == 0) {
            System.out.println("Employee list is empty.");
            return;
        }

        for (int i = 0; i < employeeList.length && i < 20; i++) {
            Employee employee = employeeList[i];
            if (employee != null) {
                System.out.println(employee.toStringInLine());
            } else {
                System.out.println("Employee at index " + i + " is null.");
            }
        }
    }

    public void printAll(Employee[] employeeList) {

        if (employeeList == null || employeeList.length == 0) {
            System.out.println("Employee list is empty.");
            return;
        }

        for (int i = 0; i < employeeList.length; i++) {
            Employee employee = employeeList[i];
            if (employee != null) {
                System.out.println(employee.toStringInLine());
            } else {
                System.out.println("Employee at index " + i + " is null.");
            }
        }
    }

    public void printRandoms(Employee[] randomEmployeeList) {
        if (randomEmployeeList == null || randomEmployeeList.length == 0) {
            System.out.println("No random employees created.");
            return;
        }

        boolean foundRandom = false;

        for (int i = 0; i < randomEmployeeList.length; i++) {
            Employee employee = randomEmployeeList[i];
        }

        if (!foundRandom) {
            System.out.println("");
        }
    }

    // Este método verifica se o empregado é aleatório (mude conforme a lógica)
    private boolean isRandomEmployee(Employee employee) {
        // Exemplo de critério: verificar se o nome do empregado está na lista de nomes aleatórios
        // Ou qualquer outro critério que você tenha para definir um "random"
        return employee.getName() != null && !employee.getName().isEmpty(); // Aqui é só um exemplo
    }


    public void printEmployeesByDepartment(Employee[] employeeList, int department) {

        Employee[] foundEmployees = searchService.linearSearchByDepartment(employeeList, department, 0);

        if (foundEmployees != null && foundEmployees.length > 0) {
            System.out.println("Employees found in department " + department + ":");

            for (Employee employee : foundEmployees) {
                System.out.println(employee.toStringInLine());
            }
        } else {
            System.out.println("No employees found in this department.");
        }
    }

    public void printEmployeesByRole(Employee[] employeeList, int roleKey) {

        Employee[] foundEmployees = searchService.linearSearchByRole(employeeList, roleKey, 0);

        if (foundEmployees != null && foundEmployees.length > 0) {
            System.out.println("Employees found with role " + roleKey + ":");

            for (Employee employee : foundEmployees) {
                System.out.println(employee.toStringInLine());
            }
        } else {
            System.out.println("No employees found with this role.");
        }
    }


    public void printMenuItems() {
        for (MenuEnum menu : MenuEnum.values()) {
            System.out.println(menu.getKey() + ". " + menu.getDescription());
        }
    }

    public void printRoleItems() {
        for (RoleEnum menu : RoleEnum.values()) {
            System.out.println(menu.getKey() + ". " + menu.getDescription());
        }
    }

    public void printDepartmentItems() {
        for (DepartmentEnum menu : DepartmentEnum.values()) {
            System.out.println(menu.getKey() + ". " + menu.getDescription());
        }
    }

}