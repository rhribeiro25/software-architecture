package br.com.rhribeiro25.domain.repositories;

import br.com.rhribeiro25.domain.models.employee.Employee;
import br.com.rhribeiro25.domain.models.order.Order;

import java.util.List;

// STRATEGY PATTERN offers flexibility to update, reusability across contexts,
// and scalability for complex cases with new strategies.

public interface OrderRepository {

    List<Employee> findAll();

    Employee save(Order employee);

    Employee update(Order employee);

    Employee findByDocument(String code);

    boolean deleteByDocument(String code);
}
