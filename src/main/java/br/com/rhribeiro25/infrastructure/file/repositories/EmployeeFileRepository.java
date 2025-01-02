package br.com.rhribeiro25.infrastructure.file.repositories;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.infrastructure.file.entities.EmployeeFileEntity;
import br.com.rhribeiro25.infrastructure.file.mappers.EmployeeFileMapper;
import br.com.rhribeiro25.shared.enums.RoleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;

public class EmployeeFileRepository implements EmployeeRepository {

    private final String userHome = System.getProperty("user.home");

    private final String employeeData = "employee_data.txt";

    private final String employeeMetadata = "employee_metadata.txt";

    private final String metadataFilePath;

    private final String filePath;

    private final EmployeeFileMapper mapper;

    public EmployeeFileRepository(EmployeeFileMapper mapper) {
        this.mapper = mapper;
        this.filePath = userHome + "/" + employeeData;
        this.metadataFilePath =  userHome + "/" + employeeMetadata;
    }

    public Employee save(Employee employee) {
        ObjectMapper objectMapper = new ObjectMapper();

        Long id = this.getNextId();
        EmployeeFileEntity entity = mapper.toEntity(id, employee);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
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

    public List<Employee> findAll() {

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Failed to create file: " + file.getAbsolutePath());
                }
            }

            InputStream inputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int countLines = 0;


            while ((bufferedReader.readLine()) != null) {
                countLines++;
            }

            bufferedReader.close();

            Employee[] employeeList = new Employee[countLines];
            inputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            for (int i = 0; i < countLines; i++) {
                line = bufferedReader.readLine();
                if (line != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 3) {
                        String name = parts[0].trim();
                        String role = parts[1].trim();
                        String department = parts[2].trim();

                        employeeList[i] = new Employee();
                        employeeList[i].setName(name);
                        employeeList[i].setRole(RoleEnum.valueOf(role));
//                        employeeList[i].setDepartment(new Department.Builder()
//                                .name(department)
//                                .build());
                    }
                }
            }
            inputStream.close();
            bufferedReader.close();
            return Arrays.asList(employeeList);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Employee findById(Long id) {
        return null;
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
