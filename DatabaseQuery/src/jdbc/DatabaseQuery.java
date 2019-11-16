package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <pre>
 * Date 		: 2019. 11. 14.
 * Author 		: pureboyz
 *
 * SELECT, UPDATE, INSERT, DELETE 쿼리를 날리는 메소드들이 있는 클래스.
 * 
 * </pre>
 */
public class DatabaseQuery
{
	public void SelectQuery()
	{
		// DB 연결정보
		DatabaseInfo di = new DatabaseInfo();
		
		Connection conn = null; 
		Statement state = null;
		
		try
		{
			Class.forName(di.getJDBC_DRIVER());
			conn = DriverManager.getConnection(di.getURL(), di.getUSER(), di.getPASSWORD());
			System.out.println("Database Connection Success!!");
			state = conn.createStatement();
			
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
