package asw.cucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class AgentsStep {
	
	@Autowired AgentsService agentsService;
	private String user, password,type;
	
	@Dado("^el email del agente es \"([^\"]*)\"$")
	public void email(String usuarioAgente) {
		this.user = usuarioAgente;
		System.out.println("El usuario del agente es " + usuarioAgente);
	}
	
	@Y("^su contraseña es \"([^\"]*)\"$")
	public void su_contraseña(String contraseña) {
		this.password = contraseña;
		System.out.println("La contraseña del agente es " + contraseña);
	}
	
	@Y("^su tipo es \"([^\"]*)\"$")
	public void su_tipo(String tipo) {
		this.type = tipo;
		System.out.println("El tipo del agente es " + tipo);
	}
	
	@Cuando("^el agente los introduce en el formulario$")
	public void agente_introduce_datos_formulario() {
		System.out.println("El agente introduce sus datos en el formulario");
	}
	
	@Y("^presiona el boton$")
	public void presiona_el_boton() {
		System.out.println("El agente presiona el boton");
	}
	
	@Entonces("^se envia la peticion$")
	public void se_envia_la_peticion() {
		System.out.println("Se envia la peticion");
	}
	
	@Y("^se obtienen los datos del agente")
	public void se_obtienen_los_datos_del_agente() {
		Agent agent = agentsService.getAgent(user);
		if (agent.getPassword().equals(password) && agent.getKind().equals(type))
			System.out.println("Se obtienen correctamente los datos del agente");
		else System.out.println("Error al obtener los datos del agente");
	}
	
}
