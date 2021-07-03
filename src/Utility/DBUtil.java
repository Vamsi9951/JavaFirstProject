package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String url="jdbc:mysql://localhost:3306/gymdatabase1";
	private static final String usName="root";
	private static final String pswd="Vamsi@123";
	
	
		public static Connection getConnection()
		{
			Connection con=null;
			try
			{
				con=DriverManager.getConnection(url,usName,pswd);
				System.out.println("Database connected..");
				
			}catch(SQLException e)
			{
				System.out.println("Database not connected..");
			}
			return con;
		}
		public static void closeResource(Connection connection)
		{
			if(connection!=null)
			{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		public static void closeResource(Statement Statement)
		{
			if(Statement!=null)
			{
			try {
				Statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		public static void closeResource(PreparedStatement preparedStatement)
		{
			if(preparedStatement!=null)
			{
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
}
