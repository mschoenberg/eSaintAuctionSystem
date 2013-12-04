package awzurn.eSaint;

import java.io.*;

/**
 * @author Andrew Zurn
 * @version 0.1
 * 
 *          This class will be used as the bean class for a User in the eSaintAuctionSystem.
 */
public class User implements Serializable {

    /* user bean form fields */
    private int userId;
    private String username;
    private String password;
    private String email;
    private String phoneNum;
    private String firstName;
    private String lastName;
    private String cardNum;
    private String cardType;
    private String cardExpMonth;
    private String cardExpYear;
    private int creatorId;

    /* other user related fields */
    private boolean isLoggedIn = false;

    public User() {

    }

    public boolean login() {
	ESaintDaoHelper dao = new ESaintDaoHelper();

	if (dao.loginUser(username, password)) { // login is good, login
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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPhoneNum() {
	return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getCardNum() {
	return cardNum;
    }

    public void setCardNum(String cardNum) {
	this.cardNum = cardNum;
    }

    public String getCardType() {
	return cardType;
    }

    public void setCardType(String cardType) {
	this.cardType = cardType;
    }

    public String getCardExpMonth() {
	return cardExpMonth;
    }

    public void setCardExpMonth(String cardExpMonth) {
	this.cardExpMonth = cardExpMonth;
    }

    public String getCardExpYear() {
	return cardExpYear;
    }

    public void setCardExpYear(String cardExpYear) {
	this.cardExpYear = cardExpYear;
    }

    public int getCreatorId() {
	return creatorId;
    }

    public void setCreatorId(int creatorId) {
	this.creatorId = creatorId;
    }

    public boolean isLoggedIn() {
	return isLoggedIn;
    }

    public void setLoggedIn(boolean isLoggedIn) {
	this.isLoggedIn = isLoggedIn;
    }

}
