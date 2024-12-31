package br.com.rhribeiro25.configurations;

import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.application.usecases.CreateEmployee;
import br.com.rhribeiro25.application.usecases.ListEmployee;
import br.com.rhribeiro25.application.usecases.ReadEmployee;
import br.com.rhribeiro25.application.usecases.WriteEmployee;
import br.com.rhribeiro25.infrastructure.files.mappers.EmployeeFileMapper;
import br.com.rhribeiro25.infrastructure.files.repositories.EmployeeFileRepository;
import br.com.rhribeiro25.infrastructure.database.repositories.EmployeeDbRepository;
import br.com.rhribeiro25.infrastructure.database.repositories.EmployeeJpaRepository;
import br.com.rhribeiro25.infrastructure.messaging.mappers.EmployeeMsgMapper;
import br.com.rhribeiro25.interfaces.controller.PromptController;
import br.com.rhribeiro25.interfaces.mappers.EmployeeIntMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.infrastructure.database.mappers.EmployeeDbMapper;

@Configuration
public class InjectsConfig {

    @Bean
    EmployeeAppMapper employeeMapperBeanAppMapper(){
        return new EmployeeAppMapper();
    }

    @Bean
    EmployeeDbMapper employeeMapperBeanDbMapper(){
        return new EmployeeDbMapper();
    }

    @Bean
    EmployeeIntMapper employeeMapperBeanIntMapper(){
        return new EmployeeIntMapper();
    }

    @Bean
    EmployeeFileMapper employeeMapperBeanFileMapper(){
        return new EmployeeFileMapper();
    }

    @Bean
    EmployeeMsgMapper employeeMapperBeanMsgMapper(){
        return new EmployeeMsgMapper();
    }

    @Bean
    CreateEmployee createEmployeeBean(EmployeeRepository employeeRepository, EmployeeAppMapper mapper){
        return new CreateEmployee(employeeRepository, mapper);
    }

    @Bean
    ListEmployee listEmployeeBean(EmployeeRepository employeeRepository, EmployeeAppMapper mapper){
        return new ListEmployee(employeeRepository, mapper);
    }

    @Bean
    ReadEmployee readEmployeeBean(EmployeeRepository employeeRepository, EmployeeAppMapper mapper){
        return new ReadEmployee(employeeRepository, mapper);
    }

    @Bean
    WriteEmployee writeEmployeeBean(PromptController promptController, EmployeeRepository employeeRepository, EmployeeAppMapper mapper){
        return new WriteEmployee(promptController, employeeRepository, mapper);
    }

    @Bean
    EmployeeDbRepository employeeJpaRepositoryImplBean(EmployeeJpaRepository repository, EmployeeDbMapper mapper){
        return new EmployeeDbRepository(repository, mapper);
    }

    @Bean
    EmployeeRepository employeeRepositoryBean (){
        return new EmployeeFileRepository();
    }

}
