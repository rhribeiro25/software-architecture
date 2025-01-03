package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.usecases.*;
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
    private final CreateRandomEmployee createRandomEmployee;
    private final WriteEmployee writeEmployee;
    private final WriteRandomEmployee writeRandomEmployee;
    private final ListEmployee listEmployee;
    private final ReadEmployee readEmployee;
    private final EmployeeIntMapper mapper;

    public EmployeeController(CreateEmployee createEmployee, CreateRandomEmployee createRandomEmployee, WriteEmployee writeEmployee, WriteRandomEmployee writeRandomEmployee, ListEmployee listEmployee, ReadEmployee readEmployee, EmployeeIntMapper mapper) {
        this.createEmployee = createEmployee;
        this.createRandomEmployee = createRandomEmployee;
        this.writeEmployee = writeEmployee;
        this.writeRandomEmployee = writeRandomEmployee;
        this.listEmployee = listEmployee;
        this.readEmployee = readEmployee;
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
    public List<EmployeeResponse> createBulk(@RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> createRandomEmployee.createRandomly();
            case FILE -> writeRandomEmployee.writeRandomly();
            default -> new ArrayList<>();
        };
    }

    @GetMapping
    public List<EmployeeResponse> getAllSorted(@RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> listEmployee.getAll();
            case FILE -> readEmployee.readAll();
            default -> new ArrayList<>();
        };
    }
}
