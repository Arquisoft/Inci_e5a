package asw.inciManager.inciManager_e5a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.request.PeticionInfoREST;
import asw.inciManager.inciManager_e5a.responses.RespuestaInfoREST;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import asw.inciManager.inciManager_e5a.services.SecurityService;

@Controller
public class AgentController {

	@Autowired
	AgentsService agentsService;
	
	@Autowired
	SecurityService securityService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicalicerLogin(Model model) {
		return "index";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String login(Model model) {
		return "userlogin";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String loginPost(@RequestParam String email, @RequestParam String password, @RequestParam String type) {
		Agent agent = agentsService.getAgent(email);
		if (agent == null || !agent.getKind().equals(type))
			return "redirect:/userlogin?error";
		try {
			securityService.autoLogin(email, password);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/userlogin?error";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String perfilUsuario(Model model) {
		return "profile";
	}
	
	@PostMapping(value="/profile/cambiarContraseña")
	public String cambiarContraseña(Model model, @ModelAttribute Agent agente, @RequestParam String email, @RequestParam String password)
	{
		Agent original=agentsService.getAgent(email);
		original.setPassword(password);
		agentsService.cambiarUsuario(original);
		return "redirect:/";
				
	}
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
	public ResponseEntity<RespuestaInfoREST> getPOSTpetition(@RequestBody(required = true) PeticionInfoREST peticion) {
		Agent agent = agentsService.getAgent(peticion.getLogin());
		/*
		 * Añadimos la información al modelo, para que se muestre en la pagina html:
		 * datosAgent
		 */

		return new ResponseEntity<RespuestaInfoREST>(new RespuestaInfoREST(agent), HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/cambiarContraseña", method = RequestMethod.POST)
//	public String changePassword(HttpSession session, @RequestParam String email, @RequestParam String password,
//			Model model) {
//		agentsService.updatePassword(email, password);
//		// Mensaje a mostrar en HTML
//		model.addAttribute("info", "Contraseña actualizada correctamente");
//		return "redirect:/";
//	}

//	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, headers = { "Accept=application/json",
//			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
//	public ResponseEntity<RespuestaChangeInfoREST> changePassword(
//			@RequestBody(required = true) PeticionChangePasswordREST datos) {
//		String email = datos.getEmail();
//		String password = datos.getPassword();
//		String newPassword = datos.getNewPassword();
//
//		Agent p = agentsService.getAgent(email);
//		// Assert.isAgentNull(p);
//		// Assert.isPasswordCorrect(password, p);
//
//		agentsService.updatePassword(email, password);
//
//		RespuestaChangeInfoREST res = new RespuestaChangeInfoREST(email, "contraseña actualizada correctamente");
//		return new ResponseEntity<RespuestaChangeInfoREST>(res, HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST, headers = { "Accept=application/json",
//			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
//	public ResponseEntity<RespuestaChangeInfoREST> changeEmail(
//			@RequestBody(required = true) PeticionChangeEmailREST datos) {
//		String email = datos.getEmail();
//		String password = datos.getPassword();
//		String nuevoEmail = datos.getNewEmail();
//
//		Agent p = agentsService.getAgent(email);
//		agentsService.updateEmail(p, nuevoEmail);
//
//		RespuestaChangeInfoREST res = new RespuestaChangeInfoREST(nuevoEmail, "email actualizado correctamente");
//		return new ResponseEntity<RespuestaChangeInfoREST>(res, HttpStatus.OK);
//	}

	// @ExceptionHandler(ErrorResponse.class)
	// @ResponseStatus(value = HttpStatus.NOT_FOUND)
	// public String handleErrorResponses(ErrorResponse error) {
	// return error.getMessageJSONFormat();
	// }

	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changeInfo() {
		return "changeInfo";
	}

	

//	@RequestMapping(value = "/confirmEmail", method = RequestMethod.POST)
//	public String changeEmail(HttpSession session, @RequestParam String email, Model model) {
//		// Agent que se ha logeado antes
//		Agent p = (Agent) session.getAttribute("agent");
//		// Assert.isAgentNull(p);
//		// -> Assert.isSameEmail(email, p.getEmail());
//
//		// Actualizo sus datos
//		agentsService.updateEmail(p, email);
//
//		// Mensaje a mostrar en HTML
//		model.addAttribute("info", "Email actualizado correctamente");
//		return "datosAgent";
//	}
	
}
