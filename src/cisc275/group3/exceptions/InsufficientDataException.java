package cisc275.group3.exceptions;

/**
 * Custom exception to be thrown when a scene is called with 
 * fewer parameters than are required.
 * @author Scott
 */
public class InsufficientDataException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String errorMsg = "Insufficient parameter count to create object";
	
	public InsufficientDataException() {
		super(errorMsg);
	}
}
