package cucumber_manager.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import asw.Application;
import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
@ActiveProfiles("INTEGRATION_TEST")
public class AgenteIniciaSesionValido 
{
	@Autowired
    AgentsService agentsService;
    
    String user, password, type;

    @Dado("^el email del agente es \'([^\"]*)\'$")
    public void email(String user) 
    {
    	this.user = user;
    	System.out.println("El usuario del agente es " + user);
    }

    @Y("^su password es \'([^\"]*)\'$")
    public void password(String password) 
    {
    	this.password = password;
    	System.out.println("La contraseña del agente es " + password);
    }

    @Y("^su tipo es \'([^\"]*)\'$")
    public void tipo(String type) 
    {
    	this.type = type;
    	System.out.println("El tipo del agente es " + type);
    }

    @Cuando("^tratamos de logearnos con esas credenciales$")
    public void login() 
    {
    	Agent agent = agentsService.getAgent(user);
    	System.out.println(agent.toString());
    }

    @Entonces("^el agente ingresa en el sistema$")
    public void log_correcto() 
    {
    	System.out.println("Usuario logeado en el sistema");
    }
}