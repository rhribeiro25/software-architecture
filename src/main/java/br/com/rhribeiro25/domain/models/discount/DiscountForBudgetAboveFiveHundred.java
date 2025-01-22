package br.com.rhribeiro25.domain.models.discount;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

/**
 * Concrete handler in the Chain of Responsibility.
 * Applies a 5% discount if the budget value exceeds 500.
 */
public class DiscountForBudgetAboveFiveHundred extends Discount {

    public DiscountForBudgetAboveFiveHundred(Discount next) {
        super(next);
    }

    @Override
    protected BigDecimal performCalculation(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    protected boolean shouldApply(Budget budget) {
        return budget.getValue().compareTo(new BigDecimal("500")) > 0;
    }
}