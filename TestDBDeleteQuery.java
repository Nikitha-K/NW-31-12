	//program to demonstrate Statement and PreparedStatement in JDBC


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	import oracle.jdbc.OracleDriver;

	public class TestDBDeleteQuery {
	
			public static void main(String[] args) throws SQLException {
				
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				Connection conn = DriverManager.getConnection(url,"scott","tiger");
				System.out.println("Connected");
				
				String qry = "delete from employee where empno=?";
				PreparedStatement pst = conn.prepareStatement(qry);
				
				pst.setInt(1,  101);		
				System.out.println("Row is deleted");
				/* String qry = "insert into employee values(?,?,?)";*/
				
				
				int rows = pst.executeUpdate();
				System.out.println("Deleted "+rows); 
				conn.close();
				

		}






}

