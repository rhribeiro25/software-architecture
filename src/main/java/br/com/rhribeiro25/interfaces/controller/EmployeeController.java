package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.usecases.CreateEmployee;
import br.com.rhribeiro25.application.usecases.ListEmployee;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;
import br.com.rhribeiro25.interfaces.mappers.EmployeeIntMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CreateEmployee createEmployee;
    private final ListEmployee listEmployee;
    private final EmployeeIntMapper mapper;

    public EmployeeController(CreateEmployee createEmployee, ListEmployee listEmployee, EmployeeIntMapper mapper) {
        this.createEmployee = createEmployee;
        this.listEmployee = listEmployee;
        this.mapper = mapper;
    }

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest dto) {
        return createEmployee.simpleCreation(mapper.toDomain(dto));

    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return listEmployee.getAll();
    }
}
