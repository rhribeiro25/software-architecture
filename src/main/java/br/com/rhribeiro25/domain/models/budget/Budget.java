package br.com.rhribeiro25.domain.models.budget;

import br.com.rhribeiro25.domain.valueobjects.budget.Budgetable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Budget implements Budgetable {

    private List<Budgetable> items = new ArrayList<>();
    private BigDecimal value = BigDecimal.ZERO;
    private BudgetState state;

    /**
     * Constructor for Budget.
     *
     * Design Pattern: State
     * - The `Budget` class uses the State pattern, where the state of the budget (e.g., "In Analysis", "Approved", "Completed") determines its behavior.
     * - The current state is encapsulated in the `situation` attribute, and the behavior changes according to this state.
     */
    public Budget() {
        this.state = new InAnalysis(); // Initial state
    }

    /**
     * Applies an additional discount based on the current budget situation.
     *
     * Design Pattern: Strategy
     * - The discount calculation strategy is determined by the `situation` (state) of the budget.
     * - This allows the discount logic to change dynamically depending on the current state of the budget.
     */
    public void applyExtraDiscount() {
        BigDecimal extraDiscountValue = this.state.calculateExtraDiscount(this);
        this.value = this.value.subtract(extraDiscountValue);
    }

    /**
     * Approves the budget, changing its situation.
     */
    public void approve() {
        this.state.approve(this);
    }

    /**
     * Rejects the budget, changing its situation.
     */
    public void reject() {
        this.state.reject(this);
    }

    /**
     * Finalizes the budget, changing its situation.
     */
    public void complete() {
        this.state.finalize(this);
    }

    /**
     * Returns the value of the budget, simulating a delay for calculation.
     *
     * Design Pattern: Proxy (Lazy Initialization)
     * - This method simulates a delay (via `Thread.sleep`) when retrieving the value, which could be used for lazy initialization or caching.
     */
    public BigDecimal getValue() {
        try {
            Thread.sleep(3000); // Simulating delay
            return this.value;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the number of items in the budget.
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Returns the current situation of the budget.
     */
    public BudgetState getState() {
        return state;
    }

    /**
     * Sets the situation of the budget.
     */
    public void setState(BudgetState state) {
        this.state = state;
    }

    /**
     * Checks if the budget is finalized.
     */
    public boolean isFinalized() {
        return this.state instanceof Finalized;
    }

    /**
     * Adds an item to the budget and updates its total value.
     */
    public void addItem(Budgetable item) {
        this.value = this.value.add(item.getValue());
        this.items.add(item);
    }
}
