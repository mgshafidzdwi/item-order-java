package id.test.api.exception;

public class ErrorException extends RuntimeException {
	private String error;
	private String rc;

	public ErrorException(String rc) {
		this(rc, null, null);
	}

	public ErrorException(String error, String message) {
		this(null, error, message);
	}

	public ErrorException(String rc, String error, String message) {
		super(message);
		this.error = error;
		this.rc = rc;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	public String getRc() {
		return rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}
}
