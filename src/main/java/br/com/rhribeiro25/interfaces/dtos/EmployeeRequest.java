package br.com.rhribeiro25.interfaces.dtos;

import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

//Dto Request
public record EmployeeRequest(
        String name,
        RoleEnum role,
        BigDecimal salary,
        String departmentCnpj
) {

    public static class Builder {

        private String name;
        private RoleEnum role;
        private BigDecimal salary;
        private String departmentCnpj;


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

        public EmployeeRequest.Builder departmentCnpj(String department) {
            this.departmentCnpj = department;
            return this;
        }

        public EmployeeRequest build() {
            return new EmployeeRequest(name, role, salary, departmentCnpj);
        }
    }
}
