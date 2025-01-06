package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.dtos.EmployeeResponse;
import br.com.rhribeiro25.application.usecases.*;
import br.com.rhribeiro25.interfaces.dtos.DocumentRequest;
import br.com.rhribeiro25.interfaces.dtos.EmployeeRequest;
import br.com.rhribeiro25.interfaces.mappers.EmployeeIntMapper;
import br.com.rhribeiro25.shared.enums.StorageEnum;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final CreateEmployee createEmployee;
    private final CreateRandomMockEmployee createRandomMockEmployee;

    private final WriteEmployee writeEmployee;
    private final WriteRandomMockEmployee writeRandomMockEmployee;

    private final FindEmployeeByDocument findEmployeeByDocument;
    private final ReadEmployeeUsingSearchAlgorithm readEmployeeUsingSearchAlgorithm;

    private final FindEmployeeListUsingSortingMethod findEmployeeListUsingSortingMethod;
    private final ReadEmployeeListUsingSortingAlgorithm readEmployeeListUsingSortingAlgorithm;

    private final DeleteEmployee deleteEmployee;
    private final RemoveEmployee removeEmployee;

    private final EmployeeIntMapper mapper;

    public EmployeeController(CreateEmployee createEmployee, CreateRandomMockEmployee createRandomMockEmployee, WriteEmployee writeEmployee, WriteRandomMockEmployee writeRandomMockEmployee, FindEmployeeByDocument findEmployeeByDocument, ReadEmployeeUsingSearchAlgorithm readEmployeeUsingSearchAlgorithm, FindEmployeeListUsingSortingMethod findEmployeeListUsingSortingMethod, ReadEmployeeListUsingSortingAlgorithm readEmployeeListUsingSortingAlgorithm, DeleteEmployee deleteEmployee, RemoveEmployee removeEmployee, EmployeeIntMapper mapper) {
        this.createEmployee = createEmployee;
        this.createRandomMockEmployee = createRandomMockEmployee;
        this.writeEmployee = writeEmployee;
        this.writeRandomMockEmployee = writeRandomMockEmployee;
        this.findEmployeeByDocument = findEmployeeByDocument;
        this.readEmployeeUsingSearchAlgorithm = readEmployeeUsingSearchAlgorithm;
        this.findEmployeeListUsingSortingMethod = findEmployeeListUsingSortingMethod;
        this.readEmployeeListUsingSortingAlgorithm = readEmployeeListUsingSortingAlgorithm;
        this.deleteEmployee = deleteEmployee;
        this.removeEmployee = removeEmployee;
        this.mapper = mapper;
    }

    @PostMapping
    public EmployeeResponse create(
            @RequestBody EmployeeRequest dto,
            @RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> createEmployee.simpleCreation(mapper.toDomain(dto));
            case FILE -> writeEmployee.simpleWrite(mapper.toDomain(dto));
        };
    }

    @PostMapping("/bulk")
    public List<EmployeeResponse> createBulk(@RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> createRandomMockEmployee.createRandomly();
            case FILE -> writeRandomMockEmployee.writeRandomly();
        };
    }

    @GetMapping
    public List<EmployeeResponse> getAllSorted(@RequestParam StorageEnum storage) {
        return switch (storage) {
            case POSTGRES -> findEmployeeListUsingSortingMethod.getAll();
            case FILE -> readEmployeeListUsingSortingAlgorithm.readAll();
        };
    }

    @PostMapping("/filter")
    public EmployeeResponse getByDocument(
            @RequestParam StorageEnum storage,
            @RequestBody DocumentRequest document
    ) {
        return switch (storage) {
            case POSTGRES -> findEmployeeByDocument.getByDocument(document.getValue());
            case FILE -> readEmployeeUsingSearchAlgorithm.read(document.getValue());
        };
    }

    @DeleteMapping
    public boolean remove(
            @RequestParam StorageEnum storage,
            @RequestBody DocumentRequest document
    ) {
        return switch (storage) {
            case POSTGRES -> deleteEmployee.delete(document.getValue());
            case FILE -> removeEmployee.remove(document.getValue());
        };
    }
}
