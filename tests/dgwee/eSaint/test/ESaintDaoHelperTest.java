package dgwee.eSaint.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;

import dgwee.eSaint.ESaintDaoHelper;

public class ESaintDaoHelperTest {
    private ESaintDaoHelper dao = new ESaintDaoHelper();

    @Test
    public void testLoginAdmin() throws ClassNotFoundException, SQLException{
	String username = "Foo";
	String password = "Bar";
	
	boolean returnValue = dao.loginAdmin(username, password);
	assertTrue(returnValue);
    }
    
    @Test
    public void testLoginUser() throws ClassNotFoundException, SQLException{
	String username = "awzurn";
	String password = "awzurn";
	
	boolean returnValue = dao.loginUser(username, password);
	assertTrue(returnValue);
    }
    
    @Test
    public void testGetAllItems() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getAllItems();
	
	if( !resultSet.next() ){
	    fail("No items in the result set!");
	}
    }
    
    @Test
    public void testGetItem() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItem(1);
	
	if ( !resultSet.next() ){
	    fail("No item was returned in the result set");
	}
	if ( resultSet.getInt(1) != 1 ) {
	    fail("The returned item was not the requested item.");
	}
    }
    
    @Test
    public void testGetItemBidders() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItemBidders(1);
	
	if ( !resultSet.next() ){
	    fail("No users was returned in the result set");
	}
	if ( resultSet.getInt(2) != 1 ){
	    fail("USER_ID 1 made a bid on this item");
	}
    }
    
    @Test
    public void testSearchItems(){
	
    }
    
    @Test
    public void testGetItemsBidOn() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItemsBidOn(1);
	
	if ( !resultSet.next() ){
	    fail("No item was returned in the result set");
	}
	if ( resultSet.getInt(1) != 1 ){
	    fail("USER_ID 1 made a bid on ITEM_ID 1");
	}
    }

    @Test
    public void testGetItemsSold() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItemsSold(1);
	
	if ( !resultSet.next() ){
	    fail("No item was returned in the result set");
	}
	if ( resultSet.getInt(1) != 2  ){
	    fail("USER_ID 1 was the seller of ITEM_ID 2");
	}
    }
    
    @Test
    public void testGetItemsWon() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItemsWon(1);
	
	if ( !resultSet.next() ){
	    fail("No item was returned in the result set");
	}
	if ( resultSet.getInt(1) != 2  ){
	    fail("USER_ID 1 won ITEM_ID 2");
	}
    }
    
    @Test
    public void testGetAllUsers() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getAllUsers();
	
	if ( !resultSet.next() ){
	    fail("No users was returned in the result set");
	}
    }
    
    @Test 
    public void testInsertUser() throws ClassNotFoundException, SQLException{
	boolean wasEntered = dao.insertUser("andrew", "andrew", "email@email.com", "9526495555",
		"Andrew", "Zurn", "6548987623456120", "Visa", "10", "2015", 1);
	
	if( !wasEntered ) {
	    fail("User was not entered into USERS.");
	}
	
	ResultSet resultSet = dao.getAllUsers();
	int userId = 0;
	while (resultSet.next()){
	    if ( resultSet.getString("USERNAME").equals("andrew") ){
		userId = resultSet.getInt("USER_ID");
	    }
	}
	
	if( userId == 0 ){
	    fail("The entered user was not found.");
	}
	
	boolean wasDeleted = dao.removeUser(userId);
	if( !wasDeleted ) {
	    fail("User was not deleted from USERS.");
	}
    }
    
    @Test
    public void testUpdateUser() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getAllUsers();
	int userId = 0;
	while (resultSet.next()){
	    if ( resultSet.getString("USERNAME").equals("awzurn") ){
		userId = resultSet.getInt("USER_ID");
		break;
	    }
	}
	
	boolean wasUpdated = dao.updateUser(userId, "andrewzurn", resultSet.getString(3),
		resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
		resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
		resultSet.getString(10), resultSet.getString(11), resultSet.getInt(12));
	
	if( !wasUpdated ){
	    fail("The user was not updated!");
	}
	
	wasUpdated = dao.updateUser(userId, "awzurn", resultSet.getString(3),
		resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
		resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
		resultSet.getString(10), resultSet.getString(11), resultSet.getInt(12));
	
	if( !wasUpdated ){
	    fail("The user was not updated!");
	}
    }
    
    @Test
    public void testGetComissionReport() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getCommissionReport();
	
	if ( !resultSet.next() ){
	    fail("No comission report was returned in the result set");
	}
    }
    
    @Test
    public void testGetSalesReport() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getSalesReport();
	
	if ( !resultSet.next() ){
	    fail("No sales report was returned in the result set");
	}
    }
    
    @Test
    public void testInsertItem() throws ClassNotFoundException, SQLException{
	boolean wasInserted = dao.insertItem("item", "category", new Timestamp(0),
		new Timestamp(1000000), "description", 10.99, 1, null);
	
	if( !wasInserted ){
	    fail("Item was not inserted!");
	}
	
	ResultSet resultSet = dao.getAllItems();
	int itemId = 0;
	while( resultSet.next() ){
	    if( resultSet.getString("ITEM_NAME").equals("item") ){
		itemId = resultSet.getInt("ITEM_ID");
		break;
	    }
	}
	
	boolean wasDeleted = dao.removeItem(itemId);
	
	if( !wasDeleted ){
	    fail("Item was not deleted!");
	}
    }
    
    @Test
    public void testUpdateItem() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getItem(1);
	resultSet.next();
	String oldItemName = resultSet.getString("ITEM_NAME");
	
	boolean wasUpdated = dao.updateItem(resultSet.getInt("ITEM_ID"), 
		"LOOK I CHANGED", resultSet.getString("CATEGORY"),
		resultSet.getTimestamp("AUCTION_START"), resultSet.getTimestamp("AUCTION_END"),
		resultSet.getString("DESCRIPTION"), resultSet.getDouble("START_PRICE"),
		resultSet.getInt("CREATOR_ID"), resultSet.getBlob("PHOTO"));
	
	if( !wasUpdated ){
	    fail("Item was not updated!");
	}
	
	wasUpdated = dao.updateItem(resultSet.getInt("ITEM_ID"), 
		oldItemName, resultSet.getString("CATEGORY"),
		resultSet.getTimestamp("AUCTION_START"), resultSet.getTimestamp("AUCTION_END"),
		resultSet.getString("DESCRIPTION"), resultSet.getDouble("START_PRICE"),
		resultSet.getInt("CREATOR_ID"), resultSet.getBlob("PHOTO"));
	
	if( !wasUpdated ){
	    fail("Item was not updated!");
	}
    }
    
    @Test
    public void testInsertAuctionBid() throws ClassNotFoundException, SQLException{
	ResultSet item = dao.getItem(1);
	item.next();
	
	double currentBid = item.getDouble("CURRENT_BID");
	int wasEntered = dao.insertAuctionBid(1, 3, (currentBid + 10.0));
	
	if( wasEntered != 0 ){
	    fail("The bid was not entered!");
	}
    }
    
    @Test
    public void testInsertBuyerFeedback(){
	//TODO
    }
    
    @Test
    public void testInsertSellerFeedback(){
	//TODO
    }
    
    @Test
    public void testGetBuyerFeedback() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getBuyerFeedback(1);
	
	if( !resultSet.next() ){
	    fail("Result Set was empty!");
	}
    }
    
    @Test
    public void testGetSellerFeedback() throws ClassNotFoundException, SQLException{
	ResultSet resultSet = dao.getSellerFeedback(2);
	
	if( !resultSet.next() ){
	    fail("Result Set was empty!");
	}	
    }
    
}
