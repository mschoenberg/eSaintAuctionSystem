import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * This class will be used as the main method of querying/updating the
 * OneHitWonders database.  It will contain the functionality within
 * seperate methods to be used in various calling classes to run queries/updates.
 * 
 * @author Andrew Zurn
 * @version 0.1
 *
 */
public class ESaintDaoHelper {

    private static final String databaseUrl = "jdbc:mysql://devsrv.cs.csbsju.edu:3306/OneHitWonders";
    private static final String username = "AZurn";
    private static final String password = "AZurn";
    
    /**
     * Query the ADMINISTRATOR table for the passed username and password
     * @param username
     * @param password
     * @return true if found, false otherwise.
     */
    public boolean loginAdmin(String username, String password){
	try{
	    Connection myConnection = createConnection();
	    
	    if(true){ //if result set contains the admin, return true
		//TODO: FINISH THIS -- SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = username AND PASSWORD = password
		myConnection.close();
		return true;
	    }
	    else{ //not found, return false
		myConnection.close();
		return false;
	    }
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return false;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return false;
	}
    }
    
    /**
     * Query the USERS table for the passed username and password
     * @param username
     * @param password
     * @return true if found, false otherwise.
     */
    public boolean loginUser(String username, String password){
	try{
	    Connection myConnection = createConnection();
	    
	    if(true){ //if result set contains the user, return true
		//TODO: FINISH THIS -- SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = username AND PASSWORD = password
		myConnection.close();
		return true;
	    }
	    else{ //not found, return false
		myConnection.close();
		return false;
	    }
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return false;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return false;
	}
    }
    
    /**
     * Will return all the users within the USERS table.
     * @return result set with all the users
     */
    public ResultSet getAllUsers(){
	try{
	    Connection myConnection = createConnection();
	    //TODO: FINISH THIS -- SELECT USER_ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD FROM USERS
	    myConnection.close();
	    return null;
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return null;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return null;
	}
    }
    
    /**
     * Will insert a new user into the USERS table.
     * @param username
     * @param password
     * @param email
     * @param phoneNum
     * @param firstName
     * @param lastName
     * @param cardNum
     * @param cardType
     * @param cardExpMon
     * @param cardExpYear
     * @param creatorId
     * @return true if entered with no errors, otherwise false
     */
    public boolean insertUser(String username, String password, String email, 
	    String phoneNum, String firstName, String lastName, String cardNum,
	    String cardType, String cardExpMon, String cardExpYear, int creatorId){
	try{
	    Connection myConnection = createConnection();
	    //TODO: FINISH THIS -- INSERT INTO USERS VALUES(DEFAULT, username, password, email, phoneNum, firstName, lastName,
	    //cardNum, cardType, cardExpMon, cardExpYear, creatorId
	    myConnection.close();
	    return true;
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return false;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return false;
	}
    }
    
    /**
     * Will return a result set containing all data in the COMMISSION_REPORT view.
     * @return result set of data in COMMISSION_REPORT
     */
    public ResultSet getCommissionReport(){
	try{
	    Connection myConnection = createConnection();
	    //TODO: FINISH THIS -- FROM COMISSION_REPORT
	    myConnection.close();
	    return null;
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return null;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return null;
	}
    }
    
    /**
     * Will return a result set containing all data in the SALES_REPORT view.
     * @return result set of data in SALES_REPORT
     */
    public ResultSet getSalesReport(){
	try{
	    Connection myConnection = createConnection();
	    //TODO: FINISH THIS -- SELECT * FROM SALES_REPORT
	    myConnection.close();
	    return null;
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return null;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return null;
	}
    }
    
    public boolean insertItem(String itemName, String category, Timestamp auctionStart,
	    Timestamp auctionEnd, String description, double startPrice, int creatorId){
	try{
	    Connection myConnection = createConnection();
	    //TODO: FINISH THIS -- INSERT INTO ITEM VALUES(itemName, category, auctionStart, auctionEnd
	    //description, startPrice, creatorId)
	    myConnection.close();
	    return true;
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return false;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return false;
	}
    }
    
    private Connection createConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	return (DriverManager.getConnection(databaseUrl, username, password));
    }
    
    
}
