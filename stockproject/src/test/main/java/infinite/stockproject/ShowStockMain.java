package infinite.stockproject;

import java.sql.SQLException;
import java.util.List;

public class ShowStockMain {
   public static void main(String[] args) {
	StockDAO dao=new StockDAO();
	try {
		List<Stock> stockList=dao.showStock();
		for (Stock stock : stockList) {
			System.out.println(stock);
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
