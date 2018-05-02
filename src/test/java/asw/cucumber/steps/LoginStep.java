package asw.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	
	
	private String agenteEmail;
	private String agenteContraseña;
	private String agenteTipo;

	@Given("^El agente con email \"([^\"]*)\"$")
	public void el_agente_con_email(String agenteEmail) throws Throwable{
	      System.out.println("El email del agente es: " + agenteEmail);	
	}
	
	@And("^Contraseña del angente \"([^\"]*)\"$")
	public void contraseña_del_agente(String agenteContraseña) throws Throwable{
	      System.out.println("La contraseña del agente es: " + agenteContraseña);	
	}
	@And("^Tipo de angente \"([^\"]*)\"$")
	public void tipo_de_agente(String agenteTipo) throws Throwable{
	      System.out.println("El tipo de agente es: " + agenteTipo);	
	}

}
