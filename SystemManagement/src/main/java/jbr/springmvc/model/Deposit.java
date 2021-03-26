package jbr.springmvc.model;

public class Deposit
{
 private int amount;
 private int idnum;
 private String user;
 
 public int getIdnum()
 {
	    return idnum;
 }

public void setIdnum(int idnum)
{
	this.idnum = idnum;

}

public String getUser() {
    return user;
  }

  public void setUser(String user) {
    
    this.user = user;
  }

 public int getAmount()
 {
	    return amount;
 }

public void setAmount(int amount)
{
	this.amount = amount;

}
}
