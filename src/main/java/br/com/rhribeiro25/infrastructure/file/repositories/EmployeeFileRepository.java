package br.com.rhribeiro25.infrastructure.file.repositories;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.infrastructure.file.entities.EmployeeFileEntity;
import br.com.rhribeiro25.infrastructure.file.mappers.EmployeeFileMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class EmployeeFileRepository implements EmployeeRepository {

    private final String userHome = System.getProperty("user.home");

    private final String employeeData = "employee_data.txt";

    private final String employeeMetadata = "employee_metadata.txt";

    private final String metadataFilePath;

    private final String dataFilePath;

    private final EmployeeFileMapper mapper;

    private final ObjectMapper objectMapper;

    public EmployeeFileRepository(EmployeeFileMapper mapper, ObjectMapper objectMapper) {
        this.mapper = mapper;
        this.objectMapper = objectMapper;
        this.dataFilePath = userHome + "/" + employeeData;
        this.metadataFilePath =  userHome + "/" + employeeMetadata;
    }

    public Employee save(Employee employee) {
        ObjectMapper objectMapper = new ObjectMapper();
        Long id = this.getNextId();
        EmployeeFileEntity entity = mapper.toEntity(id, employee);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath, true))) {
            writer.write(objectMapper.writeValueAsString(entity));
            writer.newLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee, Long id) {
        return null;
    }

    @Override
    public Employee findByDocument(String document) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EmployeeFileEntity> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employeeList.add(objectMapper.readValue(line, EmployeeFileEntity.class));
            }
            for (int i = 0; i < employeeList.size(); i++) {
                EmployeeFileEntity employee = employeeList.get(i);
                if (employee.getDocument().equals(document)) {
                    return mapper.toDomain(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Error to remove employee with document: " + document);
            throw new RuntimeException("Error processing JSON file", e);
        }
        return null;
    }

    @Override
    public boolean deleteByDocument(String document) {
        List<EmployeeFileEntity> employeeList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                employeeList.add(objectMapper.readValue(line, EmployeeFileEntity.class));
            }
            for (int i = 0; i < employeeList.size(); i++) {
                EmployeeFileEntity employee = employeeList.get(i);
                if (employee.getDocument().equals(document)) {
                    employeeList.remove(i);
                    Path path = Paths.get(dataFilePath);
                    Files.write(path, new byte[0]);
                    employeeList.forEach(entity -> this.save(mapper.toDomain(entity)));
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error to remove employee with document: " + document);
            throw new RuntimeException("Error processing JSON file", e);
        }
        return false;
    }

    public List<Employee> findAll() {

        List<EmployeeFileEntity> entityList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                entityList.add(objectMapper.readValue(line, EmployeeFileEntity.class));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return mapper.toDomainList(entityList);
    }

    private long getNextId() {
        ObjectMapper objectMapper = new ObjectMapper();
        File metadataFile = new File(metadataFilePath);
        long lastId = 0;
        long newId = 0;
        try {
        if (metadataFile.exists()) {
            Map<String, Long> map = objectMapper.readValue(metadataFile, Map.class);
            Object value = map.get("lastId");
            lastId = (value instanceof Integer) ? ((Integer) value).longValue() : (Long) value;
        }

        newId = lastId + 1;

        Map<String, Long> newMetadata = new HashMap<>();
        newMetadata.put("lastId", newId);
        objectMapper.writeValue(metadataFile, newMetadata);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return newId;
    }

}
