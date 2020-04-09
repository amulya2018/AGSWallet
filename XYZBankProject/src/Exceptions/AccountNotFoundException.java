package Exceptions;

	public class AccountNotFoundException extends Exception{
		
		String st = "The account that you are searching is not available";

		public AccountNotFoundException(String s) {
			super(s);
			// TODO Auto-generated constructor stub
		}
		

}
