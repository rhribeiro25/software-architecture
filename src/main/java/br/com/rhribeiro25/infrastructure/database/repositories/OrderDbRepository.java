package br.com.rhribeiro25.infrastructure.database.repositories;

import br.com.rhribeiro25.domain.models.employee.Employee;
import br.com.rhribeiro25.domain.models.order.Order;
import br.com.rhribeiro25.domain.repositories.OrderRepository;

import java.util.List;

public class OrderDbRepository implements OrderRepository {

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public Employee save(Order employee) {
        System.out.println("Saving order to the database...");
        // Logic to save the order
        return null;
    }

    @Override
    public Employee update(Order employee) {
        return null;
    }

    @Override
    public Employee findByDocument(String code) {
        return null;
    }

    @Override
    public boolean deleteByDocument(String code) {
        return false;
    }
}
