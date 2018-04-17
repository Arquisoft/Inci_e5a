package asw.inciManager.inciManager_e5a.responses.errors;

public abstract class ErrorResponse extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public abstract String getMessageJSONFormat();

	public abstract String getMessageStringFormat();

}
