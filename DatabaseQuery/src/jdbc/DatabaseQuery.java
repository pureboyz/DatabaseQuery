package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public static void InsertQuery()
	{
		// DB 연결정보
		DatabaseInfo databaseInfo = new DatabaseInfo();
		
		Connection 			conn 	= null; 
		PreparedStatement 	pstmt 	= null;
		
		try
		{
			// Driver 로드
			Class.forName(databaseInfo.getJDBC_DRIVER());
			
			// DB 연결
			conn = DriverManager.getConnection(databaseInfo.getURL(), databaseInfo.getUSER(), databaseInfo.getPASSWORD());
			System.out.println("Database Connection Success!!");
			
			// Data 대량 삽입
			int rowsCnt = 10; // 삽입할 row의 수
			for(int i=1; i<=rowsCnt; i++)
			{
				// Query 준비
				String sql = "INSERT INTO QUERY_TEST (COLUMN1, COLUMN2, COLUMN3, COLUMN4, COLUMN5) VALUES(?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				
				// Data Binding
				pstmt.setString(1, "valueA"+i);
				pstmt.setString(2, "valueB"+i);
				pstmt.setString(3, "valueC"+i);
				pstmt.setString(4, "valueD"+i);
				pstmt.setString(5, "valueE"+i);
				
				// Query 실행
				pstmt.executeUpdate(); // 영향을 미친 row의 수를 int형으로 return.
			}
			
			System.out.println("INSERT COMPLETE!!");
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
