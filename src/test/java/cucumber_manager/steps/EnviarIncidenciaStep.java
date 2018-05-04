package cucumber_manager.steps;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import asw.inciManager.inciManager_e5a.services.IncidenceService;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;

public class EnviarIncidenciaStep {

    private WebDriver driver = null;
    private String url = "http://localhost:8090/userlogin";

    private String nombreIncidencia;
    private String descripcionIncidencia;
    private String etiquitasIncidencia;

    @Dado("^La incidencia recogida por un agente loggeado$")
    public void la_incidencia_con_agente_loggeado() throws Throwable {

	driver = new HtmlUnitDriver();
	driver.get(url);
	driver.navigate().to(url);
	driver.findElement(By.id("login-email")).sendKeys("alvaro@uniovi.es");
	driver.findElement(By.id("login-pass")).sendKeys("Contra");
	driver.findElement(By.id("login-type")).sendKeys("Persona");
	driver.findElement(By.id("login-send")).click();
	System.out.println("El agente que envia la incidencia es: alvaro@uniovi.es");
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

    @Cuando("^introduzco los datos en el formulario$")
    public void introduzco_los_datos_en_el_formulario() {
	url = "http://localhost:8090/sendIncidence";
	driver.get(url);
	driver.navigate().to(url);
	driver.findElement(By.id("name")).sendKeys(nombreIncidencia);
	driver.findElement(By.id("description")).sendKeys(descripcionIncidencia);
	driver.findElement(By.id("tags")).sendKeys(etiquitasIncidencia);
	System.out.println("Introduciendo los datos en el formulario");
    }

    @Y("^presiono el boton de enviar incidencia")
    public void presiono_boton_enviar_incidencia() {
	driver.findElement(By.id("enviar")).click();
	System.out.println("Presionando boton de enviar incidencia");
    }

    @Entonces("^se envia la incidencia correctamente$")
    public void se_envia_la_incidencia() {
	System.out.println("Se envía la incidencia correctamente");
    }

}
