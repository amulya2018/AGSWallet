package Exceptions;

@SuppressWarnings("serial")
public class InsufficientFundException extends Exception{

	String st = "looks like you dont have sufficient funds";

	public InsufficientFundException(String s) {
		super(s);
		// TODO Auto-generated constructor stub
	}
}
