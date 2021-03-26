package jbr.springmvc.model;

public class Transfer {

private int amount;
 private int idnum;
 private int toid;
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
 public int getToid()
 {
	    return toid;
 }

public void setToid(int toid)
{
	this.toid = toid;

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

