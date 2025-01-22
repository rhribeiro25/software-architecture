package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.DiscountCalculator;
import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;

import java.math.BigDecimal;

public class BudgetDiscountController {

    /**
     * Calculates discounts based on the Strategy pattern.
     *
     * Design Pattern: Strategy
     * - The DiscountCalculator applies different discount strategies based on the rules defined for the Budget object.
     */
    public void applyDiscount() {
        Budget first = new Budget();
        first.addItem(new BudgetItem(new BigDecimal("200")));

        Budget second = new Budget();
        second.addItem(new BudgetItem(new BigDecimal("200")));

        Budget third = new Budget();
        third.addItem(new BudgetItem(new BigDecimal("200")));

        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println(calculator.calculate(first));
        System.out.println(calculator.calculate(second));
        System.out.println(calculator.calculate(third));
    }
}