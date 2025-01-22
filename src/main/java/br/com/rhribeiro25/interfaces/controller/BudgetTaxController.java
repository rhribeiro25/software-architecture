package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.models.tax.ICMS;
import br.com.rhribeiro25.domain.models.tax.ISS;
import br.com.rhribeiro25.domain.models.tax.Tax;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;

import java.math.BigDecimal;

public class BudgetTaxController {

    /**
     * Calculates the tax (Tax) on a Budget using the Decorator pattern.
     *
     * Design Pattern: Decorator
     * - The ICMS and ISS classes decorate the base Tax class to add additional tax calculation logic.
     */
    public void calculateTax() {
        Budget budget = new Budget();
        budget.addItem(new BudgetItem(new BigDecimal("200")));

        Tax tax = new ICMS(new ISS(null));
        System.out.println(tax.calculate(budget)); // Tax calculation with multiple decorators
    }
}