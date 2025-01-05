package br.com.rhribeiro25.infrastructure.file.entities;

import br.com.rhribeiro25.shared.enums.DocumentTypeEnum;
import br.com.rhribeiro25.shared.enums.RoleEnum;

import java.math.BigDecimal;

public class EmployeeFileEntity {

    private Long id;

    private String name;

    private DocumentTypeEnum documentType;

    private String document;

    private RoleEnum role;

    private int performanceRating;

    private BigDecimal salary;

    private DepartmentFileEntity department;

    public EmployeeFileEntity(){}

    public EmployeeFileEntity(EmployeeFileEntity.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.documentType = builder.documentType;
        this.document = builder.document;
        this.role = builder.role;
        this.salary = builder.salary;
        this.department = builder.departmentDbEntity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public DepartmentFileEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentFileEntity departmentDbEntity) {
        this.department = departmentDbEntity;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getPerformanceRating() {
        return performanceRating;
    }

    public void setPerformanceRating(int performanceRating) {
        this.performanceRating = performanceRating;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    // Builder Design Pattern simplifies the creation of complex objects.
    public static class Builder {

        private Long id;
        private String name;
        private DocumentTypeEnum documentType;
        private String document;
        private RoleEnum role;
        private BigDecimal salary;
        private DepartmentFileEntity departmentDbEntity;

        public EmployeeFileEntity.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeFileEntity.Builder name(String name) {
            this.name = name;
            return this;
        }

        public EmployeeFileEntity.Builder documentType(DocumentTypeEnum documentType) {
            this.documentType = documentType;
            return this;
        }

        public EmployeeFileEntity.Builder document(String document) {
            this.document = document;
            return this;
        }

        public EmployeeFileEntity.Builder role(RoleEnum role) {
            this.role = role;
            return this;
        }

        public EmployeeFileEntity.Builder salary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeFileEntity.Builder department(DepartmentFileEntity departmentDbEntity) {
            this.departmentDbEntity = departmentDbEntity;
            return this;
        }

        public EmployeeFileEntity build() {
            return new EmployeeFileEntity(this);
        }
    }
}
