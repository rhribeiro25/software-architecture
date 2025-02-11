package br.com.rhribeiro25.interfaces.controller;

import br.com.rhribeiro25.application.usecases.BudgetRegistration;
import br.com.rhribeiro25.application.usecases.DiscountCalculator;
import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.domain.models.tax.ICMS;
import br.com.rhribeiro25.domain.models.tax.ISS;
import br.com.rhribeiro25.domain.models.tax.Tax;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetItem;
import br.com.rhribeiro25.domain.valueobjects.budget.BudgetProxy;
import br.com.rhribeiro25.interfaces.http.ApacheHttpAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    /**
     * Creates a Budget, approves it, finalizes it, and then registers the Budget.
     *
     * Design Pattern: Adapter
     * - The ApacheHttpAdapter is used to adapt an external API or service to our internal code, allowing interaction with it.
     */
    @PostMapping
    public ResponseEntity<Void> generateBudget(@RequestParam BigDecimal budgetValue) {
        Budget budget = new Budget();
        budget.addItem(new BudgetItem(budgetValue));
        budget.approve();
        budget.isFinalized();

        BudgetRegistration registry = new BudgetRegistration(new ApacheHttpAdapter());
        registry.register(budget);

        return ResponseEntity.created(URI.create("/api/budgets")).build();
    }

    /**
     * Demonstrates the usage of the Composite pattern with Budget objects.
     *
     * Design Pattern: Composite
     * - Budget objects can contain other Budget objects (sub-budgets), forming a tree-like structure. The BudgetProxy ensures
     *   that the total value of all items (including sub-budgets) is calculated lazily.
     */
    @PostMapping("/calculate")
    public ResponseEntity<BigDecimal> calculateBudget(
            @RequestParam BigDecimal oldBudgetValue,
            @RequestParam BigDecimal newBudgetValue) {

        Budget oldBudget = new Budget();
        oldBudget.addItem(new BudgetItem(oldBudgetValue));

        Budget newBudget = new Budget();
        newBudget.addItem(new BudgetItem(newBudgetValue));
        newBudget.addItem(oldBudget);

        BudgetProxy proxy = new BudgetProxy(newBudget);
        BigDecimal totalValue = proxy.getValue();

        return ResponseEntity.ok(totalValue);
    }

    /**
     * Calculates discounts based on the Strategy pattern.
     *
     * Design Pattern: Strategy
     * - The DiscountCalculator applies different discount strategies based on the rules defined for the Budget object.
     */
    @PostMapping("/apply-discount")
    public ResponseEntity<List<BigDecimal>> applyDiscount(
            @RequestParam BigDecimal firstBudgetValue,
            @RequestParam BigDecimal secondBudgetValue,
            @RequestParam BigDecimal thirdBudgetValue) {

        // Create the budgets with the passed values
        Budget first = new Budget();
        first.addItem(new BudgetItem(firstBudgetValue));

        Budget second = new Budget();
        second.addItem(new BudgetItem(secondBudgetValue));

        Budget third = new Budget();
        third.addItem(new BudgetItem(thirdBudgetValue));

        // Create the discount calculator
        DiscountCalculator calculator = new DiscountCalculator();

        // Calculate the discount for each budget
        List<BigDecimal> discounts = new ArrayList<>();
        discounts.add(calculator.calculate(first));
        discounts.add(calculator.calculate(second));
        discounts.add(calculator.calculate(third));

        // Return the list of calculated discounts as the response body
        return ResponseEntity.ok(discounts);
    }

    /**
     * Calculates the tax (Tax) on a Budget using the Decorator pattern.
     *
     * Design Pattern: Decorator
     * - The ICMS and ISS classes decorate the base Tax class to add additional tax calculation logic.
     */
    @PostMapping("/calculate-tax")
    public ResponseEntity<BigDecimal> calculateTax(@RequestParam BigDecimal budgetValue) {
        // Create the budget with the provided value
        Budget budget = new Budget();
        budget.addItem(new BudgetItem(budgetValue));

        // Decorate the tax calculation with ICMS and ISS
        Tax tax = new ICMS(new ISS(null));

        // Calculate the tax
        BigDecimal calculatedTax = tax.calculate(budget);

        // Return the calculated tax as the response body
        return ResponseEntity.ok(calculatedTax);
    }
}

