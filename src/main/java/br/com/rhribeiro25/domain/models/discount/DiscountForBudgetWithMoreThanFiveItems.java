package br.com.rhribeiro25.domain.models.discount;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

/**
 * Concrete handler in the Chain of Responsibility.
 * Applies a 10% discount if the budget contains more than five items.
 */
public class DiscountForBudgetWithMoreThanFiveItems extends Discount {

    public DiscountForBudgetWithMoreThanFiveItems(Discount next) {
        super(next);
    }

    @Override
    protected BigDecimal performCalculation(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }

    @Override
    protected boolean shouldApply(Budget budget) {
        return budget.getItemCount() > 5;
    }
}