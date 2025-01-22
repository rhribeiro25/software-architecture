package br.com.rhribeiro25.domain.models.discount;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

/**
 * Represents a step in the chain for applying discounts.
 * Implements the Chain of Responsibility pattern to decide the appropriate discount to apply.
 */
public abstract class Discount {

    protected Discount next;

    public Discount(Discount next) {
        this.next = next;
    }

    /**
     * Calculate the discount for the given budget.
     * Delegates to the next handler if the current one doesn't apply.
     */
    public BigDecimal calculate(Budget budget) {
        if (shouldApply(budget)) {
            return performCalculation(budget);
        }
        return next.calculate(budget);
    }

    protected abstract BigDecimal performCalculation(Budget budget);
    protected abstract boolean shouldApply(Budget budget);
}