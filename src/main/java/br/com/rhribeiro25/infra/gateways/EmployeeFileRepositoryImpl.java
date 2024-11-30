package br.com.rhribeiro25.infra.gateways;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.domain.Department;
import br.com.rhribeiro25.domain.Employee;
import br.com.rhribeiro25.domain.enums.RoleEnum;

import java.io.*;

public class EmployeeFileRepositoryImpl implements EmployeeRepository {

    public void write(Employee employee, String pathFile) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile, true))) {
            bufferedWriter.write(employee.contentToFile());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Employee[] readAll(String pathFile) throws IOException {

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
                        employeeList[i].setDepartment(new Department.Builder()
                                .name(department)
                                .build());
                    }
                }
            }
            inputStream.close();
            bufferedReader.close();
            return employeeList;

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
