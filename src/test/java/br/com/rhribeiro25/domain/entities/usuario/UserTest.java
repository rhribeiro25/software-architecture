package br.com.rhribeiro25.domain.entities.usuario;

import br.com.rhribeiro25.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UserTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User.Builder()
                        .cpf("123456.789-99")
                        .email("email@email.com")
                        .name("Jacque")
                        .birth(LocalDate.parse("1990-09-08"))
                        .build());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User.Builder()
                        .cpf("12345678999")
                        .email("email@email.com")
                        .name("Jacque")
                        .birth(LocalDate.parse("1990-09-08"))
                        .build());


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User.Builder()
                        .cpf("")
                        .email("email@email.com")
                        .name("Jacque")
                        .birth(LocalDate.parse("1990-09-08"))
                        .build());

    }
}
