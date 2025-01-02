package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.dtos.DepartmentResponse;
import br.com.rhribeiro25.application.usecases.CreateDepartment;
import br.com.rhribeiro25.application.usecases.ListDepartment;
import br.com.rhribeiro25.interfaces.dtos.DepartmentRequest;
import br.com.rhribeiro25.interfaces.mappers.DepartmentIntMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final CreateDepartment createDepartment;
    private final ListDepartment listDepartment;
    private final DepartmentIntMapper mapper;

    public DepartmentController(CreateDepartment createDepartment, ListDepartment listDepartment, DepartmentIntMapper mapper) {
        this.createDepartment = createDepartment;
        this.listDepartment = listDepartment;
        this.mapper = mapper;
    }

    @PostMapping
    public DepartmentResponse create(@RequestBody DepartmentRequest dto) {
        return createDepartment.simpleCreation(mapper.toDomain(dto));

    }

    @GetMapping
    public List<DepartmentResponse> getAll() {
        return listDepartment.getAll();
    }
}
