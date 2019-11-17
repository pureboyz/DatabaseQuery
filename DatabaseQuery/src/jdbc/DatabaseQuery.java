package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	/**
	 * <pre>
	 * MethodName 	: InsertQuery
	 * Date 		: 2019. 11. 17.
	 * Author 		: pureboyz
	 * 
	 * ParamsType 	: 
	 * ReturnType 	: void
	 *
	 * JDBC INSERT QUERY
	 * sample data를 대량으로 insert할 때 사용.
	 * 
	 * </pre>
	 */
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
				pstmt.setString(1, "valueAA"+i);
				pstmt.setString(2, "valueBB"+i);
				pstmt.setString(3, "valueCC"+i);
				pstmt.setString(4, "valueDD"+i);
				pstmt.setString(5, "valueEE"+i);
				
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
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static List<Map<String, Object>> SelectQuery()
	{
		// DB 연결정보
		DatabaseInfo databaseInfo = new DatabaseInfo();
		
		Connection 					conn 		= null; 
		PreparedStatement 			pstmt 		= null;
		ResultSet 					resultSet 	= null;
		List<Map<String, Object>>	resultList 	= new ArrayList<>();
		
		try
		{
			// Driver 로드
			Class.forName(databaseInfo.getJDBC_DRIVER());
			
			// DB 연결
			conn = DriverManager.getConnection(databaseInfo.getURL(), databaseInfo.getUSER(), databaseInfo.getPASSWORD());
			System.out.println("Database Connection Success!!");
			
			// Query 준비
			String sql = "SELECT * FROM QUERY_TEST WHERE SEQ <= ?";
			pstmt = conn.prepareStatement(sql);
			
			// Data Binding
			pstmt.setInt(1, 6);
			
			// Query 실행
			resultSet = pstmt.executeQuery();
			
			System.out.println("SELECT COMPLETE!!");
			
			// 얻은 Data를 List에 담기
			while(resultSet.next())
			{
				Map<String, Object> resultMap = new HashMap<>();
				
				resultMap.put("column1", resultSet.getString("column1"));
				resultMap.put("column2", resultSet.getString("column2"));
				resultMap.put("column3", resultSet.getString("column3"));
				resultMap.put("column4", resultSet.getString("column4"));
				resultMap.put("column5", resultSet.getString("column5"));
				
				resultList.add(resultMap);
			}
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				pstmt.close();
				conn.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return resultList;
	}
	
}
