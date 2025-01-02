package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;

public class WriteEmployee {

    private final EmployeeRepository employeeRepository;
    private final EmployeeAppMapper mapper;

    public WriteEmployee(EmployeeRepository employeeRepository, EmployeeAppMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    public EmployeeResponse simpleWrite(Employee employee) {
        return mapper.toDto(employeeRepository.save(employee));
    }


//
//
//
//
//
//
//
//
//
//
//
//    private final PromptController inputService;
//    private final EmployeeRepository repository;
//    private final EmployeeAppMapper mapper;
//
//    public WriteEmployee(PromptController inputService, EmployeeRepository repository, EmployeeAppMapper mapper) {
//        this.inputService = inputService;
//        this.repository = repository;
//        this.mapper = mapper;
//    }
//
//    public Employee write(String pathFile) {
//
//        Employee employee = new Employee();
//
//        employee.setName(inputService.getNameInput("Name: "));
//
//        System.out.println("*************************************************************");
//
//        int inputDep;
//
//        do {
//            inputService.printDepartmentItems();
//            System.out.println("*************************************************************");
//            inputDep = inputService.getDepartmentInput("DepartmentFileEntity: ");
//            if (inputDep != -1) {
//                //employee.setDepartment(new Department.Builder()
//                //        .name(DepartmentCodeEnum.fromKey(inputDep).name())
//                //        .build());
//            }
//        } while (inputDep == -1);
//
//        System.out.println("*************************************************************");
//
//        int inputRole;
//        do {
//            inputService.printRoleItems();
//            System.out.println("*************************************************************");
//            inputRole = inputService.getRoleInput("Role: ");
//
//            if (inputRole != -1) {
//                employee.setRole(RoleEnum.fromKey(inputRole));
//            }
//        } while (inputRole == -1);
//        System.out.println("*************************************************************");
//
//        repository.save(employee);
//
//        return employee;
//    }

}