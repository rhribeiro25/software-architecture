package br.com.rhribeiro25.infra.controller;

import br.com.rhribeiro25.application.usecases.CreateUser;
import br.com.rhribeiro25.application.usecases.ListUser;
import br.com.rhribeiro25.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;

    public UserController(CreateUser createUser, ListUser listUser) {
        this.createUser = createUser;
        this.listUser = listUser;
    }

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        User salvo = createUser.cadastrarUsuario(new User.Builder()
                .cpf(dto.cpf())
                .name(dto.name())
                .birth(dto.birth())
                .email(dto.email())
                .build());

        return new UserDto(salvo.getCpf(), salvo.getName(), salvo.getBirth(), salvo.getEmail());

    }

    @GetMapping
    public List<UserDto> getAll() {
        return listUser.getAll().stream()
                .map(u -> new UserDto(u.getCpf(), u.getName(), u.getBirth(), u.getEmail()))
                .collect(Collectors.toList());
    }
}
