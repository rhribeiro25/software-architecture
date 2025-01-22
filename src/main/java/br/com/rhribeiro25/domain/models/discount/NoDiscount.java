package br.com.rhribeiro25.domain.models.discount;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

/**
 * Terminal handler in the Chain of Responsibility.
 * Applies no discount and serves as the end of the chain.
 */
public class NoDiscount extends Discount {

    public NoDiscount() {
        super(null);
    }

    @Override
    protected BigDecimal performCalculation(Budget budget) {
        return BigDecimal.ZERO;
    }

    @Override
    protected boolean shouldApply(Budget budget) {
        return true;
    }
}