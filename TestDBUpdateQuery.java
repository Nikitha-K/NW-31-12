
	//program to demonstrate Statement and PreparedStatement in JDBC


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	import oracle.jdbc.OracleDriver;

	public class TestDBUpdateQuery {
	
			public static void main(String[] args) throws SQLException {
				
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				Connection conn = DriverManager.getConnection(url,"scott","tiger");
				System.out.println("Connected");
				
				String qry = "update employee set empname=?,sal=?where empno=?";
				PreparedStatement pst = conn.prepareStatement(qry);
				pst.setString(1,  "sri");
				pst.setDouble(2,  86326);
				pst.setInt(3,  101);		
				System.out.println("Row is updated with the given details");
				/* String qry = "insert into employee values(?,?,?)";*/
				
				
				int rows = pst.executeUpdate();
				System.out.println("Inserted "+rows); 
				conn.close();
				

		}






}
