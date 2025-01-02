package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.usecases.CreateEmployee;
import br.com.rhribeiro25.application.usecases.ListEmployee;
import br.com.rhribeiro25.application.usecases.WriteEmployee;
import br.com.rhribeiro25.application.usecases.WriteRandomEmployee;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;
import br.com.rhribeiro25.interfaces.mappers.EmployeeIntMapper;
import br.com.rhribeiro25.shared.enums.StorageEnum;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CreateEmployee createEmployee;
    private final WriteEmployee writeEmployee;
    private final WriteRandomEmployee writeRandomEmployee;
    private final ListEmployee listEmployee;
    private final EmployeeIntMapper mapper;

    public EmployeeController(CreateEmployee createEmployee, WriteEmployee writeEmployee, WriteRandomEmployee writeRandomEmployee, ListEmployee listEmployee, EmployeeIntMapper mapper) {
        this.createEmployee = createEmployee;
        this.writeEmployee = writeEmployee;
        this.writeRandomEmployee = writeRandomEmployee;
        this.listEmployee = listEmployee;
        this.mapper = mapper;
    }

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest dto, @RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> createEmployee.simpleCreation(mapper.toDomain(dto));
            case FILE -> writeEmployee.simpleWrite(mapper.toDomain(dto));
            default -> new EmployeeResponse.Builder().build();
        };
    }

    @PostMapping("/bulk")
    public List<EmployeeResponse> createList(@RequestParam StorageEnum storage) {
        return switch (storage) {
            case FILE -> writeRandomEmployee.writeRandomly();
            default -> new ArrayList<>();
        };
    }

    @GetMapping
    public List<EmployeeResponse> getAll() {
        return listEmployee.getAll();
    }
}
