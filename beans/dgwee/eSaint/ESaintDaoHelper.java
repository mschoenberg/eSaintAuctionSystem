package dgwee.eSaint;

import java.io.*;
import java.sql.Blob;
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
 * This class will be used as the main method of querying/updating the OneHitWonders database.
 * It will contain the functionality within seperate methods to be used in various calling
 * classes to run queries/updates.
 * 
 * @author Andrew Zurn
 * @version 0.1
 * 
 */
public class ESaintDaoHelper implements Serializable {

    private static final String databaseUrl = "jdbc:mysql://devsrv.cs.csbsju.edu:3306/OneHitWonders";
    private static final String username = "AZurn";
    private static final String password = "AZurn";

    /**
     * Query the ADMINISTRATOR table for the passed username and password
     * 
     * @param username
     * @param password
     * @return true if found, false otherwise.
     * @throws ClassNotFoundException 
     * @throws SQLException 
     */
    public boolean loginAdmin(String username, String password) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT USERNAME ";
	    queryString += "FROM ADMINISTRATOR ";
	    queryString += "WHERE USERNAME = ? AND PASSWORD = ?";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);

	    ResultSet resultSet = preparedStatement.executeQuery();
	    if ( resultSet.next() ) { // if result set contains the admin,
							   // return true
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else { // not found, return false
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Query the USERS table for the passed username and password
     * 
     * @param username
     * @param password
     * @return true if found, false otherwise.
     */
    public boolean loginUser(String username, String password) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT USERNAME ";
	    queryString += "FROM USERS ";
	    queryString += "WHERE USERNAME = ? AND PASSWORD = ?";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, username);
	    preparedStatement.setString(2, password);

	    ResultSet resultSet = preparedStatement.executeQuery();
	    if ( resultSet.next() ) { // if result set contains the user,
							   // return true
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else { // not found, return false
		resultSet.close();
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return a list of all items in the ITEMS table.
     * 
     * @return A Result Set of all items.
     */
    public ResultSet getAllItems() throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();
	    Statement statement = myConnection.createStatement();

	    String queryString = "SELECT * FROM ITEM";

	    return statement.executeQuery(queryString);
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Get a single item from the ITEMS table specified by itemId.
     * 
     * @param itemId
     * @return A Result Set containing a single item tuple
     */
    public ResultSet getItem(int itemId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM ITEM WHERE ITEM_ID = ?";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return all the tuples in AUCTIONS for an item specified by itemId.
     * 
     * @param itemId
     * @return A Result Set of the bidders in AUCTIONS for a given itemId
     */
    public ResultSet getItemBidders(int itemId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    // TODO: NEED TO INCLUDE THE BIDDER RATING IN THIS RESULT SET SOMEHOW
	    String queryString = "SELECT * FROM AUCTIONS WHERE ITEM_ID = ?";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * TODO: FIGURE OUT THE QUERY AND PARAMETERS FOR THIS Will return a set of tuples in ITEM
     * that match the given search parameters
     * 
     * @return A Result Set of matched tuples in ITEM
     */
    public ResultSet searchItems(int itemId, String keyword, String category,
	    double bidFloor, double bidCeiling, Timestamp auctionStart,
	    Timestamp auctionEnd) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT *";
	    queryString += 	 "FROM ITEM";
	    queryString +=	 "WHERE ITEM_ID = ? OR (ITEM_NAME LIKE '%?%' ";
	    queryString +=	 "OR CATEGORY = ? OR (CURRENT_BID BETWEEN ? AND ?) OR ";
	    queryString +=	 "(AUCTION_START <= ? AND AUCTION_END >= ?))";
	    
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);
	    preparedStatement.setString(2, keyword);
	    preparedStatement.setString(3, category);
	    preparedStatement.setDouble(4, bidFloor);
	    preparedStatement.setDouble(5, bidCeiling);
	    preparedStatement.setTimestamp(6, auctionStart);
	    preparedStatement.setTimestamp(7, auctionEnd);
	    
	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return a list of tuples in ITEM for where a userId has left a bid on that item
     * 
     * @param userId
     *            that is looking for the items bid on
     * @return A Result Set of items the userId has bid on
     */
    public ResultSet getItemsBidOn(int userId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM ITEM WHERE ITEM_ID IN ";
	    queryString += "(SELECT ITEM_ID FROM AUCTIONS WHERE USER_ID = ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return a list of tuples in ITEM for the given userId that was the creator of the
     * item, and where the status of the item is sold. In effect, it returns a list of all sold
     * items for a userId.
     * 
     * @param userId
     * @return A Result Set of the sold items.
     */
    public ResultSet getItemsSold(int userId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM ITEM WHERE CREATOR_ID = ? AND STATUS = 'SOLD'";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return the tuples in ITEM for a given userId that's value is found in WINNNER_ID
     * and where the item STATUS is 'SOLD'. In effect, this will return all the tiems that a
     * user has won in the auction system.
     * 
     * @param userId
     * @return Will return a Result Set containing all the items a user has won.
     */
    public ResultSet getItemsWon(int userId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM ITEM WHERE WINNER_ID = ? AND STATUS = 'SOLD'";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return all the users within the USERS table.
     * 
     * @return result set with all the users
     */
    public ResultSet getAllUsers() throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();
	    Statement statement = myConnection.createStatement();

	    String queryString = "SELECT * FROM USERS";

	    return statement.executeQuery(queryString);
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will insert a new user into the USERS table.
     * 
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
    public boolean insertUser(String username, String password, String email, String phoneNum,
	    String firstName, String lastName, String cardNum, String cardType,
	    String cardExpMon, String cardExpYear, int creatorId) throws ClassNotFoundException, SQLException {
	try {
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

	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will update the tuple in USERS of the passed userId with the given parameters.
     * 
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
	    String cardType, String cardExpMon, String cardExpYear, int creatorId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "UPDATE USERS SET ";
	    queryString += "USERNAME = ?, PASSWORD = ?, EMAIL = ?, PHONE_NUMBER = ?, ";
	    queryString += "FIRST_NAME = ?, LAST_NAME = ?, CARD_NUMBER = ?, CARD_TYPE = ?, ";
	    queryString += "CARD_EXP_MON = ?, CARD_EXP_YR = ?, CREATOR_ID = ? ";
	    queryString += "WHERE USER_ID = ?";

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

	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }
    
    /**
     * Removes a USERS tuple where the USER_ID matches the given userId
     * @param userId
     * @return true if removed, false otherwise
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean removeUser(int userId) throws ClassNotFoundException, SQLException{
	try {
	    Connection myConnection = createConnection();

	    String queryString = "DELETE FROM USERS WHERE USER_ID = ?";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    int rowsModified = preparedStatement.executeUpdate();

	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return a result set containing all data in the COMMISSION_REPORT view.
     * 
     * @return result set of data in COMMISSION_REPORT
     */
    public ResultSet getCommissionReport() throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();
	    Statement statement = myConnection.createStatement();

	    String queryString = "SELECT * FROM COMMISSION_REPORT";

	    return statement.executeQuery(queryString);
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return a result set containing all data in the SALES_REPORT view.
     * 
     * @return result set of data in SALES_REPORT
     */
    public ResultSet getSalesReport() throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();
	    Statement statement = myConnection.createStatement();

	    String queryString = "SELECT * FROM SALES_REPORT";

	    return statement.executeQuery(queryString);
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will insert a new item tuple into the ITEM table.
     * 
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
	    Timestamp auctionEnd, String description, double startPrice, int creatorId,
	    Blob photo) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "INSERT INTO ITEM ";
	    queryString +=	 "(ITEM_NAME, CATEGORY, AUCTION_START, AUCTION_END, ";
	    queryString +=	 "DESCRIPTION, START_PRICE, CREATOR_ID, PHOTO) ";
	    queryString +=	 "VALUES(?,?,?,?,?,?,?,?)";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, itemName);
	    preparedStatement.setString(2, category);
	    preparedStatement.setTimestamp(3, auctionStart);
	    preparedStatement.setTimestamp(4, auctionEnd);
	    preparedStatement.setString(5, description);
	    preparedStatement.setDouble(6, startPrice);
	    preparedStatement.setInt(7, creatorId);
	    preparedStatement.setBlob(8, photo);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }
    
    /**
     * Will remove an ITEM tuple where the ITEM_ID matches the given itemId.
     * @param itemId
     * @return true if removed, false otherwise
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean removeItem(int itemId) throws ClassNotFoundException, SQLException{
	try {
	    Connection myConnection = createConnection();

	    String queryString = "DELETE FROM ITEM WHERE ITEM_ID = ?";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will update the tuple in ITEM of the passed itemId with the given parameters.
     * 
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
    public boolean updateItem(int itemId, String itemName, String category,
	    Timestamp auctionStart, Timestamp auctionEnd, String description,
	    double startPrice, int creatorId, Blob photo) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "UPDATE ITEM SET ";
	    queryString += "ITEM_NAME = ?, CATEGORY = ?, AUCTION_START = ?, AUCTION_END = ?, ";
	    queryString += "DESCRIPTION = ?, START_PRICE = ?, CREATOR_ID = ?, PHOTO = ? ";
	    queryString += "WHERE ITEM_ID = ?";

	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setString(1, itemName);
	    preparedStatement.setString(2, category);
	    preparedStatement.setTimestamp(3, auctionStart);
	    preparedStatement.setTimestamp(4, auctionEnd);
	    preparedStatement.setString(5, description);
	    preparedStatement.setDouble(6, startPrice);
	    preparedStatement.setInt(7, creatorId);
	    preparedStatement.setBlob(8, photo);
	    preparedStatement.setInt(9, itemId);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will call on the stored function insertAuctionBid to insert a bid tuple into the
     * AUCTIONS table.
     * 
     * @param itemId
     * @param userId
     * @param maximumBid
     * @return will return 0 if bid entered successfully, -1 if maxiumumBid is less than the
     *         current bid, -2 if the auction is not currently open, or -3 if another error
     *         occurred
     */
    public int insertAuctionBid(int itemId, int userId, double maximumBid) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    CallableStatement callableStatement = myConnection
		    .prepareCall("{? = call insertAuctionBid(?, ?, ?)}");
	    callableStatement.registerOutParameter(1, Types.INTEGER);
	    callableStatement.setInt(1, itemId);
	    callableStatement.setInt(2, userId);
	    callableStatement.setDouble(3, maximumBid);

	    callableStatement.execute();

	    return callableStatement.getInt(1);
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will insert a feedback tuple into the BUYER_FEEDBACK table for the given itemId.
     * 
     * @param itemId
     * @param satisfaction
     * @param paymentPromptness
     * @param comments
     * @return true if entered, otherwise false
     */
    public boolean insertBuyerFeedback(int itemId, int satisfaction, int paymentPromptness,
	    String comments) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "INSERT INTO BUYER_FEEDBACK VALUES(?, ?, ?, ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);
	    preparedStatement.setInt(2, satisfaction);
	    preparedStatement.setInt(3, paymentPromptness);
	    preparedStatement.setString(4, comments);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }
    
    /**
     * Will remove a buyer feedback tuple where it matches the given itemId.
     * @param itemId
     * @return true if removed, false otherwise
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean removeBuyerFeedback(int itemId) throws ClassNotFoundException, SQLException{
	try {
	    Connection myConnection = createConnection();

	    String queryString = "DELETE FROM BUYER_FEEDBACK WHERE ITEM_ID = ?";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }
    

    /**
     * Will insert a feedback tuple into the SELLER_FEEDBACK table for the given itemId.
     * 
     * @param itemId
     * @param satisfaction
     * @param itemDelivery
     * @param itemQuality
     * @param comments
     * @return true if entered, false if otherwise
     */
    public boolean insertSellerFeedback(int itemId, int satisfaction, int itemDelivery,
	    int itemQuality, String comments) throws ClassNotFoundException, SQLException {
	try {
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
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }
    
    /**
     * Will remove a feedback tuple that matches the given itemId.
     * @param itemId
     * @return true if removed, false otherwise
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean removeSellerFeedback(int itemId) throws ClassNotFoundException, SQLException{
	try {
	    Connection myConnection = createConnection();

	    String queryString = "DELETE FROM SELLER_FEEDBACK WHERE ITEM_ID = ?";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, itemId);

	    int rowsModified = preparedStatement.executeUpdate();
	    if (rowsModified > 0) {
		preparedStatement.close();
		myConnection.close();
		return true;
	    }
	    else {
		preparedStatement.close();
		myConnection.close();
		return false;
	    }
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return the tuples in BUYER_FEEDBACK for the given userId.
     * 
     * @param userId
     * @return Result Set of buyer feedback
     */
    public ResultSet getBuyerFeedback(int userId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM BUYER_FEEDBACK WHERE ITEM_ID IN ";
	    queryString += "(SELECT ITEM_ID FROM ITEM WHERE WINNER_ID = ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    /**
     * Will return the tuples in SELLER_FEEDBACK for the given userId.
     * 
     * @param userId
     * @return Result Set of seller feedback
     * @throws ClassNotFoundException 
     */
    public ResultSet getSellerFeedback(int userId) throws ClassNotFoundException, SQLException {
	try {
	    Connection myConnection = createConnection();

	    String queryString = "SELECT * FROM SELLER_FEEDBACK WHERE ITEM_ID IN ";
	    queryString += "(SELECT ITEM_ID FROM ITEM WHERE CREATOR_ID = ?)";
	    PreparedStatement preparedStatement = myConnection.prepareStatement(queryString);
	    preparedStatement.clearParameters();
	    preparedStatement.setInt(1, userId);

	    return preparedStatement.executeQuery();
	}
	catch (ClassNotFoundException ce) {
	    throw ce;
	}
	catch (SQLException se) {
	    throw se;
	}
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.jdbc.Driver");
	return (DriverManager.getConnection(databaseUrl, username, password));
    }

}
