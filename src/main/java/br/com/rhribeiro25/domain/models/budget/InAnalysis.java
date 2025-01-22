package br.com.rhribeiro25.domain.models.budget;

import java.math.BigDecimal;

public class InAnalysis extends BudgetState {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.05"));
    }

    @Override
    public void approve(Budget budget) {
        budget.setState(new Approved());
    }

    @Override
    public void reject(Budget budget) {
        budget.setState(new Rejected());
    }
}