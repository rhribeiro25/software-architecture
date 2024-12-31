package br.com.rhribeiro25.infrastructure.database.entities;

public class DepartmentDbEntity {

    private String name;

    public DepartmentDbEntity() {}

    private DepartmentDbEntity(Builder builder) {
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

        public DepartmentDbEntity build() {
            return new DepartmentDbEntity(this);
        }
    }
}
