package br.com.rhribeiro25.domain.entities.usuario;

import br.com.rhribeiro25.domain.models.Employee;
import br.com.rhribeiro25.domain.value_objects.Department;
import br.com.rhribeiro25.shared.enums.RoleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeTest {
    @Test
    public void newEmployeeSuccess(){
        Assertions.assertNotNull(new Employee.Builder()
                .name("Jacque")
                .role(RoleEnum.MAIN_MANAGER)
                .department(new Department.Builder()
                        .name("Empresa teste").build())
                .build());

    }
}
