package br.com.rhribeiro25.domain.models.budget;

import Exceptions.DomainException;

import java.math.BigDecimal;

public abstract class BudgetState {

    // Calculate extra discount based on the budget state
    public abstract BigDecimal calculateExtraDiscount(Budget budget);

    // Transition methods overridden in concrete states
    public void approve(Budget budget) throws DomainException {
        throw new DomainException("Budget cannot be approved in this state!");
    }

    public void reject(Budget budget) throws DomainException {
        throw new DomainException("Budget cannot be rejected in this state!");
    }

    public void finalize(Budget budget) throws DomainException {
        throw new DomainException("Budget cannot be finalized in this state!");
    }
}