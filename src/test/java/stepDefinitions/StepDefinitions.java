package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.PendingException;

public class StepDefinitions {

    @Given("o limite de valor definido pelo usuário é {double}")
    public void definirValorLimite(Double limite) {
        throw new PendingException();
    }

    @Then("o usuário visualiza o alerta {string}")
    public void oUsuarioVisualizaOAlerta(String string) {
        throw new PendingException();
    }

    @When("o usuário adiciona {int} itens avulsos")
    public void oUsuárioAdicionaItensAvulsos(Integer int1) {
        throw new PendingException();
    }
}
