package br.com.rhribeiro25.domain.models.tax;

import br.com.rhribeiro25.domain.models.budget.Budget;

import java.math.BigDecimal;

// This class represents the ICMS tax, implementing a specific calculation strategy.
public class ICMS extends Tax {

    /**
     * Constructor to allow composition of multiple taxes using the Decorator pattern.
     *
     * @param additionalTax The next tax to be calculated, if any.
     */
    public ICMS(Tax additionalTax) {
        super(additionalTax);
    }

    @Override
    protected BigDecimal calculateSpecificTax(Budget budget) {
        return budget.getValue().multiply(new BigDecimal("0.1"));
    }
}
