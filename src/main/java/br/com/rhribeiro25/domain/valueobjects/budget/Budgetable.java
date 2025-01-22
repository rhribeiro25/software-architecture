package br.com.rhribeiro25.domain.valueobjects.budget;

import java.math.BigDecimal;

public interface Budgetable {

    /**
     * Method to retrieve the value of the object.
     *
     * The `Budgetable` interface represents any object that has a value (e.g., budget, items).
     */
    BigDecimal getValue();
}