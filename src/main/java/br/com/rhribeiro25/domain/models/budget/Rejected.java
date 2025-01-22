package br.com.rhribeiro25.domain.models.budget;

import Exceptions.DomainException;

import java.math.BigDecimal;

public class Rejected extends BudgetState {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        throw new DomainException("Rejected budgets cannot receive extra discounts!");
    }

    @Override
    public void finalize(Budget budget) {
        budget.setState(new Finalized());
    }
}