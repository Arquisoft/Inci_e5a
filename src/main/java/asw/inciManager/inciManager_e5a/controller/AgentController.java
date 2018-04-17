package asw.inciManager.inciManager_e5a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import asw.agents.util.Assert;
import asw.agents.webService.request.PeticionChangeEmailREST;
import asw.agents.webService.request.PeticionChangePasswordREST;
import asw.agents.webService.request.PeticionInfoREST;
import asw.agents.webService.responses.RespuestaChangeInfoREST;
import asw.agents.webService.responses.RespuestaInfoREST;
import asw.agents.webService.responses.errors.ErrorResponse;
import asw.inciManager.inciManager_e5a.entities.Agent;
import asw.inciManager.inciManager_e5a.services.AgentsService;

public class AgentController {
	
	@Autowired
	AgentsService agentService; 
	
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Accept=application/json",
			"Accept=application/xml" }, produces = { "application/json", "text/xml" })
	public ResponseEntity<RespuestaInfoREST> getPOSTpetition(@RequestBody(required = true) PeticionInfoREST peticion) {

		Assert.isEmailEmpty(peticion.getLogin());
		Assert.isEmailValid(peticion.getLogin());
		Assert.isPasswordEmpty(peticion.getPassword());

		Agent agent = agentService.getAgent(peticion.getLogin());

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

		Agent p = agentService.getAgent(email);
//		Assert.isAgentNull(p);
//		Assert.isPasswordCorrect(password, p);

		agentService.updatePassword(p, password, newPassword);

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
		
		Agent p = agentService.getAgent(email);
//		Assert.isAgentNull(p);
//		Assert.isPasswordCorrect(password, p);
		
		agentService.updateEmail(p, nuevoEmail);

		RespuestaChangeInfoREST res = new RespuestaChangeInfoREST(nuevoEmail, "email actualizado correctamente");
		return new ResponseEntity<RespuestaChangeInfoREST>(res, HttpStatus.OK);
	}

//	@ExceptionHandler(ErrorResponse.class)
//	@ResponseStatus(value = HttpStatus.NOT_FOUND)
//	public String handleErrorResponses(ErrorResponse error) {
//		return error.getMessageJSONFormat();
//	}


}
