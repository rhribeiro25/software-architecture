package br.com.rhribeiro25.domain.models.order;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.time.LocalDateTime;

public class Order {

    private String client;
    private LocalDateTime date;
    private Budget budget;

    public Order(String client, LocalDateTime date, Budget budget) {
        this.client = client;
        this.date = date;
        this.budget = budget;
    }

    public String getClient() {
        return client;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Budget getBudget() {
        return budget;
    }

}