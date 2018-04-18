package asw.inciManager.inciManager_e5a.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.request.PeticionChangeEmailREST;
import asw.inciManager.inciManager_e5a.request.PeticionChangePasswordREST;
import asw.inciManager.inciManager_e5a.request.PeticionInfoREST;
import asw.inciManager.inciManager_e5a.responses.RespuestaChangeInfoREST;
import asw.inciManager.inciManager_e5a.responses.RespuestaInfoREST;
import asw.inciManager.inciManager_e5a.responses.errors.ErrorResponse;
import asw.inciManager.inciManager_e5a.services.AgentsService;
import asw.inciManager.inciManager_e5a.services.SecurityService;
import asw.inciManager.inciManager_e5a.util.Assert;

@Controller
public class AgentController {
	
	@Autowired
	AgentsService agentsService;
	

	@Autowired
	private SecurityService securityService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String inicalicerLogin(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String getLogin(HttpSession session, @RequestParam String username, @RequestParam String password, @RequestParam String type,
			Model model) {

		Assert.isEmailEmpty(username);
		Assert.isEmailValid(username);
		Assert.isPasswordEmpty(password);
		Assert.isKindNull(type);

		Agent agent = agentsService.getAgent(username);
		
		if(agent == null)
			return "login";
		
		session.setAttribute("agent", agent);
		
		return "index";
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponseNotFound(ErrorResponse excep, Model model) {
		model.addAttribute("error", excep.getMessageStringFormat());

		return "error";
	}
	

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
	public ResponseEntity<RespuestaInfoREST> getPOSTpetition(@RequestBody(required = true) PeticionInfoREST peticion) {

		Assert.isEmailEmpty(peticion.getLogin());
		Assert.isEmailValid(peticion.getLogin());
		Assert.isPasswordEmpty(peticion.getPassword());

		Agent agent = agentsService.getAgent(peticion.getLogin());

	//	Assert.isAgentNull(agent);

	//  Assert.isPasswordCorrect(peticion.getPassword(), agent);

		/*
		 * Añadimos la información al modelo, para que se muestre en la pagina
		 * html: datosAgent
		 */

		return new ResponseEntity<RespuestaInfoREST>(new RespuestaInfoREST(agent), HttpStatus.OK);
	}

	@ExceptionHandler(ErrorResponse.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleErrorResponses(ErrorResponse error) {
		return error.getMessageJSONFormat();
	}
	
	
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
	public ResponseEntity<RespuestaChangeInfoREST> changePassword(@RequestBody(required=true) PeticionChangePasswordREST datos) {
		String email = datos.getEmail();
		String password = datos.getPassword();
		String newPassword = datos.getNewPassword();
		
		Assert.isEmailEmpty(email);
		Assert.isEmailValid(email);
		
		Assert.isPasswordEmpty(password);
		Assert.isPasswordEmpty(newPassword);
		
		Assert.isSamePassword(password, newPassword);	

		Agent p = agentsService.getAgent(email);
//		Assert.isAgentNull(p);
//		Assert.isPasswordCorrect(password, p);

		agentsService.updatePassword(p, password, newPassword);

		RespuestaChangeInfoREST res = new RespuestaChangeInfoREST(email, "contraseña actualizada correctamente");
		return new ResponseEntity<RespuestaChangeInfoREST>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/changeEmail", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
	public ResponseEntity<RespuestaChangeInfoREST> changeEmail(@RequestBody(required = true) PeticionChangeEmailREST datos) {
		String email = datos.getEmail();
		String password = datos.getPassword();
		String nuevoEmail = datos.getNewEmail();
		
		Assert.isEmailEmpty(email);
		Assert.isEmailValid(email);
		
		Assert.isEmailEmpty(nuevoEmail);
		Assert.isEmailValid(nuevoEmail);
		
		Assert.isSameEmail(email, nuevoEmail);

		Assert.isPasswordEmpty(password);
		
		Agent p = agentsService.getAgent(email);
//		Assert.isAgentNull(p);
//		Assert.isPasswordCorrect(password, p);
		
		agentsService.updateEmail(p, nuevoEmail);

		RespuestaChangeInfoREST res = new RespuestaChangeInfoREST(nuevoEmail, "email actualizado correctamente");
		return new ResponseEntity<RespuestaChangeInfoREST>(res, HttpStatus.OK);
	}

//	@ExceptionHandler(ErrorResponse.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public String handleErrorResponses(ErrorResponse error) {
//		return error.getMessageJSONFormat();
//	}
	
	@RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
	public String changeInfo() {
		return "changeInfo";
	}

	@RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
	public String changePassword(HttpSession session, @RequestParam String password,
			@RequestParam String newPassword, Model model) {
		Assert.isPasswordEmpty(password);
		Assert.isPasswordEmpty(newPassword);
		Assert.isSamePassword(password, newPassword);

		// Agent que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
	//	Assert.isAgentNull(p);
	//	Assert.isPasswordCorrect(password, p);

		// Actualizo sus datos
		agentsService.updatePassword(p, password, newPassword);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "Contraseña actualizada correctamente");
		return "datosAgent";
	}
	
	@RequestMapping(value = "/confirmEmail", method = RequestMethod.POST)
	public String changeEmail(HttpSession session, @RequestParam String email, Model model) {
		Assert.isEmailEmpty(email);
		Assert.isEmailValid(email);

		// Agent que se ha logeado antes
		Agent p = (Agent) session.getAttribute("agent");
//		Assert.isAgentNull(p);
// ->	Assert.isSameEmail(email, p.getEmail());

		// Actualizo sus datos
		agentsService.updateEmail(p, email);

		// Mensaje a mostrar en HTML
		model.addAttribute("info", "Email actualizado correctamente");
		return "datosAgent";
	}
}
