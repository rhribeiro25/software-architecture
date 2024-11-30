package br.com.rhribeiro25.domain;

import java.time.LocalDate;

public class User {
    private String cpf;
    private String name;
    private LocalDate birth;
    private String email;
    private Address address;

    // Construtor privado (para impedir instâncias diretas sem o builder)
    private User(User.Builder builder) {
        this.cpf = builder.cpf;
        this.name = builder.name;
        this.birth = builder.birth;
        this.email = builder.email;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    // Classe Builder estática
    public static class Builder {

        private String cpf;
        private String name;
        private LocalDate birth;
        private String email;

        public User.Builder cpf(String cpf) {
            if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
                throw new IllegalArgumentException("Cpf no padrão incorreto!");
            }
            this.cpf = cpf;
            return this;
        }

        public User.Builder name(String name) {
            this.name = name;
            return this;
        }

        public User.Builder birth(LocalDate birth) {
            this.birth = birth;
            return this;
        }

        public User.Builder email(String email) {
            this.email = email;
            return this;
        }

        // Método para criar a instância do Employee
        public User build() {
            return new User(this);
        }
    }
}
