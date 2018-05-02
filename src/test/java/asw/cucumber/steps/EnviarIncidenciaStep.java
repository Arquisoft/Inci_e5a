package asw.cucumber.steps;

import org.springframework.beans.factory.annotation.Autowired;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import asw.inciManager.inciManager_e5a.services.IncidenceService;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class EnviarIncidenciaStep {
	
	@Autowired IncidenceService incidenceService;
	@Autowired AgentsService agentsService;

	
	private String agenteLoggeado;
	private String nombreIncidencia;
	private String descripcionIncidencia;
	private String etiquitasIncidencia;


	

	
	@Dado("^La incidencia con agente loggeado \"([^\"]*)\"$")
	public void la_incidencia_con_agente_loggeado(String agenteLoggeado) throws Throwable {
		this.agenteLoggeado = agenteLoggeado;
		System.out.println("El agente que envia la incidencia es: " + agenteLoggeado);
	}
	
	@Y("^Nombre de la incidencia \"([^\"]*)\"$")
	public void nombre_de_la_incidencia(String nombreIncidencia) throws Throwable {
		this.nombreIncidencia = nombreIncidencia;
		System.out.println("El nombre de la incidencia es: " + nombreIncidencia);
	}

	@Y("^La descripcion de la incidencia \"([^\"]*)\"$")
	public void descripcion_de_la_incidencia(String descripcionIncidencia) throws Throwable {
		this.descripcionIncidencia = descripcionIncidencia;
		System.out.println("La descripcion de la incidencia es: " + descripcionIncidencia);
	}
	
	@Y("^Etiquetas de la incidencia \"([^\"]*)\"$")
	public void etiquetas_de_la_incidencia(String etiquitasIncidencia) throws Throwable {
		this.etiquitasIncidencia = etiquitasIncidencia;
		System.out.println("El nombre de la incidencia es: " + etiquitasIncidencia);
	}
	
}
