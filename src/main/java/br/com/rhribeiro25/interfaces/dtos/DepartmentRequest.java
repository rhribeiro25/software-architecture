package br.com.rhribeiro25.interfaces.dtos;

//Dto Request
public class DepartmentRequest {

    private String cnpj;
    private String name;

    public DepartmentRequest() {}

    private DepartmentRequest(Builder builder) {
        this.cnpj = builder.cnpj;
        this.name = builder.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public String toString() {
        return "DepartmentFileEntity{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {

        private String cnpj;
        private String name;

        public Builder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentRequest build() {
            return new DepartmentRequest(this);
        }
    }
}
