package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.GenerateOrderHandler;
import br.com.rhribeiro25.infrastructure.database.repositories.OrderDbRepository;
import br.com.rhribeiro25.infrastructure.file.repositories.OrderFileRepository;
import br.com.rhribeiro25.interfaces.dtos.GenerateOrderRequest;

import java.math.BigDecimal;
import java.util.Arrays;

public class OrderController {

    /**
     * Generates an Order and executes actions using the Command pattern.
     *
     * Design Pattern: Command
     * - The CreateOrderHandler executes a series of commands (actions) such as saving the order to the database or sending an email.
     */
    public void processOrder() {
        String client = "Ana da Silva";
        BigDecimal budgetValue = new BigDecimal("745.99");
        int itemCount = 3;

        GenerateOrderRequest creator = new GenerateOrderRequest(client, budgetValue, itemCount);
        GenerateOrderHandler handler = new GenerateOrderHandler(Arrays.asList(
                new OrderDbRepository(),
                new OrderFileRepository()));
        handler.execute(creator);
    }
}