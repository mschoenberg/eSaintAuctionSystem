package dgwee.eSaint.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void testInsertUser(){
	//TODO
    }
    
    @Test
    public void testUpdateUser(){
	//TODO
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
    public void testInsertItem(){
	//TODO
    }
    
    @Test
    public void testUpdateItem(){
	//TODO
    }
    
    @Test
    public void testInsertAuctionBid(){
	//TODO
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
    public void testGetBuyerFeedback(){
	//TODO
    }
    
    @Test
    public void testGetSellerFeedback(){
	//TODO
    }
    
}
