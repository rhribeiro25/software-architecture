package br.com.rhribeiro25;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.application.usecases.*;
import br.com.rhribeiro25.domain.Employee;
import br.com.rhribeiro25.domain.enums.MenuEnum;
import br.com.rhribeiro25.domain.enums.SearchEnum;
import br.com.rhribeiro25.infra.controller.PromptController;
import br.com.rhribeiro25.infra.gateways.EmployeeFileRepositoryImpl;
import br.com.rhribeiro25.infra.gateways.PrintEmployee;
import br.com.rhribeiro25.application.usecases.WriteEmployee;
import br.com.rhribeiro25.application.usecases.WriteRandomEmployee;

import java.io.IOException;

public class CleanArchitecturePromptApplication {

    public static void main(String[] args) throws IOException {

        EmployeeRepository employeeRepository = new EmployeeFileRepositoryImpl();
        WriteEmployee writeEmployee = new WriteEmployee(employeeRepository);
        WriteRandomEmployee writeRandomEmployee = new WriteRandomEmployee(employeeRepository);
        ReadEmployee readEmployee = new ReadEmployee(employeeRepository);

        PromptController inputService = new PromptController();
        SearchEmployee searchService = new SearchEmployee();
        SortedEmployee sortedEmployeeService = new SortedEmployee();
        PrintEmployee printEmployee = new PrintEmployee();

        System.out.println("\n");
        System.out.println("*************************************************************");
        System.out.println("\t\t\t Welcome to the AugusTech System");
        System.out.println("*************************************************************");

        String pathFile = inputService.getPathInput("Please, insert the file name: ");

        Employee[] employeeList;
        try {
            employeeList = readEmployee.readAll(pathFile);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        int optionInt;
        MenuEnum option = MenuEnum.EXIT;

        do {
            do {
                System.out.println("*************************************************************");
                System.out.println("\t\t\t Please, select one of the options:");
                System.out.println("*************************************************************");
                printEmployee.printMenuItems();
                System.out.println("*************************************************************");
                optionInt = inputService.getMenuInput("Insert your choice: ");

                if (optionInt != -1) {
                    option = MenuEnum.fromKey(optionInt);
                }
            } while (optionInt == -1);

            switch (option) {

                case SORT:
                    System.out.println("*************************************************************");
                    System.out.println("List of the first twenty employees sorted in ascending order:");
                    System.out.println("*************************************************************");

                    if (employeeList != null && employeeList.length > 0) {
                        sortedEmployeeService.mergeSort(employeeList);
                        printEmployee.printFirstTwenty(employeeList);
                    } else {
                        System.out.println("Employee list is empty or not loaded.");
                    }

                    break;


                case SEARCH:

                    System.out.println("*************************************************************");
                    System.out.println("Select search type:");

                    int searchOption;
                    SearchEnum selectedSearchType = null;

                    do {
                        // Exibe as opções do enum SearchType
                        for (SearchEnum type : SearchEnum.values()) {
                            System.out.println(type.getKey() + ". " + type.getDescription());
                        }
                        System.out.println("*************************************************************");
                        searchOption = inputService.getSearchInput("Choose an option: ");
                        System.out.println("*************************************************************");
                        if (searchOption != -1) {
                            selectedSearchType = SearchEnum.fromKey(searchOption); // Obtém o tipo de busca pelo número
                        }
                    } while (searchOption == -1);

                    switch (selectedSearchType) {
                        case NAME:
                            // Search by Name
                            String employeeName = inputService.getNameInput("Insert the Employee Name: ").trim();
                            System.out.println("*************************************************************");
                            Employee foundEmployee = searchService.binarySearchEmployee(employeeList, employeeName);
                            if (foundEmployee != null) {
                                System.out.println(foundEmployee);
                            } else {
                                System.out.println("Employee not found.");
                            }
                            break;

                        case DEPARTMENT:
                            // Search by Department
                            System.out.println("*************************************************************");
                            System.out.println("Here are the available departments:");
                            System.out.println("*************************************************************");
                            printEmployee.printDepartmentItems();
                            System.out.println("*************************************************************");

                            int departmentKey = inputService.getSearchInput("Insert department number: ");
                            System.out.println("*************************************************************");

                            printEmployee.printEmployeesByDepartment(employeeList, departmentKey);
                            Employee[] departmentResults = searchService.linearSearchByDepartment(employeeList, departmentKey, 0);

                            if (departmentResults != null && departmentResults.length > 0) {
                                printEmployee.printFirstTwenty(departmentResults);
                            } else {
                                System.out.println("No employees found in this department.");
                            }
                            break;

                        case ROLE:

                            System.out.println("*************************************************************");
                            System.out.println("Here are the available roles:");
                            System.out.println("*************************************************************");
                            printEmployee.printRoleItems();

                            int roleKey = inputService.getSearchInput("Insert role number: ");
                            System.out.println("*************************************************************");

                            printEmployee.printEmployeesByRole(employeeList, roleKey);
                            Employee[] roleResults = searchService.linearSearchByRole(employeeList, roleKey, 0);

                            if (roleResults != null && roleResults.length > 0) {
                                printEmployee.printFirstTwenty(roleResults);
                            } else {
                                System.out.println("No employees found with this role.");
                            }
                            break;
                    }
                    break;

                case ADD_EMPLOYEE:

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t Inserting the new Employee:");
                    System.out.println("*************************************************************");
                    System.out.println(writeEmployee.write(pathFile));

                    try {
                        employeeList = readEmployee.readAll(pathFile);
                    } catch (IOException e) {
                        System.out.println("Error to read the file: " + e.getMessage());
                    }

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t Employee stored successfully!");

                    break;


                case GENERATE_RANDOM_EMPLOYEE:

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t Generating a random Employee");
                    System.out.println("*************************************************************");
                    writeRandomEmployee.writeRandomly(pathFile);

                    try {
                        employeeList = readEmployee.readAll(pathFile);
                    } catch (IOException e) {
                        System.out.println("Error to read the file: " + e.getMessage());
                    }

                    printEmployee.printRandoms(employeeList);

                    break;


                case PRINT_ALL_EMPLOYEES:

                    System.out.println("*************************************************************");
                    System.out.println("Here are all the employees:");
                    System.out.println("*************************************************************");
                    printEmployee.printAll(employeeList);


                case EXIT:

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\tThank you for using the AugusTech System.");
                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t\tI hope see you soon.");
                    System.out.println("*************************************************************");
                    break;
            }

        } while (option != MenuEnum.EXIT);
    }
}