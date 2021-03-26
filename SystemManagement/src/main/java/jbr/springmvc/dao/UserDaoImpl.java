package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import jbr.springmvc.model.Deposit;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Myaccount;
import jbr.springmvc.model.Sample;
import jbr.springmvc.model.Transfer;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Withdraw;

public class UserDaoImpl  implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;
  int value;
  public int register(User user) {
	  int v=value+1;
	  int amt=0;
	  user.setId(v);
	  user.setAmount(amt);
     String sql = "insert into users values(?,?,?,?,?,?,?,?,?)";
    // System.out.println("sql"+user.getId());
    
    return jdbcTemplate.update(sql, new Object[] { user.getId(),user.getUsername(), user.getPassword(), user.getFirstname(),
        user.getLastname(), user.getPhone(), user.getEmail(), user.getAddress(),user.getAmount() });
  }

  public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
        + "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());

    return users.size() > 0 ? users.get(0) : null;
  }
  
  public int getcount()
  {
	  
	  String sql = "select count(*) from users";
	  value=jdbcTemplate.queryForObject(sql,Integer.class);
	 System.out.println("countf"+value);
	  return value;
  }
  
  public int deposit(Deposit deposit)
  {
	  deposit.setUser(Sample.user);
	  
	  String sql = "select amount from users where username='" + deposit.getUser() + "' ";
	  int amt=jdbcTemplate.queryForObject(sql,Integer.class);
	  int val=amt+deposit.getAmount();
	  String s = "update users set amount=? where username='" + deposit.getUser() + "' ";
	  return jdbcTemplate.update(s,val);
	 
  }
  public int withdraw(Withdraw withdraw)
  {
	  withdraw.setUser(Sample.user);
	  int useramt=withdraw.getAmount();
	  String sql = "select amount from users where username='" + withdraw.getUser() + "' ";
	  int amt=jdbcTemplate.queryForObject(sql,Integer.class);
	  if(useramt>amt)
	  {
		  return 0;
	  }
	  else
	  {
		  int val=amt-useramt;
		  String s = "update users set amount=? where username='" + withdraw.getUser() + "' ";
		  return jdbcTemplate.update(s,val);
	  }
	 
  }
  
  public int transfer(Transfer transfer)
  {
	  transfer.setUser(Sample.user);
	  int useramt=transfer.getAmount();
	  String sql1 = "select amount from users where username='" + transfer.getUser() + "' ";
	  int amt1=jdbcTemplate.queryForObject(sql1,Integer.class);
	  if(useramt>amt1)
	  {
		  System.out.println("Amount less");
		  return 0;
	  }
	  else 
	  {
		  String str = "select exists(select amount from users where id='" + transfer.getToid() + "') ";
		  
		  int amt3=jdbcTemplate.queryForObject(str,Integer.class);
		  System.out.println("idquery"+amt3);
		  if(amt3==0)
		  {
			  return 0;
		  }
		  else if(transfer.getToid()==Sample.aid)
		  {
			  return 0;
		  }
		  else
		  {
			  String sql2 = "select amount from users where id='" + transfer.getToid() + "' ";
			  int amt2=jdbcTemplate.queryForObject(sql2,Integer.class);
			  
			  int dec=amt1-useramt;
			  int inc=amt2+useramt;
			  
			  String sql3 = "update users set amount=? where username='" + transfer.getUser() + "' ";
			  int res1=jdbcTemplate.update(sql3,dec);
			  
			  String sql4 = "update users set amount=? where id='" + transfer.getToid() + "' ";
			  int res2= jdbcTemplate.update(sql4,inc);
			  return res2;
		  }
	  }
	  
  }
  
  public Myaccount viewuser(Myaccount myaccount) {
	    int userid=Sample.aid;
	    String sql = "select * from users where id='" + userid + "' ";
	        
	    List<Myaccount> users = jdbcTemplate.query(sql, new MyaccountMapper());

	    return users.size() > 0 ? users.get(0) : null;
	  }
  
  
  

}

class UserMapper implements RowMapper<User> {

  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();

    user.setId(rs.getInt("id"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getString("phone"));
    user.setAmount(rs.getInt("amount"));
    return user;
  }
}
  class MyaccountMapper implements RowMapper<Myaccount> {

	  public Myaccount mapRow(ResultSet rs, int arg1) throws SQLException {
	    Myaccount myaccount=new Myaccount();

	    myaccount.setIdnum(rs.getInt("id"));
	    myaccount.setUsername(rs.getString("username"));
	    myaccount.setPassword(rs.getString("password"));
	    myaccount.setFirstname(rs.getString("firstname"));
	    myaccount.setLastname(rs.getString("lastname"));
	    myaccount.setEmail(rs.getString("email"));
	    myaccount.setAddress(rs.getString("address"));
	    myaccount.setPhone(rs.getString("phone"));
	    myaccount.setAmount(rs.getInt("amount"));
	    return myaccount;
	  } 
  
}