package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.models.order.Order;
import br.com.rhribeiro25.domain.repositories.OrderRepository;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;
import br.com.rhribeiro25.interfaces.dtos.GenerateOrderRequest;

import java.time.LocalDateTime;
import java.util.List;

public class OrderCommandHandler {

    private List<OrderRepository> repositories;

    /**
     * Constructor that injects the actions to be performed after generating an order.
     *
     * @param repositories A list of actions (OrderRepository implementations) to run after generating an order.
     *                               This allows flexibility in the actions to be executed.
     *                               <p>Design Pattern: Dependency Injection</p>
     */
    public OrderCommandHandler(List<OrderRepository> repositories) {
        this.repositories = repositories;
    }

    /**
     * Generates an order and performs post-generation actions.
     *
     * @param request The request containing client and budget data.
     *                This encapsulates all the information required to generate the order.
     *                <p>Design Patterns Used:</p>
     *                <ul>
     *                  <li><strong>Strategy:</strong> The list of post-generation actions can have different implementations, which can be swapped or extended without modifying the handler.</li>
     *                  <li><strong>Command:</strong> Each action is encapsulated and executed like a command after the order is generated.</li>
     *                </ul>
     */
    public void execute(GenerateOrderRequest request) {
        // Create budget and add an item
        Budget budget = new Budget();
        budget.addItem(new BudgetItem(request.getBudgetValue()));

        // Create the order
        Order order = new Order(request.getClient(), LocalDateTime.now(), budget);

        // Execute all post-generation actions (e.g., saving, notifications)
        this.repositories.forEach(action -> action.save(order));
    }
}