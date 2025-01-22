package br.com.rhribeiro25.domain.models.tax;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

// This class represents the ISS tax, implementing a specific calculation strategy.
public class ISS extends Tax {

    /**
     * Constructor to allow composition of multiple taxes using the Decorator pattern.
     *
     * @param additionalTax The next tax to be calculated, if any.
     */
    public ISS(Tax additionalTax) {
        super(additionalTax);
    }

    /**
     * Performs the specific ISS calculation: 6% of the budget value.
     *
     * @param budget The budget on which the ISS tax is calculated.
     * @return The ISS tax value.
     */
    @Override
    protected BigDecimal calculateSpecificTax(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.06"));
    }
}
