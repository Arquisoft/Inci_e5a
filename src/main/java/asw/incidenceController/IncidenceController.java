package asw.incidenceController;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.dbManagement.GetAgent;
import asw.dbManagement.model.Agent;
import asw.dbManagement.model.Incidence;
import asw.incidenceController.services.IncidenceService;
import asw.kafkamanager.SendIncidenceImpl;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;

	@Autowired
	private SendIncidenceImpl sendIncidence;

	@Autowired
	private GetAgent getAgentService;
	
	private SecureRandom random = new SecureRandom();

	@RequestMapping(value = "/sendIncidence", method = RequestMethod.GET)
	public String createIncidenceGet() {
		return "sendIncidence";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String createIncidence(@RequestParam String name, @RequestParam String description,  @RequestParam String tags, @RequestParam String username,
			@RequestParam String password) {
		//System.out.println("Usuario " + (String) sesion.getAttribute("username") + " Contraseña: " + sesion.getAttribute("password"));
		Agent agent = getAgentService.getAgent(username);
		if (agent == null || !agent.getPassword().equals(password))
			return "redirect:/sendIncidence?error";
		String identificador = nextId();
		Incidence incidence = new Incidence(identificador, name, description, agent, obtainTagsList(tags));
		incidenceService.saveIncidence(incidence);
		return "sendIncidence";
	}

	private List<String> obtainTagsList(String str) {
		List<String> etiquetas = new ArrayList<>();
		Arrays.asList(str.split(",")).forEach(x -> {
			x.replace(" ", "");
			etiquetas.add(x.toLowerCase());
		});
		return etiquetas;
	}

	private String nextId() {
		return new BigInteger(130, random).toString(32);
	}
}
