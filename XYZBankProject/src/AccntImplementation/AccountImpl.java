package AccntImplementation;
import AccntInterface.AccountInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import AccntBean.Transactions;
import AccntBean.Account;

public class AccountImpl implements AccountInterface{
	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int CreateAccount(String userName, double balance) {
			
			String sql1="select max(userId) from accounts";
			List<String> list;
			list=jdbcTemplate.query(sql1,new ResultSetExtractor<List<String>>(){  
			 public List<String> extractData(ResultSet result) throws SQLException {
			 List<String> list=new ArrayList<String>();  
			    while(result.next()){  
			    	String maxAccountId=result.getString(1);
			    	maxAccountId=(maxAccountId != null)? maxAccountId.substring(2):"0";
			    	int accountId1=1+Integer.parseInt(maxAccountId);
			    	String id="AA"+String.format("%09d",accountId1 );
			    	list.add(id);  
			        }  
			        return list;  
			        }  
			    }); 
			String userId=list.get(0);
			String sql="insert into accounts values('"+userName+"','"+userId+"',"+balance+")";
			return jdbcTemplate.update(sql);
		}

	public double Withdraw(double amount,String id) {
			double balance=0;
			String sql="select	* from accounts where userId=?";
			Account res=(Account) jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper(Account.class));
			if(res.getAccount_Balance()>amount)
			{
			 balance=res.getAccount_Balance()-amount;
			}
			String l="update accounts="+balance+"where id is='"+res.getAccnt_Id()+"'";
			jdbcTemplate.update(l);
			String transtype="wd";
			String q="insert into transaction values('"+res.getAccnt_Id()+"',"+amount+",'"+transtype+"')";
			jdbcTemplate.update(q);
			return balance;	
		}

	public double Deposit(double amount,String id) {
			double current=0;
			String sql="select	* from accounts where userId=?";
			Account res=(Account) jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper(WalletAccount.class));
			 current=res.getAccount_Balance()+amount;
			String sql1="update accounts set balance="+current+"where userId='"+res.getAccnt_Id()+"'";
			jdbcTemplate.update(sql1);
			String transtype="dp";
			String sql2="insert into transaction values('"+res.getAccnt_Id()+"',"+amount+",'"+transtype+"')";
			jdbcTemplate.update(sql2);
			return current;
		}

	public List<Transactions> trasaction(String userId) {
		String sql="Select * from transaction where userId='"+userId+"'";
		List<Transactions> transactions=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Transactions.class));
		return transactions;
	}
		
}