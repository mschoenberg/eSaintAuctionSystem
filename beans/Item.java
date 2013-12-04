package dgwee.eSaint;

import java.io.*;
import java.sql.Blob;
import java.sql.Timestamp;

public class Item implements Serializable {

    /* item bean form fields */
    private int itemId;
    private String itemName;
    private String category;
    private Timestamp auctionStart;
    private Timestamp auctionEnd;
    private String description;
    private String status;
    private double startPrice;
    private double currentBid;
    private int winnerId;
    private int creatorId;
    private Blob photo;

    /* other item related fields */

    public Item() {

    }

    public int getItemId() {
 return itemId;
    }

    public void setItemId(int itemId) {
 this.itemId = itemId;
    }

    public String getItemName() {
 return itemName;
    }

    public void setItemName(String itemName) {
 this.itemName = itemName;
    }

    public String getCategory() {
 return category;
    }

    public void setCategory(String category) {
 this.category = category;
    }

    public Timestamp getAuctionStart() {
 return auctionStart;
    }

    public void setAuctionStart(Timestamp auctionStart) {
 this.auctionStart = auctionStart;
    }

    public Timestamp getAuctionEnd() {
 return auctionEnd;
    }

    public void setAuctionEnd(Timestamp auctionEnd) {
 this.auctionEnd = auctionEnd;
    }

    public String getDescription() {
 return description;
    }

    public void setDescription(String description) {
 this.description = description;
    }

    public String getStatus() {
 return status;
    }

    public void setStatus(String status) {
 this.status = status;
    }

    public double getStartPrice() {
 return startPrice;
    }

    public void setStartPrice(double startPrice) {
 this.startPrice = startPrice;
    }

    public double getCurrentBid() {
 return currentBid;
    }

    public void setCurrentBid(double currentBid) {
 this.currentBid = currentBid;
    }

    public int getWinnerId() {
 return winnerId;
    }

    public void setWinnerId(int winnerId) {
 this.winnerId = winnerId;
    }

    public int getCreatorId() {
 return creatorId;
    }

    public void setCreatorId(int creatorId) {
 this.creatorId = creatorId;
    }

    public Blob getPhoto() {
 return photo;
    }

    public void setPhoto(Blob photo) {
 this.photo = photo;
    }
}
