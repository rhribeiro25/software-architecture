package br.com.rhribeiro25.application.usecases;

import Exceptions.DomainException;
import br.com.rhribeiro25.domain.models.budget.Budget;
import br.com.rhribeiro25.interfaces.http.HttpAdapter;

import java.util.Map;

public class BudgetRegistration {

    private HttpAdapter httpAdapter;

    /**
     * Constructor for BudgetRegistration.
     *
     * Design Pattern: Dependency Injection
     * - The `HttpAdapter` is injected into the `BudgetRegistration` class, providing flexibility to use different types of HTTP clients (e.g., Apache Http, Java URLConnection).
     * - The class does not directly depend on a specific HTTP client but rather on an abstraction (`HttpAdapter`), which allows for easier testing and flexibility.
     */
    public BudgetRegistration(HttpAdapter httpAdapter) {
        this.httpAdapter = httpAdapter;
    }

    /**
     * Registers a finalized budget by sending its data to an external API.
     *
     * Design Pattern: Facade
     * - The `BudgetRegistration` class acts as a facade, simplifying the interaction with the external API.
     * - It provides a simplified interface (`registrar`) to clients, hiding the complexities of sending an HTTP request.
     */
    public void register(Budget budget) {
        // Ensure the budget is finalized before registration
        if (!budget.isFinalized()) {
            throw new DomainException("A non-finalized budget cannot be registered!");
        }

        // Prepare the data for the API request
        String apiUrl = "http://api.xyz/budget";
        Map<String, Object> apiData = Map.of(
                "value", budget.getValue(),
                "itemCount", budget.getItemCount()
        );

        // Use the HttpAdapter to send the data to the API
        httpAdapter.post(apiUrl, apiData);
    }
}
