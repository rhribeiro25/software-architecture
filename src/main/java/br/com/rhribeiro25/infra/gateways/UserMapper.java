package br.com.rhribeiro25.infra.gateways;

import br.com.rhribeiro25.domain.User;
import br.com.rhribeiro25.infra.persistence.UserEntity;

public class UserMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getName(),
                user.getBirth(), user.getEmail());
    }

    public User toDomain(UserEntity entity) {
        return new User.Builder()
                .cpf(entity.getCpf())
                .name(entity.getName())
                .birth(entity.getBirth())
                .email(entity.getEmail())
                .build();
    }
}
