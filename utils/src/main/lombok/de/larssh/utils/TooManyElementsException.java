package de.larssh.utils;

/**
 * Thrown to indicate that an object contains more than one element while either
 * no or exactly one element are expected.
 */
public class TooManyElementsException extends RuntimeException {
	private static final long serialVersionUID = 5988961948623749681L;

	/**
	 * Constructs a new {@link TooManyElementsException} with the default detail
	 * message.
	 */
	public TooManyElementsException() {
		super("Object contains more than one element. Expected either no or exactly one element.", null);
	}
}
