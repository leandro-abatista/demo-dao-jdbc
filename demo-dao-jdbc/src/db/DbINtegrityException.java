package db;

public class DbINtegrityException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbINtegrityException(String msg) {
		super(msg);
	}
}
