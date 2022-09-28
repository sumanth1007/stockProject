package infinite.stockproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddStockMain {
  public static void main(String[] args) {
	
	StockDAO dao=new StockDAO();
	Stock stock=new Stock();
	Scanner sc=new Scanner(System.in);
	
	System.out.println("Enter Item Name");
	stock.setItemName(sc.next());
	System.out.println("Enter Price");
	stock.setPrice(sc.nextDouble());
	System.out.println("Enter Quantity Avail");
	stock.setQualityAvail(sc.nextInt());
	
	try {
		System.out.println(dao.addStock(stock));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
