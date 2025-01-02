package br.com.rhribeiro25.interfaces.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

//Dto Request
public record EmployeeRequest(
        String name,
        RoleEnum role,
        BigDecimal salary,
        String departmentCode
) {

    public static class Builder {

        private String name;
        private RoleEnum role;
        private BigDecimal salary;
        private String departmentCode;


        public EmployeeRequest.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeRequest.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeRequest.Builder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeRequest.Builder departmentCode(String department) {
            this.departmentCode = department;
            return this;
        }

        public EmployeeRequest build() {
            return new EmployeeRequest(name, role, salary, departmentCode);
        }
    }
}
