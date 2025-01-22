package br.com.rhribeiro25.interfaces.dtos;

import java.math.BigDecimal;

public class GenerateOrderRequest {
    private String client;
    private BigDecimal budgetValue;
    private int itemCount;

    public GenerateOrderRequest(String client, BigDecimal budgetValue, int itemCount) {
        this.client = client;
        this.budgetValue = budgetValue;
        this.itemCount = itemCount;
    }

    public String getClient() {
        return client;
    }

    public BigDecimal getBudgetValue() {
        return budgetValue;
    }

    public int getItemCount() {
        return itemCount;
    }
}
