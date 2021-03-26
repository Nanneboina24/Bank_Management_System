package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Deposit;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Myaccount;
import jbr.springmvc.model.Transfer;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Withdraw;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }
  public int getcount()
  {
	  return userDao.getcount();
  }
  public int deposit(Deposit deposit)
  {
	 return userDao.deposit(deposit);
  }
  public int withdraw(Withdraw withdraw)
  {
	 return userDao.withdraw(withdraw);
  }
  public int transfer(Transfer transfer)
  {
	 return userDao.transfer(transfer);
  }
  public Myaccount viewuser(Myaccount myaccount)
  {
	  return userDao.viewuser(myaccount);
  }

}
