package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.application.gateways.UserRepository;
import br.com.rhribeiro25.domain.User;

import java.util.List;

public class ListUser {

    private final UserRepository repository;

    public ListUser(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll(){
        return this.repository.listAll();
    }
}
