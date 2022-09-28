package infinite.stockproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchStockMain {
    public static void main(String[] args) {
		Connection con;
		PreparedStatement ps;
		StockDAO dao=new StockDAO();
		try {
			con=ConnectionHelper.getConnection();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Stock Id");
			String stockid=sc.next();
			System.out.println(dao.searchStock(stockid));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
