package br.com.rhribeiro25.infra.gateways;

import br.com.rhribeiro25.application.gateways.UserRepository;
import br.com.rhribeiro25.domain.User;
import br.com.rhribeiro25.infra.persistence.UserEntity;
import br.com.rhribeiro25.infra.persistence.UserJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserJpaRepositoryImpl implements UserRepository {
    private final UserJpaRepository repository;
    private final UserMapper mapper;

    public UserJpaRepositoryImpl(UserJpaRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User create(User user) {
        UserEntity entity = mapper.toEntity(user);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<User> listAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
