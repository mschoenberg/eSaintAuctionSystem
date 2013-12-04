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
	    fail("No item was returned in the result set");
	}
    }
    
    @Test
    public void testSearchItems(){
	
    }
    
    @Test
    public void testGetItemsBidOn(){
	
    }

    @Test
    public void testGetItemsSold(){
	
    }
    
    @Test
    public void testGetItemsWon(){
	
    }
    
    @Test
    public void testGetAllUsers(){
	
    }
    
    @Test 
    public void testInsertUser(){
	
    }
    
    @Test
    public void testUpdateUser(){
	
    }
    
    @Test
    public void testGetComissionReport(){
	
    }
    
    @Test
    public void testGetSalesReport(){
	
    }
    
    @Test
    public void testInsertItem(){
	
    }
    
    @Test
    public void testUpdateItem(){
	
    }
    
    @Test
    public void testInsertAuctionBid(){
	
    }
    
    @Test
    public void testInsertBuyerFeedback(){
	
    }
    
    @Test
    public void testInsertSellerFeedback(){
	
    }
    
    @Test
    public void testGetBuyerFeedback(){
	
    }
    
    @Test
    public void testGetSellerFeedback(){
	
    }
    
}
