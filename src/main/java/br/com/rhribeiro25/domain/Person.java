package br.com.rhribeiro25.domain;

public class Person {

    private String name;

    public  Person() {
    }

    // Construtor privado (para impedir instâncias diretas sem o builder)
    private Person(Person.Builder builder) {
        this.name = builder.name;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return  name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Classe Builder estática
    public static class Builder {

        private String name;

        public Person.Builder role(String name) {
            this.name = name;
            return this;
        }

        // Método para criar a instância do Employee
        public Person build() {
            return new Person(this);
        }
    }
}
