package awzurn.eSaint;

import java.io.Serializable;
import java.sql.Timestamp;

public class Auction implements Serializable{
	private int itemId;
	private int userId;
	private double maximumBid;
	private Timestamp bidTime;
	
	public Auction(){
	
	}
	
	public int getItemId(){
		return itemId;
	}
	
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	
	public int getUserId(){
		return userId;
	}
	
	public void setUserId(int userId){
		this.userId = userId;
	}
	
	public double getMaximumBid(){
		return maximumBid;
	}
	
	public void setMaximumBid(double maximumBid){
		this.maximumBid = maximumBid;
	}
	
	public Timestamp getBidTime(){
		return bidTime;
	}
	
	public void setBidTime(Timestamp bidTime){
		this.bidTime = bidTime;
	}

}