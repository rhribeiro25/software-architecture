package br.com.rhribeiro25.domain.models;

import br.com.rhribeiro25.shared.enums.RoleEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EmployeeTest {
    @Test
    public void newEmployeeSuccess(){
        Assertions.assertNotNull(new Employee.Builder()
                .name("Jacque")
                .role(RoleEnum.MAIN_MANAGER)
                .departmentCode("123456789")
                .build());

    }
}
