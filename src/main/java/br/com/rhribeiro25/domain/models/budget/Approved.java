package br.com.rhribeiro25.domain.models.budget;

import java.math.BigDecimal;

public class Approved extends BudgetState {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.02"));
    }

    @Override
    public void finalize(Budget budget) {
        budget.setState(new Finalized());
    }
}