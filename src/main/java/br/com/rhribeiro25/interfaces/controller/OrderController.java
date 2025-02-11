package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.GenerateOrderHandler;
import br.com.rhribeiro25.infrastructure.database.repositories.OrderDbRepository;
import br.com.rhribeiro25.infrastructure.file.repositories.OrderFileRepository;
import br.com.rhribeiro25.interfaces.dtos.GenerateOrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Demonstrates the usage of the Command pattern for order processing.
 *
 * Design Pattern: Command
 * - The GenerateOrderHandler executes a series of commands (actions) such as saving the order to the database or sending an email.
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @PostMapping("/process")
    public ResponseEntity<Void> processOrder(@RequestBody GenerateOrderRequest orderRequest) {
        // Extract the order details from the request
        String client = orderRequest.getClient();
        BigDecimal budgetValue = orderRequest.getBudgetValue();
        int itemCount = orderRequest.getItemCount();

        // Create the GenerateOrderRequest and execute the handler
        GenerateOrderHandler handler = new GenerateOrderHandler(Arrays.asList(
                new OrderDbRepository(),
                new OrderFileRepository()));
        handler.execute(orderRequest); // Executes the commands (actions) like saving to DB and file

        return ResponseEntity.ok().build(); // Returns 200 OK indicating the order has been processed
    }
}

