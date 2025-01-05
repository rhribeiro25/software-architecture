package br.com.rhribeiro25.shared.mocks;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.valueobjects.employee.Document;
import br.com.rhribeiro25.shared.enums.DepartmentCodeEnum;
import br.com.rhribeiro25.shared.enums.DocumentTypeEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class RandomEmployeeList {

    public static List<Employee> create(){
        List<Employee> employeeList = new ArrayList<>();
        String[] names = EmployeeNames.getAll();
        Random random = new Random();


        for (int i = 0; i < names.length; i++) {

            String firstPart = String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000));
            String secondPart = String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000));
            String thirdPart = String.valueOf(ThreadLocalRandom.current().nextInt(100, 1000));
            String digits = String.valueOf(ThreadLocalRandom.current().nextInt(10, 100));
            String document = firstPart + "." + secondPart + "." + thirdPart  + "-" + digits;

            String name = names[random.nextInt(names.length)];
            RoleEnum role = RoleEnum.values()[random.nextInt(RoleEnum.values().length)];
            String departmentCode = DepartmentCodeEnum.values()[random.nextInt(DepartmentCodeEnum.values().length)].name();
            Employee employee = new Employee.Builder()
                    .name(name)
                    .document(new Document.Builder().value(document).type(DocumentTypeEnum.CPF).build())
                    .role(role)
                    .salary(BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(1000, 2000)))
                    .departmentCode(departmentCode)
                    .build();
            employeeList.add(employee);
        }
        return employeeList;
    }
}
