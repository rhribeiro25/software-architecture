package br.com.rhribeiro25.domain.valueobjects.budget;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

public class BudgetProxy extends Budget {

    private BigDecimal value;
    private Budget budget;

    /**
     * Constructor for BudgetProxy.
     *
     * Design Pattern: Proxy
     * - The BudgetProxy class acts as a proxy for the real `Budget` object.
     * - It controls access to the actual `Budget` object, and in this case, it lazily calculates the total value (caching the result).
     * - The proxy pattern is used to add extra functionality (like caching) without modifying the original `Budget` object.
     */
    public BudgetProxy(Budget budget) {
        this.budget = budget;
    }

    /**
     * Retrieves the value of the budget, calculating it only when needed (lazy initialization).
     *
     * Design Pattern: Proxy (Lazy Initialization)
     * - The value is only calculated and stored the first time it is accessed.
     * - This avoids unnecessary calculations, improving performance when the value is not always needed.
     */
    public BigDecimal getValue() {
        if (this.value == null) {
            this.value = budget.getValue(); // Lazy loading
        }
        return this.value;
    }
}