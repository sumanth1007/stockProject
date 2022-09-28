package infinite.stockproject;

public class Stock {
      private String stckId;
      private String itemName;
      private double price;
      private int qualityAvail;
	
      
	@Override
	public String toString() {
		return "Stock [stckId=" + stckId + ", itemName=" + itemName + ", price=" + price + ", qualityAvail="
				+ qualityAvail + "]";
	}
	public Stock(String stckId, String itemName, double price, int qualityAvail) {
		
		this.stckId = stckId;
		this.itemName = itemName;
		this.price = price;
		this.qualityAvail = qualityAvail;
	}
	public Stock() {
	
	}
	public String getStckId() {
		return stckId;
	}
	public void setStckId(String stckId) {
		this.stckId = stckId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQualityAvail() {
		return qualityAvail;
	}
	public void setQualityAvail(int qualityAvail) {
		this.qualityAvail = qualityAvail;
	}
	
      
      
      
}
