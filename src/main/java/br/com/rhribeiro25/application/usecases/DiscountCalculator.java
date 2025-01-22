package br.com.rhribeiro25.application.usecases;

import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.models.discount.Discount;
import br.com.rhribeiro25.domain.models.discount.DiscountForBudgetAboveFiveHundred;
import br.com.rhribeiro25.domain.models.discount.DiscountForBudgetWithMoreThanFiveItems;
import br.com.rhribeiro25.domain.models.discount.NoDiscount;

import java.math.BigDecimal;

/**
 * Use case for calculating the applicable discount for a budget.
 * Configures and executes the discount chain.
 */
public class DiscountCalculator {

    public BigDecimal calculate(Budget budget) {
        Discount discountChain = new DiscountForBudgetWithMoreThanFiveItems(
                new DiscountForBudgetAboveFiveHundred(
                        new NoDiscount()
                )
        );
        return discountChain.calculate(budget);
    }
}