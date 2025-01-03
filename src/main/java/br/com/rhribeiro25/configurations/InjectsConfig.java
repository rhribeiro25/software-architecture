package br.com.rhribeiro25.configurations;

import br.com.rhribeiro25.application.mappers.DepartmentAppMapper;
import br.com.rhribeiro25.application.usecases.*;
import br.com.rhribeiro25.domain.repositories.DepartmentRepository;
import br.com.rhribeiro25.domain.repositories.EmployeeRepository;
import br.com.rhribeiro25.infrastructure.database.mappers.DepartmentDbMapper;
import br.com.rhribeiro25.infrastructure.database.repositories.DepartmentDbRepository;
import br.com.rhribeiro25.infrastructure.database.repositories.jpa.DepartmentJpaRepository;
import br.com.rhribeiro25.infrastructure.file.mappers.EmployeeFileMapper;
import br.com.rhribeiro25.infrastructure.database.repositories.EmployeeDbRepository;
import br.com.rhribeiro25.infrastructure.database.repositories.jpa.EmployeeJpaRepository;
import br.com.rhribeiro25.infrastructure.file.repositories.EmployeeFileRepository;
import br.com.rhribeiro25.infrastructure.messaging.mappers.EmployeeMsgMapper;
import br.com.rhribeiro25.interfaces.mappers.DepartmentIntMapper;
import br.com.rhribeiro25.interfaces.mappers.EmployeeIntMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import br.com.rhribeiro25.application.mappers.EmployeeAppMapper;
import br.com.rhribeiro25.infrastructure.database.mappers.EmployeeDbMapper;

@Configuration
public class InjectsConfig {

    @Bean
    EmployeeAppMapper employeeAppMapperBean(){
        return new EmployeeAppMapper();
    }

    @Bean
    EmployeeIntMapper employeeIntMapperBean(){
        return new EmployeeIntMapper();
    }

    @Bean
    EmployeeDbMapper employeeDbMapperBean(){
        return new EmployeeDbMapper();
    }

    @Bean
    EmployeeFileMapper employeeFileMapperBean(){
        return new EmployeeFileMapper();
    }

    @Bean
    EmployeeMsgMapper employeeMsgMapperBean(){
        return new EmployeeMsgMapper();
    }

    @Bean
    DepartmentAppMapper departmentAppMapperBean(){
        return new DepartmentAppMapper();
    }

    @Bean
    DepartmentIntMapper departmentIntMapperBean(){
        return new DepartmentIntMapper();
    }

    @Bean
    DepartmentDbMapper departmentDbMapperBean(){
        return new DepartmentDbMapper();
    }

    @Bean
    CreateEmployee createEmployeeBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new CreateEmployee(repository, mapper);
    }

    @Bean
    CreateRandomEmployee createRandomEmployeeBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new CreateRandomEmployee(repository, mapper);
    }

    @Bean
    WriteEmployee writeEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new WriteEmployee(repository, mapper);
    }

    @Bean
    WriteRandomEmployee writeRandomEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new WriteRandomEmployee(repository, mapper);
    }

    @Bean
    ListEmployee listEmployeeBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new ListEmployee(repository, mapper);
    }

    @Bean
    ReadEmployee readEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper, SortedEmployee sorted){
        return new ReadEmployee(repository, mapper, sorted);
    }

    @Bean
    SortedEmployee sortedEmployeeBean(){
        return new SortedEmployee();
    }

    @Bean
    CreateDepartment createDepartmentBean(@Qualifier("departmentDbRepositoryBean") DepartmentRepository repository, DepartmentAppMapper mapper){
        return new CreateDepartment(repository, mapper);
    }

    @Bean
    ListDepartment listDepartmentBean(@Qualifier("departmentDbRepositoryBean") DepartmentRepository repository, DepartmentAppMapper mapper){
        return new ListDepartment(repository, mapper);
    }

    @Bean(name = "employeeDbRepositoryBean")
    EmployeeRepository employeeDbRepositoryBean(EmployeeJpaRepository employeeJpaRepository, DepartmentJpaRepository departmentJpaRepository, EmployeeDbMapper mapper){
        return new EmployeeDbRepository(employeeJpaRepository, departmentJpaRepository, mapper );
    }

    @Bean(name = "employeeFileRepositoryBean")
    EmployeeRepository employeeFileRepositoryBean(EmployeeFileMapper mapper, ObjectMapper objectMapper){
        return new EmployeeFileRepository(mapper, objectMapper);
    }

    @Bean(name = "departmentDbRepositoryBean")
    DepartmentDbRepository departmentDbRepositoryBean(DepartmentJpaRepository jpaRepository, DepartmentDbMapper mapper){
        return new DepartmentDbRepository(jpaRepository, mapper );
    }

}
