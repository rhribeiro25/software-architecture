package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.domain.Department;
import br.com.rhribeiro25.domain.Employee;
import br.com.rhribeiro25.domain.enums.DepartmentEnum;
import br.com.rhribeiro25.domain.enums.RoleEnum;
import br.com.rhribeiro25.infra.controller.PromptController;
import br.com.rhribeiro25.infra.gateways.PrintEmployee;

public class WriteEmployee {

    private PrintEmployee printEmployee = new PrintEmployee();
    private PromptController inputService = new PromptController();
    private EmployeeRepository employeeRepository;

    public WriteEmployee(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee write(String pathFile) {

        Employee employee = new Employee();

        employee.setName(inputService.getNameInput("Name: "));

        System.out.println("*************************************************************");

        int inputDep;

        do {
            printEmployee.printDepartmentItems();
            System.out.println("*************************************************************");
            inputDep = inputService.getDepartmentInput("Department: ");
            if (inputDep != -1) {
                employee.setDepartment(new Department.Builder()
                        .name(DepartmentEnum.fromKey(inputDep).name())
                        .build());
            }
        } while (inputDep == -1);

        System.out.println("*************************************************************");

        int inputRole;
        do {
            printEmployee.printRoleItems();
            System.out.println("*************************************************************");
            inputRole = inputService.getRoleInput("Role: ");

            if (inputRole != -1) {
                employee.setRole(RoleEnum.fromKey(inputRole));
            }
        } while (inputRole == -1);
        System.out.println("*************************************************************");

        employeeRepository.write(employee, pathFile);

        return employee;
    }

}