package br.com.rhribeiro25.infrastructure.file.entities;

public class DepartmentFileEntity {

    private String name;

    public DepartmentFileEntity() {}

    private DepartmentFileEntity(Builder builder) {
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

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentFileEntity build() {
            return new DepartmentFileEntity(this);
        }
    }
}
