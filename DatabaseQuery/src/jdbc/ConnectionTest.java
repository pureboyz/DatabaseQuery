package jdbc;

import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Date 		: 2019. 11. 14.
 * Author 		: pureboyz
 *
 * 각종 쿼리 메소드를 테스트하는 클래스.
 * 
 * </pre>
 */
public class ConnectionTest
{
	public static void main(String[] args)
	{
		// InsertQuery
//		DatabaseQuery.InsertQuery();
		
		// SelectQuery
		List<Map<String, Object>> resultList = DatabaseQuery.SelectQuery();
		for(int i=0; i<resultList.size(); i++)
		{
			System.out.println("Row " + i + " : " + resultList.get(i).toString());
		}
	}
}
