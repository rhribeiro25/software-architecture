package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.BudgetRegistration;
import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;
import br.com.rhribeiro25.interfaces.http.ApacheHttpAdapter;

import java.math.BigDecimal;

public class BudgetController {

    /**
     * Creates a Budget, approves it, finalizes it, and then registers the Budget.
     *
     * Design Pattern: Adapter
     * - The ApacheHttpAdapter is used to adapt an external API or service to our internal code, allowing interaction with it.
     */
    public void generateBudget() {
        Budget budget = new Budget();
        budget.addItem(new BudgetItem(BigDecimal.TEN));
        budget.approve();
        budget.isFinalized();

        BudgetRegistration registry = new BudgetRegistration(new ApacheHttpAdapter());
        registry.register(budget);
    }
}