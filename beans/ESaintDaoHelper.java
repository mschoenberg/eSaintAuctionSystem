import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

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
	    
	    String queryString = "SELECT USERNAME ";
	    queryString +=	 "FROM ADMINISTRATOR ";
	    queryString +=	 "WHERE USERNAME = ? AND PASSWORD = ?";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if( resultSet.getString(1).equals(username) ){ //if result set contains the admin, return true
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{ //not found, return false
		resultSet.close();
		preparedStatement.close();
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
	    
	    String queryString = "SELECT USERNAME ";
	    queryString +=	 "FROM USERS ";
	    queryString +=	 "WHERE USERNAME = ? AND PASSWORD = ?";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    if( resultSet.getString(1).equals(username) ){ //if result set contains the user, return true
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{ //not found, return false
		resultSet.close();
		preparedStatement.close();
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
	    Statement statement = myConnection.createStatement();
	    
	    String queryString = "SELECT USER_ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD FROM USERS";
	    
	    return statement.executeQuery(queryString);
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
	    
	    String queryString = "INSERT INTO USERS VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);
	    preparedStatement.setString(3, email);
	    preparedStatement.setString(4, phoneNum);
	    preparedStatement.setString(5, firstName);
	    preparedStatement.setString(6, lastName);
	    preparedStatement.setString(7, cardNum);
	    preparedStatement.setString(8, cardType);
	    preparedStatement.setString(9, cardExpMon);
	    preparedStatement.setString(10, cardExpYear);
	    preparedStatement.setInt(11, creatorId);

	    int rowsModified = preparedStatement.executeUpdate();
	    
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * Will update the tuple in USERS of the passed userId with the given parameters.
     * @param userId
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
     * @return true if modified, otherwise false
     */
    public boolean updateUser(int userId, String username, String password, String email, 
	    String phoneNum, String firstName, String lastName, String cardNum,
	    String cardType, String cardExpMon, String cardExpYear, int creatorId){
	try{
	    Connection myConnection = createConnection();
	    
	    String queryString = "UPDATE USER SET ";
	    queryString +=	 "USERNAME = ?, PASSWORD = ?, EMAIL = ?, PHONE_NUMBER = ?, ";
	    queryString +=	 "FIRST_NAME = ?, LAST_NAME = ?, CARD_NUMBER = ?, CARD_TYPE = ?, ";
	    queryString +=	 "CARD_EXP_MONTH = ?, CARD_EXP_YEAR = ?, CREATOR_ID = ?";
	    queryString +=	 "WHERE USER_ID = ?";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);
	    preparedStatement.setString(3, email);
	    preparedStatement.setString(4, phoneNum);
	    preparedStatement.setString(5, firstName);
	    preparedStatement.setString(6, lastName);
	    preparedStatement.setString(7, cardNum);
	    preparedStatement.setString(8, cardType);
	    preparedStatement.setString(9, cardExpMon);
	    preparedStatement.setString(10, cardExpYear);
	    preparedStatement.setInt(11, creatorId);
	    preparedStatement.setInt(12, userId);

	    int rowsModified = preparedStatement.executeUpdate();
	    
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * Will return a result set containing all data in the COMMISSION_REPORT view.
     * @return result set of data in COMMISSION_REPORT
     */
    public ResultSet getCommissionReport(){
	try{
	    Connection myConnection = createConnection();
	    Statement statement = myConnection.createStatement();
	    
	    String queryString = "SELECT * FROM COMMISSION_REPORT";
	    
	    return statement.executeQuery(queryString);
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
	    Statement statement = myConnection.createStatement();
	    
	    String queryString = "SELECT * FROM SALES_REPORT";
	    
	    return statement.executeQuery(queryString);
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
     * Will insert a new item tuple into the ITEM table.
     * @param itemName
     * @param category
     * @param auctionStart
     * @param auctionEnd
     * @param description
     * @param startPrice
     * @param creatorId
     * @return true if entered, otherwise false
     */
    public boolean insertItem(String itemName, String category, Timestamp auctionStart,
	    Timestamp auctionEnd, String description, double startPrice, int creatorId){
	try{
	    Connection myConnection = createConnection();
	    
	    String queryString = "INSERT INTO ITEM VALUES(?,?,?,?,?,?,?)";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, itemName);
	    preparedStatement.setString(2, category);
	    preparedStatement.setTimestamp(3, auctionStart);
	    preparedStatement.setTimestamp(4, auctionEnd);
	    preparedStatement.setString(5, description);
	    preparedStatement.setDouble(6, startPrice);
	    preparedStatement.setInt(7, creatorId);
	    //TODO: FIGURE OUT HOW TO INSERT A PHOTO/BLOB through the JDBC
	    
	    int rowsModified = preparedStatement.executeUpdate();
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * Will update the tuple in ITEM of the passed itemId with the given parameters.
     * @param itemId
     * @param itemName
     * @param category
     * @param auctionStart
     * @param auctionEnd
     * @param description
     * @param startPrice
     * @param creatorId
     * @return true if entered, otherwise false
     */
    public boolean updateItem(int itemId, String itemName, String category, Timestamp auctionStart,
	    Timestamp auctionEnd, String description, double startPrice, int creatorId){
	try{
	    Connection myConnection = createConnection();
	    
	    String queryString = "UPDATE ITEM SET ";
	    queryString +=	 "ITEM_NAME = ?, CATEGORY = ?, AUCTION_START = ?, AUCTION_END = ?, ";
	    queryString +=	 "DESCRIPTION = ?, START_PRICE = ?, CREATOR_ID = ? ";
	    queryString +=	 "WHERE ITEM_ID = ?";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, itemName);
	    preparedStatement.setString(2, category);
	    preparedStatement.setTimestamp(3, auctionStart);
	    preparedStatement.setTimestamp(4, auctionEnd);
	    preparedStatement.setString(5, description);
	    preparedStatement.setDouble(6, startPrice);
	    preparedStatement.setInt(7, creatorId);
	    preparedStatement.setInt(8, itemId);
	    //TODO: FIGURE OUT HOW TO INSERT A PHOTO/BLOB through the JDBC
	    
	    int rowsModified = preparedStatement.executeUpdate();
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * Will call on the stored function insertAuctionBid to insert a bid tuple
     * into the AUCTIONS table.
     * @param itemId
     * @param userId
     * @param maximumBid
     * @return will return 0 if bid entered successfully, -1 if maxiumumBid is less than the 
     * current bid, -2 if the auction is not currently open, or -3 if another error occured
     */
    public int insertAuctionBid(int itemId, int userId, double maximumBid){
	try{
	    Connection myConnection = createConnection();
	    
	    CallableStatement callableStatement = myConnection.prepareCall("{? = call insertAuctionBid(?, ?, ?)}");
	    callableStatement.registerOutParameter(1, Types.INTEGER);
	    callableStatement.setInt(2, itemId);
	    callableStatement.setInt(3, userId);
	    callableStatement.setDouble(4, maximumBid);
	    
	    callableStatement.execute();
	    
	    return callableStatement.getInt(1);
	}
	catch(ClassNotFoundException ce){
	    ce.printStackTrace();
	    return -3;
	}
	catch(SQLException se){
	    se.printStackTrace();
	    return -3;
	}
    }
    
    /**
     * Will insert a feedback tuple into the BUYER_FEEDBACK table 
     * for the given itemId.
     * @param itemId
     * @param satisfaction
     * @param paymentPromptness
     * @param comments
     * @return true if entered, otherwise false
     */
    public boolean insertBuyerFeedback(int itemId, int satisfaction,
	    int paymentPromptness, String comments){
	try{
	    Connection myConnection = createConnection();
	    
	    String queryString = "INSERT INTO BUYER_FEEDBACK VALUES(?, ?, ?, ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);
	    preparedStatement.setInt(2, satisfaction);
	    preparedStatement.setInt(3, paymentPromptness);
	    preparedStatement.setString(4, comments);
	    
	    int rowsModified = preparedStatement.executeUpdate();
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * Will insert a feedback tuple into the SELLER_FEEDBACK table 
     * for the given itemId.
     * @param itemId
     * @param satisfaction
     * @param itemDelivery
     * @param itemQuality
     * @param comments
     * @return true if entered, false if otherwise
     */
    public boolean insertSellerFeedback(int itemId, int satisfaction, int itemDelivery,
	    int itemQuality, String comments){
	try{
	    Connection myConnection = createConnection();
	    
	    String queryString = "INSERT INTO SELLER_FEEDBACK VALUES(?, ?, ?, ?, ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);
	    preparedStatement.setInt(2, satisfaction);
	    preparedStatement.setInt(3, itemDelivery);
	    preparedStatement.setInt(4, itemQuality);
	    preparedStatement.setString(5, comments);
	    
	    int rowsModified = preparedStatement.executeUpdate();
	    if(rowsModified > 0){
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else{
		preparedStatement.close();
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
     * FIGURE THIS STUFF OUT!
     * @return Result Set of buyer feedback
     */
    public ResultSet getBuyerFeedback(int userId){
	try{
	    Connection myConnection = createConnection();
	    
	    //TODO: FILL OUT QUERY STRING
	    String queryString = "";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    
	    return preparedStatement.executeQuery();
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
     * FIGURE THIS STUFF OUT!
     * @return ResultSet of seller feedback tuples
     */
    public ResultSet getSellerFeedback(){
	try{
	    Connection myConnection = createConnection();
	    
	    //TODO: FILL OUT QUERY STRING
	    String queryString = "";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    
	    return preparedStatement.executeQuery();
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
    
    private Connection createConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	return (DriverManager.getConnection(databaseUrl, username, password));
    }
    
    
}
