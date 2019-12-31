//PROGRAM TO DEMONSTRATE JDBC SAMPLE CONNECTION

import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class TestDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		DriverManager.getConnection(url,"scott","tiger");
		System.out.println("Connected");
		
	}

}
