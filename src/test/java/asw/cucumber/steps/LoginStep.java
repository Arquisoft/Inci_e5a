package asw.cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class LoginStep {

	  private WebDriver driver = null;
	  private String url = "http://localhost:8090/";
	  
	  public String agenteEmail;
	  public String agenteContraseña;
	  public String agenteTipo;
	  
	  @Autowired
	   AgentsService agentsService;
	  
    

    @Dado("^El agente con email \"([^\"]*)\"$")
    public void el_agente_con_email(String agenteEmail) throws Throwable {
    this.agenteEmail = agenteEmail;
    System.out.println("El email del agente es: " + agenteEmail);
    }
    

    @Y("^Contraseña del angente \"([^\"]*)\"$")
    public void contraseña_del_agente(String agenteContraseña) throws Throwable {
        this.agenteContraseña = agenteContraseña;
    	System.out.println("La contraseña del agente es: " + agenteContraseña);
    }

	@Y("^Tipo de angente \"([^\"]*)\"$")
	public void tipo_de_agente(String agenteTipo) throws Throwable {
		this.agenteTipo = agenteTipo;
		System.out.println("El tipo de agente es: " + agenteTipo);

	}

    @Cuando("^introduzco los datos en el formulario$")
    public void introduzco_los_datos_en_el_formulario_login() {
	url = "http://localhost:8090/userlogin";
	driver.get(url);
	driver.navigate().to(url);
	driver.findElement(By.id("email")).sendKeys(agenteEmail);
	driver.findElement(By.id("password")).sendKeys(agenteContraseña);
	driver.findElement(By.id("kind")).sendKeys(agenteTipo);
	System.out.println("Introduciendo datos en el formulario...");

    }

    @Y("^presiono el boton de iniciar sesion")
    public void presiono_el_boton_de_iniciar_sesion() {
    driver.findElement(By.id("login")).click();
	System.out.println("Presionando botón de iniciar sesión");
    }

    @Entonces("^se inicia sesión$")
    public void se_inicia_sesion() {
	Agent agent = agentsService.getAgent(agenteEmail);
	if (agent != null && agent.getPassword().equals(agenteContraseña) && agent.getKind().equals(agenteTipo))
	    System.out.println("Se ha iniciado sesión correctamente");
	else
	    System.out.println("No se ha iniciado sesión");
    }

}
