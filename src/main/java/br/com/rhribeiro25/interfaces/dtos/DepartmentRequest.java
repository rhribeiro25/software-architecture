package br.com.rhribeiro25.interfaces.dtos;

//Dto Request
public class DepartmentRequest {

    private String name;

    public DepartmentRequest() {}

    private DepartmentRequest(Builder builder) {
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

        public DepartmentRequest build() {
            return new DepartmentRequest(this);
        }
    }
}
