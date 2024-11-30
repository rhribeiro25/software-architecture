package br.com.rhribeiro25.domain;

public class Department {

    private String name;

    public Department() {}

    // Construtor privado (para impedir instâncias diretas sem o builder)
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
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }

    // Classe Builder estática
    public static class Builder {

        private String name;

        public Department.Builder name(String name) {
            this.name = name;
            return this;
        }

        // Método para criar a instância do Employee
        public Department build() {
            return new Department(this);
        }
    }
}
