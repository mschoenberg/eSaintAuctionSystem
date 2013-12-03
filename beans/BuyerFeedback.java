package awzurn.eSaint;

public class BuyerFeedback implements Serializable{
	private int itemId;
	private int satisfaction;
	private int paymentPromptness;
	private String comments;
	 
	public BuyerFeedback(){
	
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
	
	public int getPaymentPromptness(){
		return paymentPromptness;
	}
	
	public void setPaymentPromptness(int paymentPromptness){
		this.paymentPromptness = paymentPromptness;
	}
	
	public String getComments(){
		return comments;
	}
	
	public void setComments(String comments){
		this.comments = comments;
	}
	
}