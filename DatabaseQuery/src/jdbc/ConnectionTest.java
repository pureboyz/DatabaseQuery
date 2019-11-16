package jdbc;

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
	public static void main(String[] args) {
		DatabaseQuery dq = new DatabaseQuery();
		
		dq.SelectQuery();
//		dq.InsertQuery();
//		dq.UpdateQuery();
//		dq.DeleteQuery();
	}
}
