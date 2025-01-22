package br.com.rhribeiro25.domain.models.budget;

import Exceptions.DomainException;

import java.math.BigDecimal;

public class Finalized extends BudgetState {

    @Override
    public BigDecimal calculateExtraDiscount(Budget budget) {
        throw new DomainException("Finalized budgets cannot receive extra discounts!");
    }
}