package br.com.rhribeiro25;

import br.com.rhribeiro25.configurations.InjectsConfig;
import br.com.rhribeiro25.application.usecases.*;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.infrastructure.file.enums.MenuEnum;
import br.com.rhribeiro25.infrastructure.file.enums.SearchEnum;
import br.com.rhribeiro25.interfaces.controller.PromptController;
import br.com.rhribeiro25.application.usecases.WriteEmployee;
import br.com.rhribeiro25.application.usecases.WriteRandomEmployee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class SoftwareArchitecturePromptApplication {

    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectsConfig.class);

        WriteEmployee writeEmployee = context.getBean(WriteEmployee.class);
        WriteRandomEmployee writeRandomEmployee = context.getBean(WriteRandomEmployee.class);
        ReadEmployee readEmployee = context.getBean(ReadEmployee.class);
        PromptController inputService = context.getBean(PromptController.class);
        SearchEmployee searchService = context.getBean(SearchEmployee.class);
        SortedEmployee sortedEmployeeService = context.getBean(SortedEmployee.class);

        System.out.println("\n");
        System.out.println("*************************************************************");
        System.out.println("\t\t\t Welcome to the AugusTech System");
        System.out.println("*************************************************************");

        String pathFile = inputService.getPathInput("Please, insert the file name: ");

        Employee[] employeeArray = readEmployee.readAll().toArray(new Employee[0]);


        int optionInt;
        MenuEnum option = MenuEnum.EXIT;

        do {
            do {
                System.out.println("*************************************************************");
                System.out.println("\t\t\t Please, select one of the options:");
                System.out.println("*************************************************************");
                inputService.printMenuItems();
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

                    if (employeeArray != null && employeeArray.length > 0) {
                        sortedEmployeeService.mergeSort(employeeArray);
                        inputService.printFirstTwenty(employeeArray);
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
                            Employee foundEmployee = searchService.binarySearchEmployee(employeeArray, employeeName);
                            if (foundEmployee != null) {
                                System.out.println(foundEmployee);
                            } else {
                                System.out.println("Employee not found.");
                            }
                            break;

                        case DEPARTMENT:
                            // Search by DepartmentFileEntity
                            System.out.println("*************************************************************");
                            System.out.println("Here are the available departments:");
                            System.out.println("*************************************************************");
                            inputService.printDepartmentItems();
                            System.out.println("*************************************************************");

                            int departmentKey = inputService.getSearchInput("Insert department number: ");
                            System.out.println("*************************************************************");

                            inputService.printEmployeesByDepartment(employeeArray, departmentKey);
                            Employee[] departmentResults = searchService.linearSearchByDepartment(employeeArray, departmentKey, 0);

                            if (departmentResults != null && departmentResults.length > 0) {
                                inputService.printFirstTwenty(departmentResults);
                            } else {
                                System.out.println("No employees found in this department.");
                            }
                            break;

                        case ROLE:

                            System.out.println("*************************************************************");
                            System.out.println("Here are the available roles:");
                            System.out.println("*************************************************************");
                            inputService.printRoleItems();

                            int roleKey = inputService.getSearchInput("Insert role number: ");
                            System.out.println("*************************************************************");

                            inputService.printEmployeesByRole(employeeArray, roleKey);
                            Employee[] roleResults = searchService.linearSearchByRole(employeeArray, roleKey, 0);

                            if (roleResults != null && roleResults.length > 0) {
                                inputService.printFirstTwenty(roleResults);
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

                    employeeArray = readEmployee.readAll().toArray(new Employee[0]);

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t Employee stored successfully!");

                    break;


                case GENERATE_RANDOM_EMPLOYEE:

                    System.out.println("*************************************************************");
                    System.out.println("\t\t\t\t Generating a random Employee");
                    System.out.println("*************************************************************");
                    writeRandomEmployee.writeRandomly(pathFile);

                    employeeArray = readEmployee.readAll().toArray(new Employee[0]);

                    inputService.printRandoms(employeeArray);

                    break;


                case PRINT_ALL_EMPLOYEES:

                    System.out.println("*************************************************************");
                    System.out.println("Here are all the employees:");
                    System.out.println("*************************************************************");
                    inputService.printAll(employeeArray);


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