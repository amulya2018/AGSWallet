package AccntInterface;

import java.util.List;

import AccntBean.Transactions;
import Exceptions.AccountNotFoundException;
import Exceptions.InsufficientFundException;
import Exceptions.MinimumBalanceException;

public interface AccountInterface {
	public int CreateAccount(String name, double balance)throws MinimumBalanceException;
	public double Deposit(double amount,String id);
	public double Withdraw(double amount,String id)throws InsufficientFundException;
	public List<Transactions>trasaction(String userId)throws InsufficientFundException,AccountNotFoundException;
}
