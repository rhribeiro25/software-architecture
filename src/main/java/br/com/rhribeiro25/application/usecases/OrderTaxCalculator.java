package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.tax.Tax;
import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

// This class represents the tax calculator, which uses the
// STRATEGY PATTERN to calculate taxes dynamically.
public class OrderTaxCalculator {
    /**
     * Executes the tax calculation use case.
     *
     * @param budget The budget on which the taxes will be calculated.
     * @param tax    The tax strategy to be applied.
     * @return The calculated tax amount.
     */
    public BigDecimal execute(Budget budget, Tax tax) {
        return tax.calculate(budget);
    }
}
