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
    CreateRandomMockEmployee createRandomMockEmployeeBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new CreateRandomMockEmployee(repository, mapper);
    }

    @Bean
    WriteEmployee writeEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new WriteEmployee(repository, mapper);
    }

    @Bean
    WriteRandomMockEmployee writeRandomMockEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new WriteRandomMockEmployee(repository, mapper);
    }

    @Bean
    FindEmployeeByDocument findEmployeeByDocumentBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper) {
        return new FindEmployeeByDocument(repository, mapper);
    }

    @Bean
    ReadEmployeeUsingSearchAlgorithm readEmployeeUsingSearchAlgorithmBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper, SearchEmployee search) {
        return new ReadEmployeeUsingSearchAlgorithm(repository, mapper, search);
    }

    @Bean
    FindEmployeeListUsingSortingMethod findEmployeeListUsingSortingMethodBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper){
        return new FindEmployeeListUsingSortingMethod(repository, mapper);
    }

    @Bean
    ReadEmployeeListUsingSortingAlgorithm readEmployeeListUsingSortingAlgorithmBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository, EmployeeAppMapper mapper, SortedEmployee sorted){
        return new ReadEmployeeListUsingSortingAlgorithm(repository, mapper, sorted);
    }

    @Bean
    DeleteEmployee deleteEmployeeBean(@Qualifier("employeeDbRepositoryBean") EmployeeRepository repository){
        return new DeleteEmployee(repository);
    }

    @Bean
    RemoveEmployee removeEmployeeBean(@Qualifier("employeeFileRepositoryBean") EmployeeRepository repository){
        return new RemoveEmployee(repository);
    }
    
    @Bean
    CreateDepartment createDepartmentBean(@Qualifier("departmentDbRepositoryBean") DepartmentRepository repository, DepartmentAppMapper mapper){
        return new CreateDepartment(repository, mapper);
    }

    @Bean
    FindDepartmentList findDepartmentListBean(@Qualifier("departmentDbRepositoryBean") DepartmentRepository repository, DepartmentAppMapper mapper){
        return new FindDepartmentList(repository, mapper);
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
    DepartmentRepository departmentDbRepositoryBean(DepartmentJpaRepository jpaRepository, DepartmentDbMapper mapper){
        return new DepartmentDbRepository(jpaRepository, mapper );
    }

    @Bean
    SortedEmployee sortedEmployeeBean(){
        return new SortedEmployee();
    }

    @Bean
    SearchEmployee searchEmployeeBean(SortedEmployee sorted){
        return new SearchEmployee(sorted);
    }

}
