
import java.util.List;

import AccntBean.Account;
import AccntInterface.AccountInterface;

public class MyWallet {

	private static org.springframework.context.ApplicationContext context;
	
	private static AccountInterface accountInter;
	
	private static java.util.Scanner in=new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		
	context=new org.springframework.context.support.ClassPathXmlApplicationContext("applicationContext.xml");
	
	accountInter=(AccountInterface) context.getBean("accountInter");
		while(true){
			System.out.println("1. Create Account\n");
			System.out.println("2. Deposit Amount\n");
			System.out.println("3. Withdraw Amount\n");
			System.out.println("4. All Transactions");
			System.out.println("0. Exit");
			System.out.println("Choice? ");
			int choice=in.nextInt();
			switch(choice){
			case 1: CreateAccount(); break;
			case 2: DepositAmount(); break;
			case 3: WithdrawAmount(); break;
			case 4: Transaction(); break;
			case 0: System.exit(0);
			default: System.out.println("Invalid Choice\n");
			}
			
		}
	}
	private static void Transaction() {
		System.out.println("Enter the accountId");
		in.nextLine();
		String id=in.nextLine();
		
		List<Transactions> transaction=accountInter.Transactions(id);
		if(transaction.isEmpty()){
			System.out.println("No Transactions made");
		}
		else{
			System.out.println(transaction);
		}
		}
	
	private static void DepositAmount() {
		System.out.println("Enter the accountId");
		in.nextLine();
		String id=in.nextLine();
		System.out.println("Enter the amout to be deposited");
		double amount=in.nextDouble();
		double balance=accountInter.Deposit(amount, id);
		System.out.println(balance+" is the current balance.");
		
	}
	private static void WithdrawAmount() {
		System.out.println("Enter the accountId");
		in.nextLine();
		String id=in.nextLine();
		System.out.println("Enter the amout to be withdrawn");
		double amount=in.nextDouble();
		double balance=accountInter.Withdraw(amount, id);
		System.out.println(balance+" is the current balance.");
	}
	private static void CreateAccount() {
		System.out.println("Enter the name:");
		in.nextLine();
		String userName=in.nextLine();
		System.out.println("Enter the balance");
		double balance=in.nextDouble();
		
		int result=accountInter.CreateAccount(userName, balance);
		if(result==1)
			System.out.println("Successfully created");
		else
			System.out.println("Not Successful");
		
	}
}
