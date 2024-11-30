package br.com.rhribeiro25.config;

import br.com.rhribeiro25.application.gateways.EmployeeRepository;
import br.com.rhribeiro25.application.gateways.UserRepository;
import br.com.rhribeiro25.application.usecases.CreateUser;
import br.com.rhribeiro25.application.usecases.ListUser;
import br.com.rhribeiro25.application.usecases.ReadEmployee;
import br.com.rhribeiro25.application.usecases.WriteEmployee;
import br.com.rhribeiro25.infra.gateways.EmployeeFileRepositoryImpl;
import br.com.rhribeiro25.infra.gateways.UserJpaRepositoryImpl;
import br.com.rhribeiro25.infra.gateways.UserMapper;
import br.com.rhribeiro25.infra.persistence.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InjectsConfig {

    @Bean
    CreateUser createUserBean(UserRepository userRepository){
        return new CreateUser(userRepository);
    }

    @Bean
    ListUser listUserBean(UserRepository userRepository){
        return new ListUser(userRepository);
    }

    @Bean
    UserJpaRepositoryImpl userJpaRepositoryImplBean(UserJpaRepository repositorio, UserMapper mapper){
        return new UserJpaRepositoryImpl(repositorio, mapper);
    }

    @Bean
    UserMapper userMapperBean(){
        return new UserMapper();
    }

    @Bean
    WriteEmployee writeEmployeeBean(EmployeeRepository employeeRepository){
        return new WriteEmployee(employeeRepository);
    }

    @Bean
    EmployeeRepository employeeRepositoryBean (){
        return new EmployeeFileRepositoryImpl();
    }

    @Bean
    ReadEmployee readEmployeeBean(EmployeeRepository employeeRepository){
        return new ReadEmployee(employeeRepository);
    }
}
