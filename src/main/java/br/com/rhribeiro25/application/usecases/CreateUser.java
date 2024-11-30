package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.gateways.UserRepository;
import br.com.rhribeiro25.domain.User;

public class CreateUser {
    private final UserRepository repository;

    public CreateUser(UserRepository repository) {
        this.repository = repository;
    }

    public User cadastrarUsuario(User user) {
        return repository.create(user);
    }
}
