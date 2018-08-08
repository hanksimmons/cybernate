package exception;

public class UniqueEmailException extends Exception {

	private static final long serialVersionUID = -242134081554310119L;

	public UniqueEmailException(String message) {
        super(message);
    }
	
}
