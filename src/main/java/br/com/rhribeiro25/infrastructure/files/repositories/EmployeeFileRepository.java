package br.com.rhribeiro25.infrastructure.files.repositories;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.domain.models.Department;
import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class EmployeeFileRepository implements EmployeeRepository {

    private String pathFile;

    public Employee save(Employee employee) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile, true))) {
            bufferedWriter.write(employee.contentToFile());
            bufferedWriter.newLine();
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
            File file = new File(pathFile);
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    System.out.println("Failed to create file: " + file.getAbsolutePath());
                }
            }

            InputStream inputStream = new FileInputStream(pathFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int countLines = 0;


            while ((bufferedReader.readLine()) != null) {
                countLines++;
            }

            bufferedReader.close();

            Employee[] employeeList = new Employee[countLines];
            inputStream = new FileInputStream(pathFile);
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

}
