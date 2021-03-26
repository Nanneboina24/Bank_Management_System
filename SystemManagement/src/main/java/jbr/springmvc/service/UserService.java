package jbr.springmvc.service;

import jbr.springmvc.model.Deposit;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.Myaccount;
import jbr.springmvc.model.Transfer;
import jbr.springmvc.model.User;
import jbr.springmvc.model.Withdraw;

public interface UserService {

  int register(User user);
  User validateUser(Login login);
  int getcount();
  int deposit(Deposit deposit);
  int withdraw(Withdraw withdraw);
  int transfer(Transfer transfer);
  Myaccount viewuser(Myaccount myaccount);
}
