package dgwee.eSaint;

import java.io.*;
import java.sql.SQLException;

/**
 * @author Andrew Zurn
 * @version 0.1
 * 
 *          This class will be used as the bean class for a Administrator in the
 *          eSaintAuctionSystem.
 */
public class Administrator implements Serializable {

    private static final long serialVersionUID = 1L;
    /* administrator bean form fields */
    private int userId;
    private String username;
    private String password;

    /* other admin related fields */
    private boolean isLoggedIn = false;

    public Administrator() {

    }

    public boolean login() {
	boolean isAdmin = false;
	
	try {
	    isAdmin = ESaintDaoHelper.loginAdmin(username, password);
	}
	catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	catch (SQLException e) {
	    e.printStackTrace();
	}

	if ( isAdmin ) { // login is good, login
	    this.isLoggedIn = true;
	    return true;
	}
	else { // return false
	    return false;
	}
    }

    public void logout() {
	if (isLoggedIn == false) {
	    throw new IllegalStateException("The user is not logged in!");
	}
	else {
	    isLoggedIn = false;
	}
    }

    public int getUserId() {
	return userId;
    }

    public void setUserId(int userId) {
	this.userId = userId;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public boolean isLoggedIn() {
	return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
	this.isLoggedIn = isLoggedIn;
    }

}
