package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.shared.enums.DepartmentCodeEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;
import br.com.rhribeiro25.shared.mocks.EmployeeNames;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRandomEmployee {

    private final EmployeeRepository repository;
    private final EmployeeAppMapper mapper;

    public CreateRandomEmployee(EmployeeRepository repository, EmployeeAppMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EmployeeResponse> createRandomly() {

        List<Employee> employeeList = new ArrayList<>();
        String[] names = EmployeeNames.getAll();
        Random random = new Random();

        for (int i = 0; i < names.length; i++) {
            String name = names[random.nextInt(names.length)];
            RoleEnum role = RoleEnum.values()[random.nextInt(RoleEnum.values().length)];
            String departmentCode = DepartmentCodeEnum.values()[random.nextInt(DepartmentCodeEnum.values().length)].name();
            Employee employee = new Employee.Builder()
                    .name(name)
                    .role(role)
                    .salary(BigDecimal.valueOf(2000.00))
                    .departmentCode(departmentCode)
                    .build();
            employeeList.add(repository.save(employee));
        }
        return mapper.toDtoList(employeeList);
    }

}