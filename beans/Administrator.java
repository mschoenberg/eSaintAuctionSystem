/**
 * @author Andrew Zurn
 * @version 0.1
 * 
 * This class will be used as the bean class for a Administrator in the eSaintAuctionSystem.
 */
public class Administrator {
    
    /* administrator bean form fields */
    private int userId;
    private String username;
    private String password;
    
    /* other admin  related fields */
    private boolean isLoggedIn = false;
    
    public Administrator(){
	
    }
    
    public boolean login(){
	ESaintDaoHelper dao = new ESaintDaoHelper();
	
	if( dao.loginAdmin(username, password) ){  //login is good, login
	    this.isLoggedIn = true;
	    return true;
	}
	else{  //return false
	    return false;
	}
    }
	
	public void logout(){
	  if( isLoggedIn == false ){
	    throw new IllegalStateException("The user is not logged in!");
	  }
	  else{
	    isLoggedIn = false;
	  }
	}

    private int getUserId() {
        return userId;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

    private String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private boolean isLoggedIn() {
        return isLoggedIn;
    }

    private void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

}
