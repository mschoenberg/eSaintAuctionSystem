package awzurn.eSaint;

public class SellerFeedback{
	private int itemId;
	private int satisfaction;
	private int itemDelivery;
	private int itemQuality;
	private String comments;
	
	public SellerFeedback(){
	
	}
	
	public int getItemId(){
		return itemId;
	}
	
	public void setItemId(int itemId){
		this.itemId = itemId;
	}
	
	public int getSatisfaction(){
		return satisfaction;
	}
	
	public void setSatisfaction(int satisfaction){
		this.satisfaction = satisfaction;
	}
	
	public int getItemDelivery(){
		return itemDelivery();
	}
	
	public void setItemDelivery(int itemDelivery){
		this.itemDelivery = itemDelivery;
	}
	
	public int getItemQuality(){
		return itemQuality;
	}
	
	public void setItemQuality(int itemQuality){
		this.itemQuality = itemQuality;
	}
	
	public String getComments(){
		return comments;
	}
	
	public void setComments(String comments){
		this.comments = comments;
	}

}