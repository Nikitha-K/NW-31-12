


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	import oracle.jdbc.OracleDriver;
		public class TestDBResultSet {

			public static void main(String[] args) throws SQLException {
				
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				Connection conn = DriverManager.getConnection(url,"scott","tiger");
				System.out.println("Connected");
				
				String qry = "select *from employee";
				PreparedStatement pst = conn.prepareStatement(qry);
				ResultSet rs = pst.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				
				for(int i=1;i<=rsmd.getColumnCount();i++)
					System.out.print(rsmd.getColumnName(i)+"  ");
				System.out.println("\n-----------------------------------");
				
				while(rs.next())
					System.out.println(rs.getInt(1)+" - "+rs.getString("empname")+" - "+rs.getDouble(3));
			}
		}
