import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		return true;
	    }
	    else{ //not found, return false
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
		return true;
	    }
	    else{ //not found, return false
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
    
    private Connection createConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	return (DriverManager.getConnection(databaseUrl, username, password));
    }
    
    
}

