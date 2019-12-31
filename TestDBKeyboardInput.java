	//program to demonstrate Statement and PreparedStatement in JDBC


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	import oracle.jdbc.OracleDriver;

	
	public class TestDBKeyboardInput {
			public static void main(String[] args) throws SQLException {
				
				OracleDriver driver = new OracleDriver();
				DriverManager.registerDriver(driver);
				String url = "jdbc:oracle:thin:@localhost:1521:orcl";
				Connection conn = DriverManager.getConnection(url,"scott","tiger");
				System.out.println("Connected");
				for(int i=0; true; i++)
				{
					
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the employee no");
				int empno = sc.nextInt();
				
				System.out.println("Enter the employee name");
				String empname = sc.next();
				
				System.out.println("Enter the employee salary");
				int sal = sc.nextInt();
				
				Statement st = conn.createStatement();
				String qry = "insert into employee values("+empno+", '"+empname+"' ,"+sal+")";
				st.executeUpdate(qry);
				
				System.out.println("Row is inserted with the given details: empno is "+empno+", emp name is "+empname+", emp salary is "+sal);
				
				/* String qry = "insert into employee values(?,?,?)";
				PreparedStatement pst = conn.prepareStatement(qry);
				pst.setInt(1,  101);
				pst.setString(2,  "deloitte");
				pst.setDouble(3,  87687);
				
				int rows = pst.executeUpdate();*/
				//System.out.println("Inserted "+rows); 
				conn.close();
				System.out.println("Enter j = 10 to break");
				int j = sc.nextInt();
				
				if(j==10)
					break;
				//continue;
				}
			}

		}





