package infinite.stockproject;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockDAO {
	 Connection con;
	 PreparedStatement ps;
     public String generateStockId() throws ClassNotFoundException, SQLException{
    	
    	 con=ConnectionHelper.getConnection();
    	 String sql="SELECT MAX(stockid) sid FROM stock";
    	 ps=con.prepareStatement(sql);
    	 ResultSet rs=ps.executeQuery();
    	 rs.next();
         String stockId=rs.getString("sid");
         int id = Integer.parseInt(stockId.substring(1));
         id++;
         stockId=String.format("S%03d", id);
    	 return stockId;
     }
      public Stock searchStock(String stockid) throws ClassNotFoundException, SQLException{
    	  con=ConnectionHelper.getConnection();
    	  String sql="select * from stock where stockid=?";
    	  ps=con.prepareStatement(sql);
    	  ps.setString(1, stockid);
    	  ResultSet rs=ps.executeQuery();
    	  Stock stock=null;
    	  if(rs.next()){
    		  stock=new Stock();
    		  stock.setStckId(rs.getString("stockid"));
  			stock.setItemName(rs.getString("ItemName"));
  			stock.setPrice(rs.getDouble("Price"));
  			stock.setQualityAvail(rs.getInt("QuantityAvail"));
  			
    	  }return stock;
      }
     public List<Stock> showStock() throws ClassNotFoundException, SQLException{
    	List<Stock> stockList=new ArrayList<Stock>();
    	con=ConnectionHelper.getConnection();
    	String sql="select * from stock";
    	ps=con.prepareStatement(sql);
    	ResultSet rs=ps.executeQuery();
    	Stock stock=null;
    	while(rs.next()){
    			stock=new Stock();
    			stock.setStckId(rs.getString("stockid"));
    			stock.setItemName(rs.getString("ItemName"));
    			stock.setPrice(rs.getDouble("Price"));
    			stock.setQualityAvail(rs.getInt("QuantityAvail"));
    			stockList.add(stock);
     }return stockList;
     }
     
     public String addStock(Stock stock) throws ClassNotFoundException, SQLException{
    	 con=ConnectionHelper.getConnection();
    	 String stockId=generateStockId();
    	 stock.setStckId(stockId);
    	 String sql="insert into stock(stockid,ItemName,Price,QuantityAvail)values(?,?,?,?)";
    	 ps=con.prepareStatement(sql);
    	 ps.setString(1, stock.getStckId());
    	 ps.setString(2, stock.getItemName());
    	 ps.setDouble(3, stock.getPrice());
    	 ps.setInt(4, stock.getQualityAvail());
    	 ps.executeUpdate();
    	 return "Record added...";
     }
     
}
