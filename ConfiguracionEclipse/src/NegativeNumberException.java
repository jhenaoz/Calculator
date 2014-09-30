
public class NegativeNumberException extends Exception {

	String message;
	public NegativeNumberException(String message){
		this.message = message;
		System.err.print(message);
	}
	
	public String getMessage(){
		return this.message;
	}
}
