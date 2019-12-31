//program to demonstrate Statement and PreparedStatement in JDBC


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

	public class TestDB1 {

		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub

			OracleDriver driver = new OracleDriver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			Connection conn = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("Connected");
			
			Statement st = conn.createStatement();
			String qry = "insert into employee values(526, 'dhvh' ,56326)";
			st.executeUpdate(qry);
			
			/* String qry = "insert into employee values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(qry);
			pst.setInt(1,  101);
			pst.setString(2,  "deloitte");
			pst.setDouble(3,  87687);
			
			int rows = pst.executeUpdate();
			System.out.println("Inserted "+rows); */
			conn.close();
			
			
		}

	}



