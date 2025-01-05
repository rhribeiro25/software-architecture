package br.com.rhribeiro25.interfaces.dtos;

import br.com.rhribeiro25.shared.enums.DocumentTypeEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

//Dto Request
public record EmployeeRequest(
        String name,
        DocumentTypeEnum documentType,
        String document,
        RoleEnum role,
        BigDecimal salary,
        String departmentCode
) {

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private String name;
        private DocumentTypeEnum documentType;
        private String document;
        private RoleEnum role;
        private BigDecimal salary;
        private String departmentCode;

        public EmployeeRequest.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeRequest.Builder documentType(DocumentTypeEnum documentType) {
            this.documentType = documentType;
            return this;
        }

        public EmployeeRequest.Builder document(String document) {
            this.document = document;
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
            return new EmployeeRequest(name, documentType, document, role, salary, departmentCode);
        }
    }
}
