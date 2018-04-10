package asw.agents.webService.responses.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Kind Incorrect")
public class KindNotFoundResponse extends ErrorResponse {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessageJSONFormat() {
		// TODO Auto-generated method stub
		return "{\"reason\": \"Kind Incorrect\"}";
	}

	@Override
	public String getMessageStringFormat() {
		// TODO Auto-generated method stub
		return "Kind Incorrect";
	}

}
