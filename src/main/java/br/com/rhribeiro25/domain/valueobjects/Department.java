package br.com.rhribeiro25.domain.valueobjects;

public class Department {

    private String name;

    public Department() {}

    private Department(Department.Builder builder) {
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private String name;

        public Department.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
