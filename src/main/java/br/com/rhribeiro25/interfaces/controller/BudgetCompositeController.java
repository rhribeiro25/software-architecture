package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetProxy;

import java.math.BigDecimal;

public class BudgetCompositeController {

    /**
     * Demonstrates the usage of the Composite pattern with Budget objects.
     *
     * Design Pattern: Composite
     * - Budget objects can contain other Budget objects (sub-budgets), forming a tree-like structure. The BudgetProxy ensures
     *   that the total value of all items (including sub-budgets) is calculated lazily.
     */
    public void calculateBudget() {
        Budget oldBudget = new Budget();
        oldBudget.addItem(new BudgetItem(new BigDecimal("200")));

        Budget newBudget = new Budget();
        newBudget.addItem(new BudgetItem(new BigDecimal("500")));
        newBudget.addItem(oldBudget);

        BudgetProxy proxy = new BudgetProxy(newBudget);

        System.out.println(proxy.getValue()); // Lazy calculation
        System.out.println(proxy.getValue()); // Cached value
    }
}