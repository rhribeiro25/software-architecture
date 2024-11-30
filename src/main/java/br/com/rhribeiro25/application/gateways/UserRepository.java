package br.com.rhribeiro25.application.gateways;

import br.com.rhribeiro25.domain.User;

import java.util.List;

public interface UserRepository {
    User create(User user);

    List<User> listAll();
}
