package v4;

public class TextFileReaderException extends Exception {
	private static final long serialVersionUID = 1L;

	public TextFileReaderException(String fehlerMeldung, int zeile)
	{
		super(fehlerMeldung + " : " + zeile);
	}
	
}
