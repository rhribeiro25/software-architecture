package br.com.rhribeiro25.domain.models.tax;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

// Abstract class representing a generic tax.
// Implements the DECORATOR PATTERN to allow combining multiple taxes.
public abstract class Tax {

    private final Tax additionalTax;

    /**
     * Constructor to allow combining this tax with another.
     *
     * @param additionalTax The next tax in the chain.
     */
    protected Tax(Tax additionalTax) {
        this.additionalTax = additionalTax;
    }

    /**
     * Abstract method for specific tax calculations, implemented by subclasses.
     *
     * @param budget The budget on which the tax is calculated.
     * @return The calculated tax value.
     */
    protected abstract BigDecimal calculateSpecificTax(Budget budget);

    /**
     * Calculates the total tax by combining the current tax with any additional tax.
     *
     * @param budget The budget on which the taxes are calculated.
     * @return The total tax value.
     */
    public BigDecimal calculate(Budget budget) {
        BigDecimal primaryTax = calculateSpecificTax(budget);
        BigDecimal additionalTaxValue = additionalTax != null ? additionalTax.calculateSpecificTax(budget) : BigDecimal.ZERO;
        return primaryTax.add(additionalTaxValue);
    }
}
