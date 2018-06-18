package asw.inciManager.inciManager_e5a.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.entities.Incidence;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import asw.inciManager.inciManager_e5a.services.IncidenceService;

@Controller
public class IncidenceController {

	@Autowired
	private IncidenceService incidenceService;

	@Autowired
	private AgentsService agentsService;

	@RequestMapping(value = "/sendIncidence", method = RequestMethod.GET)
	public String createIncidenceGet(Principal agente, Model model) {
		Agent agent = agentsService.getAgent(agente.getName());
		model.addAttribute(agent);
		return "sendIncidence";
	}
	
	@RequestMapping(value = "/incidenceSent", method = RequestMethod.GET)
	public String incidenceSent()
	{
		return "incidenceSent";
	}

	@RequestMapping(value = "/incidence/add", method = RequestMethod.POST)
	public String createIncidence(Principal agente, @RequestParam String name, @RequestParam String description,  @RequestParam String tags) 
	{
		Agent agent = agentsService.getAgent(agente.getName());
		Incidence incidence = new Incidence(name, description, agent, obtainTagsList(tags));
		incidenceService.addIncidence(incidence);
		return "redirect:/incidenceSent";
	}

	private List<String> obtainTagsList(String str) {
		List<String> etiquetas = new ArrayList<>();
		Arrays.asList(str.split(",")).forEach(x -> {
			x.replace(" ", "");
			etiquetas.add(x.toLowerCase());
		});
		return etiquetas;
	}
}
